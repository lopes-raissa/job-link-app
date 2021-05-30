package com.example.joblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.model.CategoryModel
import kotlinx.android.synthetic.main.layout_list_categories.view.*

class CategoryAdapter(var listCategoryModel: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_categories, parent, false)

        return CategoryAdapter.CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listCategoryModel.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = listCategoryModel[position]
        holder.bind(category)
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(categoryModel: CategoryModel) {
            itemView.name_service.text = CategoryModel.nameCategory
        }
    }
}