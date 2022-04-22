package org.software.githubapiproject.adpater

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapiproject.R
import com.example.githubapiproject.databinding.SearchUserItemBinding
import org.software.githubapiproject.data.Item
import org.software.githubapiproject.viewmodel.SearchViewModel

class SearchListAdapter(private val vm : SearchViewModel,private val context : Context) : PagingDataAdapter<Item, SearchListAdapter.ViewHolder>(SearchListDiffUtil) {

    companion object SearchListDiffUtil: DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            //각 아이템들의 고유한 값을 비교해야 한다.
            return oldItem.repos_url == newItem.repos_url
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem==newItem
        }
    }

    inner class ViewHolder(private val binding: SearchUserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item,position: Int){
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<SearchUserItemBinding>(
            layoutInflater,
            viewType,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.search_user_item
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it,position) }

        //item 간의 사이 조절
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 200
        holder.itemView.requestLayout()
    }
}