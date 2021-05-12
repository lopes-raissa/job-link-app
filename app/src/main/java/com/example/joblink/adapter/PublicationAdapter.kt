package com.example.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.fragments.HomeFragment
import com.example.joblink.model.Publication
import kotlinx.android.synthetic.main.layout_list_publications.view.*

class PublicationAdapter(var listPublication: ArrayList<Publication>): RecyclerView.Adapter<PublicationAdapter.PublicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_publications, parent, false)

        return PublicationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  listPublication.size
    }

    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val publication = listPublication[position]
        holder.bind(publication)
    }

    class PublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(publication: Publication) {
            itemView.textNameUser.text = publication.userName
            itemView.textDatePublication.text = publication.datePublication
            itemView.textProfission.text = publication.profission
            itemView.textDescription.text = publication.description
            itemView.textFreelancerNote.rating = publication.freelancerNote
        }
    }
}