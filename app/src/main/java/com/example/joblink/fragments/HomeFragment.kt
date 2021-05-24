package com.example.joblink.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.joblink.R
import com.example.joblink.adapter.PublicationAdapter
import com.example.joblink.api.RetrofitApi
import com.example.joblink.model.PublicationResponseModel
import com.example.joblink.ui.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var adapterPublication: PublicationAdapter

    private lateinit var apiClient: RetrofitApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapterPublication = PublicationAdapter(activity)

        startRecycleView()

    }

        private fun startRecycleView() {
        recycleViewPublcation.layoutManager = LinearLayoutManager(activity)
        }



}