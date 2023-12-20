package com.fedmog1lnkv.mangareader.presentation.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedmog1lnkv.mangareader.databinding.FragmentHomeBinding
import com.fedmog1lnkv.mangareader.presentation.common.decoration.VerticalSpacingItemDecoration
import com.fedmog1lnkv.mangareader.presentation.common.list.MangasAdapter
import com.fedmog1lnkv.mangareader.presentation.screens.manga_details.MangaDetailsActivity
import com.fedmog1lnkv.mangareader.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = MangasAdapter(
        onClick = {
            startActivity(MangaDetailsActivity.newIntent(requireActivity(), it.id))
        }
    )

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mangasRecycler.layoutManager = LinearLayoutManager(context)
        binding.mangasRecycler.adapter = adapter
        binding.mangasRecycler.addItemDecoration(VerticalSpacingItemDecoration())

        observeFlow(viewModel.mangasFlow) {
            adapter.setData(it)
        }
    }
}