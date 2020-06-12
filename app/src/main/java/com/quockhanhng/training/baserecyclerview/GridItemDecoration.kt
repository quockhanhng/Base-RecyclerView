package com.quockhanhng.training.baserecyclerview


import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecoration(private var space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        outRect.apply {
            left = space
            right = space
            bottom = space
        }

        outRect.top = if (parent.getChildLayoutPosition(view) == 0) space else 0

    }
}