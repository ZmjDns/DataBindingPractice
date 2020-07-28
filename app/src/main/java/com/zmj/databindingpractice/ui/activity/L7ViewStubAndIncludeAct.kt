package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewStub
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActViewstubIncludeBinding
import com.zmj.databindingpractice.databinding.ViewStubBinding
import com.zmj.databindingpractice.entry.UserBean

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class L7ViewStubAndIncludeAct : BaseActivity() {

    /*private val binding: ActViewstubIncludeBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.act_viewstub_include) as ActViewstubIncludeBinding
    }*/
    private lateinit var binding: ActViewstubIncludeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.act_viewstub_include)

        binding.handler = EventHandler()
        val user = UserBean("Jerry","123456")
        binding.userInfo = user

        //binding.viewStub指向ViewStub的Id
        binding.viewStub.setOnInflateListener { _, inflated ->
            //如果在xml中没有对ViewStub进行bind:userInfo="@{userInfo}"数据绑定
            //那么可以在此手动绑定
            val viewStubBinding: ViewStubBinding? =DataBindingUtil.bind(inflated)
            viewStubBinding?.let {
                viewStubBinding.userInfo = user
            }
            Log.e("L7ViewStubAndIncludeAct","viewStub手动绑定完成......")
        }
    }

    inner class EventHandler{
        fun onClick(v: View){
            Log.e("L7ViewStubAndIncludeAct","进入点击事件")
            if (!binding.viewStub.isInflated){
                binding.viewStub.viewStub?.inflate()
            }
        }
    }
}