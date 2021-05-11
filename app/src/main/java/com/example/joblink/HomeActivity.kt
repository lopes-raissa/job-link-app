package com.example.joblink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonHome: Button
    private lateinit var buttonSearch: Button
    private lateinit var buttonPublish: Button
    private lateinit var buttonProfile: Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var publishFragment: PublishFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        buttonHome = findViewById(R.id.button_home)
        buttonSearch = findViewById(R.id.button_search)
        buttonPublish = findViewById(R.id.button_publish)
        buttonProfile = findViewById(R.id.button_profile)

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        publishFragment = PublishFragment()
        profileFragment = ProfileFragment()

        buttonHome.setOnClickListener(this)
        buttonSearch.setOnClickListener(this)
        buttonPublish.setOnClickListener(this)
        buttonProfile.setOnClickListener(this)

        //setFragment(homeFragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
        fragmentTransition.commit()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_home -> {
                setFragment(homeFragment)
            }
            R.id.button_search -> {
                setFragment(searchFragment)
            }
            R.id.button_publish -> {
                setFragment(publishFragment)
            }
            R.id.button_profile -> {
                setFragment(profileFragment)
            }
        }
    }
}