package com.example.joblink.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.joblink.R
import com.example.joblink.api.SessionManager
import com.example.joblink.fragments.HomeFragment
import com.example.joblink.fragments.ProfileFragment
import com.example.joblink.fragments.PublishFragment
import com.example.joblink.fragments.SearchFragment
import com.example.joblink.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var publishFragment: PublishFragment
    private lateinit var profileFragment: ProfileFragment
    private var sessionManager: SessionManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //verifyAuthentication()

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        publishFragment = PublishFragment()
        profileFragment = ProfileFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(homeFragment)
    }


    private fun verifyAuthentication() {

        if (sessionManager!!.fethAuthToken() == null) {

            var intent = Intent(this, HomeActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK - Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
        fragmentTransition.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_search -> {
                setFragment(searchFragment)
            }
            R.id.menu_publish -> {
                setFragment(publishFragment)
            }
            R.id.menu_profile -> {
                setFragment(profileFragment)
            }
        }

        return true
    }

}

