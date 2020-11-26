package com.example.platziconf.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.platziconf.model.Speaker
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreService

class SpeakersViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    private fun getSpeakerFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }

}