package com.example.dormeaseuser.ui.home



import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dormeaseuser.R


class MessActivity : AppCompatActivity() {

    private lateinit var tvBreakfast: TextView
    private lateinit var tvLunch: TextView
    private lateinit var tvSnacks: TextView
    private lateinit var tvDinner: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess)

        // Initialize the TextViews
        tvBreakfast = findViewById(R.id.tv_breakfast)
        tvLunch = findViewById(R.id.tv_lunch)
        tvSnacks = findViewById(R.id.tv_snacks)
        tvDinner = findViewById(R.id.tv_dinner)

        // Initialize Buttons
        val btnMonday: Button = findViewById(R.id.btn_monday)
        val btnTuesday: Button = findViewById(R.id.btn_tuesday)
        val btnWednesday: Button = findViewById(R.id.btn_wednesday)
        val btnThursday: Button = findViewById(R.id.btn_thursday)
        val btnFriday: Button = findViewById(R.id.btn_friday)
        val btnSaturday: Button = findViewById(R.id.btn_saturday)
        val btnSunday: Button = findViewById(R.id.btn_sunday)

        // Set click listeners for each button
        btnMonday.setOnClickListener { showMenuForDay("Monday") }
        btnTuesday.setOnClickListener { showMenuForDay("Tuesday") }
        btnWednesday.setOnClickListener { showMenuForDay("Wednesday") }
        btnThursday.setOnClickListener { showMenuForDay("Thursday") }
        btnFriday.setOnClickListener { showMenuForDay("Friday") }
        btnSaturday.setOnClickListener { showMenuForDay("Saturday") }
        btnSunday.setOnClickListener { showMenuForDay("Sunday") }

        // Show default menu for Monday when the app starts
        showMenuForDay("Monday")
    }

    // Function to show menu based on the selected day
    private fun showMenuForDay(day: String) {
        when (day) {
            "Monday" -> {
                tvBreakfast.text = getString(R.string.monday_breakfast)
                tvLunch.text = getString(R.string.monday_lunch)
                tvSnacks.text = getString(R.string.monday_snacks)
                tvDinner.text = getString(R.string.monday_dinner)
            }
            "Tuesday" -> {
                tvBreakfast.text = getString(R.string.tuesday_breakfast)
                tvLunch.text = getString(R.string.tuesday_lunch)
                tvSnacks.text = getString(R.string.tuesday_snacks)
                tvDinner.text = getString(R.string.tuesday_dinner)
            }
            "Wednesday" -> {
                tvBreakfast.text = getString(R.string.wednesday_breakfast)
                tvLunch.text = getString(R.string.wednesday_lunch)
                tvSnacks.text = getString(R.string.wednesday_snacks)
                tvDinner.text = getString(R.string.wednesday_dinner)
            }
            "Thursday" -> {
                tvBreakfast.text = getString(R.string.thursday_breakfast)
                tvLunch.text = getString(R.string.thursday_lunch)
                tvSnacks.text = getString(R.string.thursday_snacks)
                tvDinner.text = getString(R.string.thursday_dinner)
            }
            "Friday" -> {
                tvBreakfast.text = getString(R.string.friday_breakfast)
                tvLunch.text = getString(R.string.friday_lunch)
                tvSnacks.text = getString(R.string.friday_snacks)
                tvDinner.text = getString(R.string.friday_dinner)
            }
            "Saturday" -> {
                tvBreakfast.text = getString(R.string.saturday_breakfast)
                tvLunch.text = getString(R.string.saturday_lunch)
                tvSnacks.text = getString(R.string.saturday_snacks)
                tvDinner.text = getString(R.string.saturday_dinner)
            }
            "Sunday" -> {
                tvBreakfast.text = getString(R.string.sunday_breakfast)
                tvLunch.text = getString(R.string.sunday_lunch)
                tvSnacks.text = getString(R.string.sunday_snacks)
                tvDinner.text = getString(R.string.sunday_dinner)
            }
        }
    }
}
