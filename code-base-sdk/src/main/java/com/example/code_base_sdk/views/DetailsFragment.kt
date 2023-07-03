package com.example.code_base_sdk.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.code_base_sdk.R
import com.example.code_base_sdk.databinding.FragmentDetailsBinding
import com.example.code_base_sdk.viemwodel.MainBaseViewModel


class DetailsFragment : Fragment() {
    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainBaseViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel.selectedItem.observe(viewLifecycleOwner) {
            // todo populate the details for the character
        }

        return binding.root
    }
}