package com.example.code_base_sdk.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.code_base_sdk.R
import com.example.code_base_sdk.databinding.FragmentItemsBinding
import com.example.code_base_sdk.utils.ResultState
import com.example.code_base_sdk.viemwodel.MainBaseViewModel
import com.example.code_base_sdk.views.adapter.AppAdapter


class ItemsFragment : Fragment() {
    private val binding by lazy {
        FragmentItemsBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainBaseViewModel::class.java]
    }

    @VisibleForTesting
    val appAdapter by lazy {
        AppAdapter {
            viewModel.setSelectedItem(it)
            binding.slidingPaneLayout.openPane()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.mainFragment.searchChar.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchItems(newText)
                return false
            }

        })

        binding.mainFragment.charsRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = appAdapter
        }

        viewModel.characters.observe(viewLifecycleOwner) {
            when(it) {
                is ResultState.Loading -> TODO()
                is ResultState.Success -> {
                    appAdapter.updateItems(it.data)
                }
                is ResultState.Error -> TODO()
            }
        }

        return binding.root
    }
}