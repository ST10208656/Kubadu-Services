package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    private lateinit var fullNameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var editProfileButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fullNameTextView = view.findViewById(R.id.fullNameTextView)
        emailTextView = view.findViewById(R.id.emailTextView)
        phoneTextView = view.findViewById(R.id.phoneTextView)
        addressTextView = view.findViewById(R.id.addressTextView)
        editProfileButton = view.findViewById(R.id.editProfileButton)

        // Load user profile information (this is just a placeholder, replace with actual data retrieval)
        loadUserProfile()

        editProfileButton.setOnClickListener {
            // Handle edit profile action
            // For example, navigate to an EditProfileFragment or open a dialog to edit profile
        }
    }

    private fun loadUserProfile() {
        // Placeholder user data, replace with actual data retrieval logic
        fullNameTextView.text = "Keanon"
        emailTextView.text = "kp@gmail.com"
        phoneTextView.text = "+1234567890"
        addressTextView.text = "1234 Main St, Anytown, South Africa"
    }
}
