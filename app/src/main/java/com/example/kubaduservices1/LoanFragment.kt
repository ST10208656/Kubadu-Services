package com.example.kubaduservices1

import android.app.AlertDialog
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
import androidx.fragment.app.Fragment


class LoanFragment : Fragment() {

    private lateinit var loanTypeSpinner: Spinner
    private lateinit var loanDetailsTextView: TextView
    private lateinit var applyLoanButton: Button
    private lateinit var loanNotificationTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.loan_fragment, container, false)


        loanTypeSpinner = view.findViewById(R.id.loanTypeSpinner);
        loanDetailsTextView = view.findViewById(R.id.loanDetailsTextView);
        applyLoanButton = view.findViewById(R.id.applyLoanButton);
        loanNotificationTextView = view.findViewById(R.id.loanNotificationTextView);
// Set up loan type spinner
        val adapter = this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.loan_types,
                android.R.layout.simple_spinner_item
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        loanTypeSpinner.adapter = adapter

        loanTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateLoanDetails(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        applyLoanButton.setOnClickListener {
            val selectedLoanType = loanTypeSpinner.selectedItem.toString()
            if (selectedLoanType != "Please select a loan type") {
                AlertDialog.Builder(requireContext())
                    .setTitle("Confirm Loan Application")
                    .setMessage("Are you sure you want to apply for the following loan?\n\nType: $selectedLoanType\n\nDetails:\n${loanDetailsTextView.text}")
                    .setPositiveButton("Confirm") { dialog, _ ->
                        // Submit loan request
                        submitLoanRequest(selectedLoanType)
                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            } else {
                Toast.makeText(context, "Please select a valid loan type", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
    private fun updateLoanDetails(position: Int) {
        val loanDetails = resources.getStringArray(R.array.loan_details)
        loanDetailsTextView.text = loanDetails[position]

    }

    private fun submitLoanRequest(selectedLoanType: String) {
        // Implement your code to submit loan request here
        // You can display a success message or handle the request as needed
        Toast.makeText(context, "Loan request for $selectedLoanType submitted successfully!", Toast.LENGTH_LONG).show()    }
}
