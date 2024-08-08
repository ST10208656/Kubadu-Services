package com.example.kubaduservices1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class ServicesActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        // Directly set the navigation icon
        toolbar.setNavigationIcon(R.drawable.ic_menu_custom)
        toolbar.setNavigationOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }

        val headerView = navigationView.getHeaderView(0)
        val textViewUsername = headerView.findViewById<TextView>(R.id.textViewUsername)
        textViewUsername.text = "Username" // Replace with actual username

supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        // Handle navigation view item clicks here
        when (menuItem.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
            }
            R.id.nav_loans -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, LoanFragment())
                    .commit()
            }
            R.id.nav_funeral_policy -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FuneralPolicyFragment())
                    .commit()
            }


            R.id.nav_requests ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ServicesRequestedFragment())
                    .commit()
            }
            R.id.nav_profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment())
                    .commit()
            }
            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SettingsFragment())
                    .commit()
            }
            R.id.nav_logout -> {
                // Handle logout action
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}


class ServiceRequestAdapter(private val serviceRequests: List<Request>) :
    RecyclerView.Adapter<ServiceRequestAdapter.ServiceRequestViewHolder>() {

    class ServiceRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val requestIdTextView: TextView = itemView.findViewById(R.id.requestIdTextView)
        val requestCategoryTextView: TextView = itemView.findViewById(R.id.requestCategoryTextView)
        val requestStatusTextView: TextView = itemView.findViewById(R.id.requestStatusTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceRequestViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service_request, parent, false)
        return ServiceRequestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ServiceRequestViewHolder, position: Int) {
        val serviceRequest = serviceRequests[position]
        holder.requestIdTextView.text = serviceRequest.requestId
        holder.requestCategoryTextView.text = serviceRequest.requestCategory
        holder.requestStatusTextView.text = serviceRequest.requestStatus
    }

    override fun getItemCount() = serviceRequests.size
}

