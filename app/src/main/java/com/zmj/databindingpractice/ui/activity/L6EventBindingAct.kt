package com.zmj.databindingpractice.ui.activity

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActEventBindingBinding
import com.zmj.databindingpractice.entry.UserBean

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class L6EventBindingAct : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActEventBindingBinding = DataBindingUtil.setContentView(this,R.layout.act_event_binding)

        val userBean = UserBean("Jerry","123456")

        binding.userInfo = userBean

        binding.userPresenter = UserPresenter(this,userBean,binding)
    }


    class UserPresenter(
        private val context: Context,
        private val userBean: UserBean,
        private val binding: ActEventBindingBinding
    ){

        fun onUserNameClick(user: UserBean){
            Toast.makeText(context,user.name,Toast.LENGTH_SHORT).show()
        }

        fun afterTextChanged(s:Editable){
            userBean.name = s.toString()
            binding.userInfo = userBean
        }

        fun afterPassWordChanged(s: Editable){
            userBean.passWord = s.toString()
            binding.userInfo = userBean
        }
    }
}