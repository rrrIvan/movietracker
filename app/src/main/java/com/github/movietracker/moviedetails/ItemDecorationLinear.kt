package com.github.movietracker.moviedetails

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationLinear(
    private val paddingBetween: Int,
    private val paddingEdge: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }
        val itemCount = state.itemCount
        /** first position */
        if (itemPosition == 0) {
            outRect.set(paddingEdge, 0, 0, 0)
        }
        /** last position */
        else if (itemCount > 0 && itemPosition == itemCount - 1) {
            outRect.set(0, 0, paddingEdge, 0)
        }
        /** positions between first and last */
        else {
            outRect.set(paddingBetween, 0, paddingBetween, 0)
        }
    }
}
