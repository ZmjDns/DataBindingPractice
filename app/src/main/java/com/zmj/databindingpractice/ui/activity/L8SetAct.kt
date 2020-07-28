package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import android.util.SparseArray
import androidx.core.util.set
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL8SetBinding

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L8SetAct : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActL8SetBinding = DataBindingUtil.setContentView(this,R.layout.act_l8_set)

        binding.list = arrayListOf("arrayList zmj","arrayList dns")
        val sparseArray = SparseArray<String>()
        sparseArray.append(0,"sparseArrayZmj0")
        sparseArray.append(1,"sparseArrayZmj1")

        val map = mutableMapOf<String,String>()
        map["zmj"] = "map Hello"
        val set = mutableSetOf<String>()
        set.add("XXX")

        binding.array = arrayOf("array Hello","array Hi")
        binding.map = map
        binding.set = set
        binding.sparse = sparseArray
        binding.index = 1
        binding.key = "zmj"
    }
}