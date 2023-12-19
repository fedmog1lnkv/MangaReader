package com.fedmog1lnkv.mangareader.presentation.common.decoration

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class VerticalSpacingItemDecoration(
    private val spaceHeight: Int = 16
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) < (parent.adapter?.itemCount ?: 0) - 1) {
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                spaceHeight.toFloat(),
                view.context.resources.displayMetrics
            ).roundToInt().also {
                outRect.bottom = it
            }
        }
    }
}