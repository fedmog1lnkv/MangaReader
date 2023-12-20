package com.fedmog1lnkv.mangareader.presentation.screens.account

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fedmog1lnkv.mangareader.databinding.FragmentAccountBinding
import com.fedmog1lnkv.mangareader.presentation.common.decoration.VerticalSpacingItemDecoration
import com.fedmog1lnkv.mangareader.presentation.common.list.StatisticsItemAdapter
import com.fedmog1lnkv.mangareader.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AccountViewModel by viewModels()

    private val statisticsAdapter = StatisticsItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        binding.statisticsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.statisticsRecyclerView.adapter = statisticsAdapter
        binding.statisticsRecyclerView.addItemDecoration(VerticalSpacingItemDecoration(8))
    }

    private fun observeViewModel() {
        observeFlow(viewModel.user) {
            Glide.with(binding.image).load(it?.image).into(binding.image)
            binding.name.text = it?.name
            statisticsAdapter.setData(it?.statistics ?: emptyList())
        }
    }
}