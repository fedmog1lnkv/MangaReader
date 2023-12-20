package com.fedmog1lnkv.mangareader.presentation.screens.manga_details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fedmog1lnkv.mangareader.databinding.ActivityMangaDetailsBinding
import com.fedmog1lnkv.mangareader.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailsActivity : AppCompatActivity() {

    companion object {
        const val ID = "id"

        fun newIntent(
            context: Context,
            id: String
        ) = Intent(context, MangaDetailsActivity::class.java).apply {
            putExtra(ID, id)
        }
    }

    private val viewModel: MangaDetailsViewModel by viewModels()

    private var _binding: ActivityMangaDetailsBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMangaDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeFlow(viewModel.manga) {
            it?.let { manga ->
                Glide.with(binding.image).load(manga.image).into(binding.image)
                binding.title.text = manga.title
                binding.countChapters.text = "${manga.countChapters} ${
                    binding.root.context.resources.getQuantityString(
                        com.fedmog1lnkv.mangareader.R.plurals.chapters_plural, manga.countChapters
                    )
                }"
                binding.rating.text = manga.stars.toString()
                binding.description.text = manga.description
            }
        }
    }
}