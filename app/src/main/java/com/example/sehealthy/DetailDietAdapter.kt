package com.example.sehealthy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailDietAdapter(private val meals: List<Map<String, Any>>)
    : RecyclerView.Adapter<DetailDietAdapter.DetailDietHolder>() {

    inner class DetailDietHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(pos: Int) {
            val nameTv = view.findViewById<TextView>(R.id.tv_name)
            val imageIv = view.findViewById<ImageView>(R.id.iv_image)

            nameTv.text = meals[pos]["name"] as String
            imageIv.setImageResource(meals[pos]["image"] as Int)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailDietHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DetailDietHolder(inflater.inflate(R.layout.item_diet_list, parent, false))
    }

    override fun onBindViewHolder(holder: DetailDietHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return meals.size
    }
}