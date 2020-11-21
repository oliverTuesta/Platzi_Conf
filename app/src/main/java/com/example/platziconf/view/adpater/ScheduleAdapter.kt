package com.example.platziconf.view.adpater

import android.telecom.Conference
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziconf.R

class ScheduleAdapter(): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))
    }

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = listConference.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextureView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextureView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextureView>(R.id.tvItemScheduleTag)
        val tvConferenceHour = itemView.findViewById<TextureView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextureView>(R.id.tvItemScheduleAMPM)
    }

}