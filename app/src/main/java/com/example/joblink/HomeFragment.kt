package com.example.joblink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.joblink.adapter.PublicationAdapter
import com.example.joblink.datasource.Datasource

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         startRecycleView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

        private fun startRecycleView() {
        recycleViewPublcation.layoutManager = LinearLayoutManager(this)
        recycleViewPublcation.adapter = PublicationAdapter(Datasource.getPublications())
    }
}