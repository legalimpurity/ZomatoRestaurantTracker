package com.legalimpurity.zomatorestauranttracker.ui.baseui

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun onBind(pos: Int)
}