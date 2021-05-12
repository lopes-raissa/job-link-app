package com.example.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.model.Category
import kotlinx.android.synthetic.main.layout_list_categories.view.*

class CategoryAdapter(var listCategory: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_categories, parent, false)

        return CategoryAdapter.CategoryViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = listCategory[position]
        holder.bind(category)
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            itemView.title_category.text = category.titleCategory
        }
    }
}