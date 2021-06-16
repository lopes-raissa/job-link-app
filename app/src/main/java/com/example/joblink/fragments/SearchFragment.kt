package com.example.joblink.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.adapter.ProfessionAdapter
import com.example.joblink.model.ProfissionModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.recycleViewPublcation
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

class SearchFragment : Fragment() {

    private lateinit var rvCategory: RecyclerView

    private lateinit var adapterProfission: ProfessionAdapter
    private lateinit var profileFragment: ProfileFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startRecycleView()

    }

    private fun startRecycleView() {
        rvCategory = recycleViewSearch
        adapterProfission = ProfessionAdapter(activity)
        rvCategory.layoutManager =
            GridLayoutManager(activity, 2, LinearLayoutManager.VERTICAL, false)
        rvCategory.adapter = adapterProfission
    }

}