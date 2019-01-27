package com.maciejko.share.feature.master

import android.os.Bundle
import com.maciejko.share.R
import com.maciejko.share.base.BaseActivity
import com.maciejko.share.databinding.ActivityMasterBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MasterActivity : BaseActivity<ActivityMasterBinding>(R.layout.activity_master) {

    private val masterViewModel: MasterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}