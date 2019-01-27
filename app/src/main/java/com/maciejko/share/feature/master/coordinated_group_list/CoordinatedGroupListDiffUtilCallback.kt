package com.maciejko.share.feature.master.coordinated_group_list

import androidx.recyclerview.widget.DiffUtil
import com.maciejko.share.data.CoordinatedGroup

class CoordinatedGroupListDiffUtilCallback : DiffUtil.ItemCallback<CoordinatedGroup>() {
    override fun areItemsTheSame(oldItem: CoordinatedGroup, newItem: CoordinatedGroup): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoordinatedGroup, newItem: CoordinatedGroup): Boolean {
        return oldItem == newItem
    }

}