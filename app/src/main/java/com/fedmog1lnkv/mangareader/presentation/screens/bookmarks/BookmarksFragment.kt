package com.fedmog1lnkv.mangareader.presentation.screens.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedmog1lnkv.mangareader.databinding.FragmentBookmarksBinding
import com.fedmog1lnkv.mangareader.presentation.common.decoration.VerticalSpacingItemDecoration
import com.fedmog1lnkv.mangareader.presentation.common.list.MangasAdapter
import com.fedmog1lnkv.mangareader.presentation.screens.manga_details.MangaDetailsActivity
import com.fedmog1lnkv.mangareader.util.observeFlow
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarksFragment : Fragment() {
    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!

    private val mangasAdapter = MangasAdapter(
        onClick = {
            startActivity(MangaDetailsActivity.newIntent(requireContext(), it.id))
        }
    )

    private val viewModel: BookmarksViewModel by viewModels()

    private val tabSelectedListener = object : OnTabSelectedListener {
        override fun onTabSelected(tab: Tab?) {
            tab?.let {
                viewModel.bookmarks.value.getOrNull(it.position)?.let { bookmark ->
                    viewModel.selectBookmark(bookmark)
                }
            }
        }

        override fun onTabUnselected(tab: Tab?) {}
        override fun onTabReselected(tab: Tab?) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selected_tab", binding.tabLayout.selectedTabPosition)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mangasRecycler.layoutManager = LinearLayoutManager(context)
        binding.mangasRecycler.adapter = mangasAdapter
        binding.mangasRecycler.addItemDecoration(VerticalSpacingItemDecoration())

        observeFlow(viewModel.bookmarks) {
            val selectedTab =
                if (binding.tabLayout.selectedTabPosition == -1) savedInstanceState?.getInt("selected_tab") ?: 0
                else binding.tabLayout.selectedTabPosition
            binding.tabLayout.removeAllTabs()
            for (bookmark in it) {
                binding.tabLayout.addTab(
                    binding.tabLayout.newTab().apply {
                        text = bookmark.name
                    }
                )
            }

            binding.tabLayout.getTabAt(selectedTab)?.let {
                binding.tabLayout.selectTab(it)
            }
        }

        observeFlow(viewModel.mangasFlow) {
            mangasAdapter.setData(it)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
    }

    override fun onPause() {
        binding.tabLayout.removeOnTabSelectedListener(tabSelectedListener)
        super.onPause()
    }
}