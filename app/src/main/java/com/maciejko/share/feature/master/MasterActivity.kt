package com.maciejko.share.feature.master

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.maciejko.share.R
import com.maciejko.share.base.BaseActivity
import com.maciejko.share.databinding.ActivityMasterBinding

class MasterActivity : BaseActivity<ActivityMasterBinding>(R.layout.activity_master) {
    override fun bind() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController
        setSupportActionBar(binding.toolbar)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}