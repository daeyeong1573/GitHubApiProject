package org.software.githubapiproject.adpater

import android.content.ContentValues
import android.util.Log
import android.widget.ImageView
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


}