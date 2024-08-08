package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var notificationsSwitch: SwitchCompat
    private lateinit var darkModeSwitch: SwitchCompat
    private lateinit var saveSettingsButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationsSwitch = view.findViewById(R.id.notificationsSwitch)
        darkModeSwitch = view.findViewById(R.id.darkModeSwitch)
        saveSettingsButton = view.findViewById(R.id.saveSettingsButton)

        // Load current settings (this is just a placeholder, replace with actual data retrieval)
        loadSettings()

        saveSettingsButton.setOnClickListener {
            // Save settings (this is just a placeholder, replace with actual save logic)
            val notificationsEnabled = notificationsSwitch.isChecked
            val darkModeEnabled = darkModeSwitch.isChecked

            // Show a confirmation message
            Toast.makeText(requireContext(), "Settings saved", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadSettings() {
        // Placeholder settings data, replace with actual data retrieval logic
        notificationsSwitch.isChecked = true
        darkModeSwitch.isChecked = false
    }
}
