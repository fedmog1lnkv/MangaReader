package com.fedmog1lnkv.mangareader.presentation.common.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fedmog1lnkv.mangareader.databinding.ListItemMangaBinding
import com.fedmog1lnkv.mangareader.domain.model.Manga

class MangasAdapter(
    private val onClick: (Manga) -> Unit
) : RecyclerView.Adapter<MangasAdapter.MangasViewHolder>() {

    private val mangas = mutableListOf<Manga>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangasViewHolder {
        val binding = ListItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangasViewHolder, position: Int) {
        holder.bind(mangas[position])
    }

    override fun getItemCount(): Int {
        return mangas.size
    }

    fun setData(mangas: List<Manga>) {
        // TODO : make diffutill
        this.mangas.clear()
        this.mangas.addAll(mangas)
        notifyDataSetChanged()
    }

    inner class MangasViewHolder(private val binding: ListItemMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Manga) {
            Glide.with(binding.root).load(item.image).into(binding.image)
            binding.title.text = item.title
            binding.countChapters.text = "${item.countChapters} ${
                binding.root.context.resources.getQuantityString(
                    com.fedmog1lnkv.mangareader.R.plurals.chapters_plural, item.countChapters
                )
            }"
            binding.rating.text = item.stars.toString()
            binding.description.text = item.description
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

}