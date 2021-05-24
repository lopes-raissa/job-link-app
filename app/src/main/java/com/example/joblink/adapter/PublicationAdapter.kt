package com.example.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.model.PublicationModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.layout_list_publications.view.*

class PublicationAdapter(val context: FragmentActivity?): RecyclerView.Adapter<PublicationAdapter.PublicationViewHolder>() {

    var ListPublication = emptyList<PublicationModel>()

    fun updateListPublication(list: List<PublicationModel>){
        ListPublication = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_list_publications, parent, false)

        return PublicationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  ListPublication.size
    }

    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val publication = ListPublication[position]
        holder.bind(publication)
    }

    class PublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(publicationModel: PublicationModel) {
            itemView.textNameUser.text = publicationModel.name
            itemView.textDatePublication.text = publicationModel.datePublication
            itemView.textProfission.text = publicationModel.profission
            itemView.textDescription.text = publicationModel.description
           // itemView.textFreelancerNote.rating = publication.freelancerNote
        }
    }
}
