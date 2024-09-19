package com.example.dormeaseadmin.Complaint.RegisterComp.Status

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dormeaseuser.R
import com.example.dormeaseuser.network.RetrofitClient
import com.example.dormeaseuser.ui.home.Complaints
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatusActivity : AppCompatActivity() {

    private lateinit var recyclerViewStatus: RecyclerView
    private lateinit var complaintListAdapter: ComplaintListAdapter
    private lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        recyclerViewStatus = findViewById(R.id.recyclerViewStatus)
        recyclerViewStatus.layoutManager = LinearLayoutManager(this)

        progressBar = findViewById(R.id.progressBar)

        acceptComplaint()

        progressBar.visibility = View.VISIBLE
    }

    private fun acceptComplaint() {
        try {
            val call: Call<List<Complaints>> = RetrofitClient.apiService.getComplaint()

            call.enqueue(object : Callback<List<Complaints>> {
                override fun onResponse(call: Call<List<Complaints>>, response: Response<List<Complaints>>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        response.body()?.let { complaints ->
                            Log.d("Main", "success! $complaints")
                            complaintListAdapter = ComplaintListAdapter(complaints)
                            recyclerViewStatus.adapter = complaintListAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<List<Complaints>>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Log.e("Main", "Failed mate ${t.message}")
                }
            })
        } catch (e: Exception) {
            progressBar.visibility = View.GONE
            Log.e("Main", "Exception: ${e.message}")
        }
    }
}
