package com.example.dormeaseuser.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.dormeaseuser.R
import com.example.dormeaseuser.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // SharedPreferences to store the dark mode state
    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "theme_prefs"
    private val PREFS_THEME_KEY = "is_dark_mode"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Set up the switch for dark mode
        val themeSwitch: Switch = root.findViewById(R.id.theme_switch)

        // Load the saved theme preference and apply it
        val isDarkMode = sharedPreferences.getBoolean(PREFS_THEME_KEY, false)
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            themeSwitch.isChecked = true
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            themeSwitch.isChecked = false
        }

        // Handle dark mode switch toggle
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                saveThemePreference(true)
            } else {
                // Switch to light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                saveThemePreference(false)
            }
        }

        // Setup buttons (just like in the previous code)
        val messButton: ImageButton = root.findViewById(R.id.imagebt_hr)
        messButton.setOnClickListener {
            // Handle mess button click here
        }

        val complaintsButton: ImageButton = root.findViewById(R.id.imagebt_bp)
        complaintsButton.setOnClickListener {
            // Handle complaints button click here
        }

        // Other buttons setup (e.g., attendance, council)...
        val attendanceButton: ImageButton = root.findViewById(R.id.imagebt_attendance)
        attendanceButton.setOnClickListener {
            // Handle attendance button click here
        }

        val councilButton: ImageButton = root.findViewById(R.id.imagebt_council)
        councilButton.setOnClickListener {
            // Handle council button click here
        }

        return root
    }

    // Save the theme preference in SharedPreferences
    private fun saveThemePreference(isDarkMode: Boolean) {
        sharedPreferences.edit().putBoolean(PREFS_THEME_KEY, isDarkMode).apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
