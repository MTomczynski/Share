package com.maciejko.share.feature.master.add_coordinated_group

import com.maciejko.share.R
import com.maciejko.share.base.BaseFragment
import com.maciejko.share.databinding.FragmentAddCoordinatedGroupBinding
import com.maciejko.share.util.toAppCompatActivity

class AddCoordinatedGroupFragment :
    BaseFragment<FragmentAddCoordinatedGroupBinding>(R.layout.fragment_add_coordinated_group) {
    override fun bind() {
        activity?.toAppCompatActivity()?.supportActionBar?.title = getString(R.string.add_group_fragment_title)
    }
}