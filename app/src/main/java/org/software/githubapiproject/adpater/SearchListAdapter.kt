package org.software.githubapiproject.adpater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapiproject.databinding.SearchUserItemBinding
import org.software.githubapiproject.data.Item

class SearchListAdapter : ListAdapter<Item, SearchListAdapter.ViewHolder>(SearchListDiffUtil) {

    companion object SearchListDiffUtil: DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            //각 아이템들의 고유한 값을 비교해야 한다.
            return oldItem.login == newItem.login
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem==newItem
        }
    }

    inner class ViewHolder(private val binding: SearchUserItemBinding): RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}