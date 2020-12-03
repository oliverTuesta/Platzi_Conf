package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*


class SpeakersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        tbSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker

        Glide.with(this)
            .load(speaker.image)
            .into(ivSpeakerDetailPicture)

        tvSpeakerDetailWorkplace.text = speaker.workplace
        tvSpeakerDetailName.text = speaker.name
        tvSpeakerDetailJobTitle.text = speaker.jobtitle
        tvSpeakerDetailBiography.text = speaker.biography
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}