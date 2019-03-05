package com.maciejko.share.feature.master.coordinated_group_list

import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.maciejko.share.R
import com.maciejko.share.base.BaseFragment
import com.maciejko.share.databinding.FragmentCoordinatedGroupListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class CoordinatedGroupListFragment
    : BaseFragment<FragmentCoordinatedGroupListBinding>(R.layout.fragment_coordinated_group_list) {

    private val viewModel: CoordinatedGroupListViewModel by viewModel()

    override fun bind() {
        binding.viewModel = viewModel
        val coordinatedGroupAdapter = CoordinatedGroupListAdapter()
        binding.coordinatedGroupListRv.adapter = coordinatedGroupAdapter
        viewModel.coordinatedGroupList.observe(this, Observer {
            it?.let { coordinatedGroupList ->
                coordinatedGroupAdapter.submitList(coordinatedGroupList)
            }
        })

        decorateList()
        binding.addButton.setOnClickListener {
            binding.root.findNavController().navigate(R.id.master_add_coordinated_group_list_destination)
        }
    }

    private fun decorateList() {
        val dividerItemDecoration = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.HORIZONTAL
        )
        binding.coordinatedGroupListRv.addItemDecoration(dividerItemDecoration)
    }
}
