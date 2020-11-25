package com.example.platziconf.view.adpater

import com.example.platziconf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}