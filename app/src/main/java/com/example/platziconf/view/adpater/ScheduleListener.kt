package com.example.platziconf.view.adpater

import android.telecom.Conference

interface ScheduleListener{
    fun onConferenceClicked(conference: Conference, position: Int)
}