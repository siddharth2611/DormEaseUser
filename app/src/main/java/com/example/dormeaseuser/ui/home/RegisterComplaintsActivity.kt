package com.example.dormeaseuser.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.dormeaseadmin.Complaint.RegisterComp.Status.StatusActivity
import com.example.dormeaseuser.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RegisterComplaintsActivity : AppCompatActivity() {

    private lateinit var spinnerType: Spinner
    private lateinit var editTextRoomNo: EditText
    private lateinit var editTextProblem: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonSubmit: Button
    private val userMailId = "user@example.com" // Replace with actual mail ID retrieval method

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_complaints)

        spinnerType = findViewById(R.id.spinnerType)
        editTextRoomNo = findViewById(R.id.editTextRoomNo)
        editTextProblem = findViewById(R.id.editTextProblem)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val type = spinnerType.selectedItem.toString()
            val roomNo = editTextRoomNo.text.toString()
            val problem = editTextProblem.text.toString()
            val description = editTextDescription.text.toString()

            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

            val complaint = Complaints(date, time, type, roomNo, problem, description, userMailId)

            saveComplaintToSharedPreferences(complaint)

            val intent = Intent(this, StatusActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveComplaintToSharedPreferences(complaint: Complaints) {
        val sharedPreferences = getSharedPreferences("complaints_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()

        val complaints = loadComplaintsFromSharedPreferences().toMutableList()
        complaints.add(complaint)

        val json = gson.toJson(complaints)
        editor.putString("complaints", json)
        editor.apply()
    }

    private fun loadComplaintsFromSharedPreferences(): List<Complaints> {
        val sharedPreferences = getSharedPreferences("complaints_prefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("complaints", null)
        val type = object : TypeToken<List<Complaints>>() {}.type
        return if (json != null) {
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}
