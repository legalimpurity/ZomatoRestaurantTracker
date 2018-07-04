package com.legalimpurity.zomatorestauranttracker.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ImageLoadingUtil
{

    fun ImageLoadingWrapper(act: Context, imageUrl: String?, imageView: ImageView?, placeholderResource: Int) {
        imageView?.let {
            GlideApp.with(act)
                    .load(imageUrl)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(placeholderResource)
                    .into(it)
        }
    }
}