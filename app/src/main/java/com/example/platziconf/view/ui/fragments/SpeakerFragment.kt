package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import com.example.platziconf.view.adpater.SpeakerAdapter
import com.example.platziconf.view.adpater.SpeakerListener
import com.example.platziconf.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*

class SpeakerFragment : Fragment(), SpeakerListener {

    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeaker.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = speakerAdapter

        }
        observeViewModel()

    }

    fun observeViewModel(){
        viewModel.listSpeaker.observe(viewLifecycleOwner, Observer<List<Speaker>> { speaker ->
            speakerAdapter.updateData(speaker)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null){
                rlBaseSpeaker.visibility = View.INVISIBLE
            }
        })
    }

    override fun onSpeakerClicked(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.speakersDetailFragmentDialog, bundle)
    }


}