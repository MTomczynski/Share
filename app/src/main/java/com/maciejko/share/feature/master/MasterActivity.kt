package com.maciejko.share.feature.master

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.maciejko.share.R
import com.maciejko.share.base.BaseActivity
import com.maciejko.share.databinding.ActivityMasterBinding
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MasterActivity : BaseActivity<ActivityMasterBinding>(R.layout.activity_master) {

    private val masterViewModel: MasterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.coordinated_group_list -> navController.navigate(R.id.master_my_list_destination)
                R.id.group_users_list -> navController.navigate(R.id.master_group_destionation)
                else -> Snackbar.make(binding.root, R.string.undefined_navigation, Snackbar.LENGTH_SHORT).show()
            }
            true
        }
    }
}