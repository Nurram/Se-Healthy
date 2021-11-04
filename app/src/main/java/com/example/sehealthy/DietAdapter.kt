package com.example.sehealthy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DietAdapter(
    val onClick: (Int) -> Unit
): RecyclerView.Adapter<DietAdapter.DietHolder>() {

    inner class DietHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {
            val dayTv = view.findViewById<TextView>(R.id.tv_diet_day)
            dayTv.text = "Day ${position + 1}"

            itemView.setOnClickListener { onClick(position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DietHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: DietHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 7
    }
}