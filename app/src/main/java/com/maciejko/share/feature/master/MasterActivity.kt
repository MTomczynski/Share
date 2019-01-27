package com.maciejko.share.feature.master

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.maciejko.share.R
import com.maciejko.share.base.BaseActivity
import com.maciejko.share.databinding.ActivityMasterBinding

class MasterActivity : BaseActivity<ActivityMasterBinding>(R.layout.activity_master) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}