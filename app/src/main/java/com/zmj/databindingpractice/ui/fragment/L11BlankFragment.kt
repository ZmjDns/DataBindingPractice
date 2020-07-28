package com.zmj.databindingpractice.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.FragmentL11BlankBinding

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L11BlankFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentL11BlankBinding>(inflater,R.layout.fragment_l11_blank,container,false)
        binding.text = "Hello I am empty fragment"
        return binding.root
    }

}