package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL11FragmentBindingBinding

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L11FragmentAct : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActL11FragmentBindingBinding>(this,R.layout.act_l11_fragment_binding)
    }
}