package com.maciejko.share.feature.master

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.maciejko.share.R
import com.maciejko.share.base.BaseActivity
import com.maciejko.share.databinding.ActivityMasterBinding

class MasterActivity : BaseActivity<ActivityMasterBinding>(R.layout.activity_master) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.coordinated_group_list -> navController.navigate(R.id.master_coordinated_group_list_destination)
                R.id.group_users_list -> navController.navigate(R.id.master_slave_group_destination)
                else -> Snackbar.make(binding.root, R.string.undefined_navigation, Snackbar.LENGTH_SHORT).show()
            }
            true
        }
    }
}