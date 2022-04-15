package org.software.githubapiproject.adpater

import android.content.ContentValues
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.software.githubapiproject.data.Item

object SearchBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageLoad")
    fun imageLoad(view : ImageView, url : String){
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("listData")
    fun listData(view : RecyclerView, items : List<Item>?){
        val adapter = view.adapter as SearchListAdapter
        adapter.submitList(items?.toMutableList())
    }

    @JvmStatic
    @BindingAdapter("loading")
    fun loadingVisible(view : ProgressBar, type : Boolean){
        if (type) view.visibility = View.VISIBLE
        else view.visibility = View.GONE
    }


}