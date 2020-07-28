package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL10ResourceLinkBinding

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L10ResourceLinkAct: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActL10ResourceLinkBinding = DataBindingUtil.setContentView(this,R.layout.act_l10_resource_link)
    }

}