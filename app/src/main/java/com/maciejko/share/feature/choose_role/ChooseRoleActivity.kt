package com.maciejko.share.feature.choose_role

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.maciejko.share.R
import com.maciejko.share.databinding.ActivityChooseRoleBinding
import com.maciejko.share.feature.master.MasterActivity
import com.maciejko.share.feature.slave.SlaveActivity

class ChooseRoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_role)
        val binding = DataBindingUtil.setContentView<ActivityChooseRoleBinding>(
            this, R.layout.activity_choose_role
        )

        binding.masterImage.setOnClickListener {
            startActivity(Intent(this, MasterActivity::class.java))
        }

        binding.slaveImage.setOnClickListener {
            startActivity(Intent(this, SlaveActivity::class.java))
        }
    }
}
