package com.maciejko.share.feature.master.coordinated_group_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.maciejko.share.R
import com.maciejko.share.databinding.FragmentCoordinatedGroupListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class CoordinatedGroupListFragment : Fragment() {

    private val viewModel: CoordinatedGroupListViewModel by viewModel()
    private lateinit var binding: FragmentCoordinatedGroupListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_coordinated_group_list, container, false
        )
        binding.viewModel = viewModel

        val coordinatedGroupAdapter = CoordinatedGroupListAdapter()
        binding.coordinatedGroupListRv.adapter = coordinatedGroupAdapter
        viewModel.coordinatedGroupList.observe(this, Observer {
            it?.let { coordinatedGroupList ->
                coordinatedGroupAdapter.submitList(coordinatedGroupList)
            }
        })

        val dividerItemDecoration = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.HORIZONTAL
        )
        binding.coordinatedGroupListRv.addItemDecoration(dividerItemDecoration)

        return binding.root
    }
}
