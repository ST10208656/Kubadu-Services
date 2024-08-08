package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ServicesRequestedFragment : Fragment() {

    private lateinit var serviceRequestAdapter: ServiceRequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services_requested, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val serviceRequestsRecyclerView: RecyclerView = view.findViewById(R.id.serviceRequestsRecyclerView)
        serviceRequestsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val serviceRequests = listOf(
            Request("1", "Loan", "Pending"),
            Request("2", "Funeral Policy", "Approved"),
            Request("3", "Claim", "Declined")
        )

        serviceRequestAdapter = ServiceRequestAdapter(serviceRequests)
        serviceRequestsRecyclerView.adapter = serviceRequestAdapter
    }
}
