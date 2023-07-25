package com.example.landscappe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LandscapeAdapter(private var allLandscape: ArrayList<Landscape>):
    RecyclerView.Adapter<LandscapeAdapter.LandscapeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandscapeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cardView = inflater.inflate(R.layout.element_of_list, parent, false)
        return LandscapeViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return allLandscape.size
    }

    override fun onBindViewHolder(holder: LandscapeViewHolder, position: Int) {
        val currentLandscape = allLandscape[position]
        holder.setData(currentLandscape, position)
    }

    inner class LandscapeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(currentLandscape: Landscape ,position: Int) {
            landscapeTitle.text = currentLandscape.title
            landscapeExplanation.text = currentLandscape.explanation
            landscapeImage.setImageResource(currentLandscape.landImage)

            deleteButton.setOnClickListener {
                allLandscape.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, allLandscape.size)
            }
            copyButton.setOnClickListener {
                allLandscape.add(position, currentLandscape)
                notifyItemInserted(position)
                notifyItemRangeChanged(position, allLandscape.size)
            }
        }

        private val landscapeCardView = itemView
        private val landscapeTitle = landscapeCardView.findViewById<TextView>(R.id.textViewTitle)!!
        private val landscapeExplanation = landscapeCardView.findViewById<TextView>(R.id.textViewExplanation)!!
        private val landscapeImage = landscapeCardView.findViewById<ImageView>(R.id.imageView)!!
        private val deleteButton = landscapeCardView.findViewById<ImageView>(R.id.deleteButton)!!
        private val copyButton = landscapeCardView.findViewById<ImageView>(R.id.copyButton)!!
    }
}
