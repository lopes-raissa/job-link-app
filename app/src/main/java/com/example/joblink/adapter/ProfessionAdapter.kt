package com.example.joblink.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.model.ProfissionModel
import com.example.joblink.model.PublicationModel

class ProfessionAdapter(var context:  FragmentActivity?) :
    RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder>() {

    private var listProfession: List<PublicationModel> = emptyList()

    fun updateListPublication(list: List<PublicationModel>) {
        listProfession = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_profissions, parent, false)

        return ProfessionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProfession.size
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        val profession = listProfession[position]

    }

    class ProfessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }
}