package com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.databinding.ItemRestaurantBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseRecyclerViewHolder

class RestaurantsAdapter: RecyclerView.Adapter<BaseRecyclerViewHolder>()
{
    var restaurantObjs: MutableList<Restaurant> = ArrayList()
    var restaurantsAdapterListener : RestaurantsAdapterListener? = null

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        val mItemRestaurantBinding: ItemRestaurantBinding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val resViewHolder = RestaurantItemViewHolder(mItemRestaurantBinding)
        mItemRestaurantBinding.restaurantItemRootView.setOnClickListener{view ->
            restaurantsAdapterListener?.onClick(resViewHolder.adapterPosition,view.context)
        }
        return resViewHolder
    }

    override fun getItemCount(): Int = restaurantObjs.size

    fun setData(repoList: List<Restaurant>?) {

        repoList?.let {
            restaurantObjs.clear()
            restaurantObjs.addAll(repoList)
            notifyDataSetChanged()
        }
    }

    // ViewHolder Class
    inner class RestaurantItemViewHolder(private val mItemRestaurantBinding: ItemRestaurantBinding): BaseRecyclerViewHolder(mItemRestaurantBinding.root)
    {
        override fun onBind(pos: Int) {
            mItemRestaurantBinding.viewModel = RestaurantItemViewModel(restaurantObjs[pos])
            mItemRestaurantBinding.executePendingBindings()
        }
    }

    fun addItems(restaurantsData: List<Restaurant>) {
        restaurantObjs.addAll(restaurantsData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        restaurantObjs.clear()
    }
}
