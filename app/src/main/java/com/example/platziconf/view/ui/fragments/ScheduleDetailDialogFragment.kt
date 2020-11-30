package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.platziconf.R
import com.example.platziconf.model.Conference
import kotlinx.android.synthetic.main.fragment_schedule_detail.*
import java.text.SimpleDateFormat

class ScheduleDetailFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbConference.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        tbConference.setNavigationOnClickListener {
            dismiss()
        }

        val conference = arguments?.getSerializable("conference") as Conference


        try {
            tvDetailConferenceTitle.text = conference.title
            val pattern = "dd/MM/yyyy hh:mm a"
            val simpleDF = SimpleDateFormat(pattern)
            val date = simpleDF.format(conference.datetime)
            tvDetailHour.text = date
        } catch (e: Exception) {
            println("error en la hora de scheduleDetail: $e")
        }
        tvDetailConferenceSpeaker.text = conference.speaker.toUpperCase()
        tvDetailConferenceTag.text = conference.tag
        tvDetailConferenceDescription.text = conference.description
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

}