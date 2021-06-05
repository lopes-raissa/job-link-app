package com.example.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.model.ProfissionModel

class ProfessionAdapter(var listProfissionModel: List<ProfissionModel>) :
    RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_profissions, parent, false)

        return ProfessionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProfissionModel.size
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        val profession = listProfissionModel[position]

    }

    class ProfessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }
}