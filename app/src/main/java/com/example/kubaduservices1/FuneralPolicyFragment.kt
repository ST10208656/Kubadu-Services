package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class FuneralPolicyFragment : Fragment() {

    private lateinit var policyTypeDropdown: Spinner
    private lateinit var policyDetailsTextView: TextView
    private lateinit var applyPolicyButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.funeral_policy_fragment, container, false)

        policyTypeDropdown = view.findViewById(R.id.policyTypeSpinner)
        policyDetailsTextView = view.findViewById(R.id.policyDetailsTextView)
        applyPolicyButton = view.findViewById(R.id.applyPolicyButton)

        val policyTypes = resources.getStringArray(R.array.policy_types)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, policyTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        policyTypeDropdown.adapter = adapter

        policyTypeDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedPolicyType = policyTypes[position]
                val policyDetailsArray = when (selectedPolicyType) {
                    "Basic Funeral Policy" -> resources.getStringArray(R.array.funeral_policy_details_basic)
                    "Premium Funeral Policy" -> resources.getStringArray(R.array.funeral_policy_details_premium)
                    else -> emptyArray()
                }
                policyDetailsTextView.text = policyDetailsArray.joinToString("\n")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        applyPolicyButton.setOnClickListener {
            val selectedPolicyType = policyTypes[policyTypeDropdown.selectedItemPosition]
            val policyDetails = policyDetailsTextView.text.toString()

            AlertDialog.Builder(requireContext())
                .setTitle("Confirm Policy Application")
                .setMessage("Are you sure you want to apply for the following policy?\n\nType: $selectedPolicyType\n\nDetails:\n$policyDetails")
                .setPositiveButton("Confirm") { dialog, _ ->
                    // Handle the policy application logic here
                    // For now, we just show a success message
                    Toast.makeText(requireContext(), "Policy applied successfully!", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        return view
    }
}
