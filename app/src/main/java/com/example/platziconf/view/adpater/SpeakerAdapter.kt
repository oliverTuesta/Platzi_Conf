package com.example.platziconf.view.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.platziconf.R
import com.example.platziconf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) :
    RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    private var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeakers[position]
        holder.speakerName.text = speaker.name
        holder.speakerJob.text = speaker.jobtitle
    }

    override fun getItemCount() = listSpeakers.size

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val speakerName = itemView.findViewById<TextView>(R.id.tvSpeakerName)
        val speakerJob = itemView.findViewById<TextView>(R.id.tvSpeakerJob)
    }
}