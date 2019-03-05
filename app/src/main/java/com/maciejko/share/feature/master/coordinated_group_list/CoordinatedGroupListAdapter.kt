package com.maciejko.share.feature.master.coordinated_group_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maciejko.share.R
import com.maciejko.share.data.CoordinatedGroup
import com.maciejko.share.databinding.CoordinatedGroupItemBinding

class CoordinatedGroupListAdapter :
    ListAdapter<CoordinatedGroup, CoordinatedGroupListAdapter.CoordinatedGroupListViewHolder>(
        CoordinatedGroupListDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatedGroupListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CoordinatedGroupItemBinding>(
            inflater, R.layout.coordinated_group_item, parent, false
        )
        return CoordinatedGroupListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoordinatedGroupListViewHolder, position: Int) {
        holder.binding.item = getItem(position)
        holder.binding.executePendingBindings()
    }

    class CoordinatedGroupListViewHolder(
        val binding: CoordinatedGroupItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}