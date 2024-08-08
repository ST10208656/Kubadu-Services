package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var recentRequestsRecyclerView: RecyclerView
    private lateinit var notificationsTextView: TextView
    private lateinit var newsTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recentRequestsRecyclerView = view.findViewById(R.id.recentRequestsRecyclerView)
        notificationsTextView = view.findViewById(R.id.notificationsTextView)
        newsTextView = view.findViewById(R.id.newsTextView)

        // Set up RecyclerView
        recentRequestsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val serviceRequests = listOf(
            Request("1", "Loan", "Pending"),
            Request("2", "Funeral Policy", "Approved"),
            Request("3", "Claim", "Declined")
        )
        val serviceRequestAdapter = ServiceRequestAdapter(serviceRequests)
        recentRequestsRecyclerView.adapter = serviceRequestAdapter

        // Set text for notifications and news
        notificationsTextView.text = "No new notifications."
        newsTextView.text = "Stay tuned for the latest updates."

        val applyLoanButton: Button = view.findViewById(R.id.applyLoanButton)
        val funeralPolicyButton: Button = view.findViewById(R.id.funeralPolicyButton)

        applyLoanButton.setOnClickListener {
            // Navigate to LoanFragment
            findNavController().navigate(R.id.action_homeFragment_to_loanFragment)
        }

        funeralPolicyButton.setOnClickListener {
            // Navigate to FuneralPolicyFragment
            findNavController().navigate(R.id.action_homeFragment_to_funeralPolicyFragment)
        }


    }
}
