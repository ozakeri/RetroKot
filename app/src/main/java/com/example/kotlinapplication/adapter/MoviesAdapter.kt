package com.example.kotlinapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.R
import com.example.kotlinapplication.model.Movies
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.toast

class MoviesAdapter(var context: Context, var list: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.CustomView>() {

    class CustomView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvId = itemView.tvId
        val tvDesc = itemView.tvDesc
        val tvDate = itemView.tvDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CustomView(v)
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        holder.tvName.text = "Name : " + list.get(position).original_title
        holder.tvId.text = "Id : " + list.get(position).id.toString()
        holder.tvDesc.text = "Desc : " + list.get(position).overview
        holder.tvDate.text = "Release Date : " + list.get(position).release_date

        holder.itemView.setOnClickListener(View.OnClickListener {
            context.toast(list.get(position).original_title)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}