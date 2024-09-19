package com.example.dormeaseadmin.Complaint.RegisterComp.Status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.example.dormeaseadmin.Integration.Complain
//import com.example.dormeaseadmin.R
import com.example.dormeaseuser.R
import com.example.dormeaseuser.ui.home.Complaints

class ComplaintListAdapter(private val complaints: List<Complaints>) : RecyclerView.Adapter<ComplaintListAdapter.ComplaintViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplaintViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_complaint, parent, false)
        return ComplaintViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComplaintViewHolder, position: Int) {
        val complaint = complaints[position]
        holder.bind(complaint)
    }

    override fun getItemCount(): Int = complaints.size

    class ComplaintViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        private val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)
        private val textViewType: TextView = itemView.findViewById(R.id.textViewType)
        private val textViewRoomNo: TextView = itemView.findViewById(R.id.textViewRoomNo)
        private val textViewProblem: TextView = itemView.findViewById(R.id.textViewProblem)
        private val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        private val textViewMailId: TextView = itemView.findViewById(R.id.textViewMailId)
        private val buttonPending: Button = itemView.findViewById(R.id.buttonPending)
        private val buttonEdit: Button = itemView.findViewById(R.id.buttonEdit)

        fun bind(complaint: Complaints) {
            textViewDate.text = "Date: ${complaint.date}"
            textViewTime.text = "Time: ${complaint.time}"
            textViewType.text = "Type: ${complaint.type}"
            textViewRoomNo.text = "Room No: ${complaint.roomNo}"
            textViewProblem.text = "Problem: ${complaint.problem}"
            textViewDescription.text = "Description: ${complaint.description}"
            textViewMailId.text = complaint.mailId

            buttonPending.setOnClickListener {
                // Handle pending button click
            }

            buttonEdit.setOnClickListener {
                // Handle edit button click
            }
        }
    }
}