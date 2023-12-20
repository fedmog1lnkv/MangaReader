package com.fedmog1lnkv.mangareader.presentation.common.list

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fedmog1lnkv.mangareader.databinding.ListItemStatisticsItemBinding
import com.fedmog1lnkv.mangareader.domain.model.UserStatisticItem

class StatisticsItemAdapter : RecyclerView.Adapter<StatisticsItemAdapter.StatisticsItemViewHolder>() {
    private val statistics = mutableListOf<UserStatisticItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsItemViewHolder {
        val binding = ListItemStatisticsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatisticsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatisticsItemViewHolder, position: Int) {
        holder.bind(statistics[position])
    }

    override fun getItemCount(): Int {
        return statistics.size
    }

    fun setData(statistics: List<UserStatisticItem>) {
        this.statistics.clear()
        this.statistics.addAll(statistics)
        notifyDataSetChanged()
    }

    inner class StatisticsItemViewHolder(private val binding: ListItemStatisticsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: UserStatisticItem) {
            binding.name.text = item.name
            binding.value.text = item.count.toString()
            val color = Color.parseColor(item.displayColor)
            binding.colorMarker.backgroundTintList = ColorStateList.valueOf(color)
        }
    }

}