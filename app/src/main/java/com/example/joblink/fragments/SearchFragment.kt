package com.example.joblink.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
//import com.example.joblink.adapter.ProfissionAdapter
import com.example.joblink.model.ProfissionModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class SearchFragment : Fragment() {

    private lateinit var rvCategory: RecyclerView
   // private lateinit var adapterProfission: ProfissionAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
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

        //startRecycleView()

    }

    private fun startRecycleView() {

       var list = ArrayList<ProfissionModel>()

        rvCategory = recycleViewPublcation
       // adapterProfission = ProfissionAdapter(list)
        gridLayoutManager = GridLayoutManager(activity, 2)
       // rvCategory.adapter = adapterProfission
        rvCategory.setLayoutManager(gridLayoutManager)
    }

}