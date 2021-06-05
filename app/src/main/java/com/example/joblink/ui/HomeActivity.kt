package com.example.joblink.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.joblink.R
import com.example.joblink.api.SessionManager
import com.example.joblink.fragments.HomeFragment
import com.example.joblink.fragments.ProfileFragment
import com.example.joblink.fragments.PublishFragment
import com.example.joblink.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var publishFragment: PublishFragment
    private lateinit var profileFragment: ProfileFragment
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)

        Log.i("XXXXXXXXXXXXXX FICAR SALVO TESTEE", sessionManager.fethAuthToken().toString())

        verifyAuthentication()
        loadData()
        insertToolbar()

        setFragment(homeFragment)
    }

    private fun loadData() {
        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        publishFragment = PublishFragment()
        profileFragment = ProfileFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun verifyAuthentication() {

        if (sessionManager.fethAuthToken() == null) {
            val intent = Intent(this, SplashScreenActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun insertToolbar() {
        setSupportActionBar(include as Toolbar?)
        supportActionBar?.title = "JOBLINK"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_config_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.logout -> {
                sessionManager.logout()
                verifyAuthentication()
                Toast.makeText(this, "Você fez Logout", Toast.LENGTH_SHORT).show()
            }
            R.id.publish -> {
            }
        }

        return true
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
                //setFragment(searchFragment)
                val intent = Intent(this, FreelancerRegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_message -> {
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_profile -> {
                setFragment(profileFragment)
            }
        }

        return true
    }
}

