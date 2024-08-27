package com.example.kubaduservices1

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore


class LoanFragment : Fragment() {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var loanAmountEditText: EditText
    private lateinit var interestRateTextView: TextView
    private lateinit var applyLoanButton: Button
    private lateinit var loanNotificationTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.loan_fragment, container, false)

        // Initialize UI elements
        loanAmountEditText = view.findViewById(R.id.loanAmountEditText)
        interestRateTextView = view.findViewById(R.id.interestRateTextView)
        applyLoanButton = view.findViewById(R.id.applyLoanButton)
        loanNotificationTextView = view.findViewById(R.id.loanNotificationTextView)

        // Set interest rate text
        interestRateTextView.text = "Interest Rate: 30%"

        applyLoanButton.setOnClickListener {
            val amountText = loanAmountEditText.text.toString()
            if (amountText.isNotEmpty()) {
                AlertDialog.Builder(requireContext())
                    .setTitle("Confirm Loan Application")
                    .setMessage("Are you sure you want to apply for a loan of R$amountText?\n\nInterest Rate: 30%")
                    .setPositiveButton("Confirm") { dialog, _ ->
                        // Submit loan request
                        submitLoanRequest(amountText)
                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            } else {
                Toast.makeText(context, "Please enter a valid loan amount", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun submitLoanRequest(amount: String) {

        val loanRequest = hashMapOf(
            "amount" to amount,
            "requestType" to "personalLoan",
            "interestRate" to "30%",
            "status" to "Pending"
        )

        // Add the loan request to Firestore
        db.collection("Requests")
            .add(loanRequest)
            .addOnSuccessListener {
                // Display a success message
                Toast.makeText(context, "Loan request of R$amount submitted successfully!", Toast.LENGTH_LONG).show()

                // Display a follow-up message
                Toast.makeText(context, "We will get back to you via email.", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                // Display an error message
                Toast.makeText(context, "Failed to submit loan request: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

}
