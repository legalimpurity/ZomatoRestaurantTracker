package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.restaurantdetailfragmentadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.databinding.ItemReviewBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseRecyclerViewHolder

class RestaurantsReviewsAdapter: RecyclerView.Adapter<BaseRecyclerViewHolder>()
{
    var restaurantObjs: MutableList<Review> = ArrayList()

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        val mItemReviewBinding: ItemReviewBinding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val resViewHolder = RestaurantItemViewHolder(mItemReviewBinding)
        return resViewHolder
    }

    override fun getItemCount(): Int = restaurantObjs.size

    fun setData(repoList: List<Review>?) {
        repoList?.let {
            restaurantObjs.clear()
            restaurantObjs.addAll(repoList)
            notifyDataSetChanged()
        }
    }

    // ViewHolder Class
    inner class RestaurantItemViewHolder(private val mItemReviewBinding: ItemReviewBinding): BaseRecyclerViewHolder(mItemReviewBinding.root)
    {
        override fun onBind(pos: Int) {
            mItemReviewBinding.viewModel = RestaurantsReviewItemViewModel(restaurantObjs[pos])
            mItemReviewBinding.executePendingBindings()
        }
    }

    fun addItems(restaurantsData: List<Review>) {
        restaurantObjs.addAll(restaurantsData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        restaurantObjs.clear()
    }
}
