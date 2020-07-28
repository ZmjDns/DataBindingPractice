package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActObservableCollectionBinding
import kotlin.random.Random

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class L5ObservableCollectionAct : BaseActivity() {

    private val map = ObservableArrayMap<String,String>().apply {
        put("name","JerryMap")
        put("age","20")
    }
    private val list = ObservableArrayList<String>().apply {
        add("Hello")
        add("ObservableArrayList")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActObservableCollectionBinding = DataBindingUtil.setContentView(this,R.layout.act_observable_collection)

        binding.map = map
        binding.list = list

        binding.key = "name"
        binding.index = 1
    }

    fun changeData(view: View) {
        map["name"] = "new ObservableMap${Random.nextInt(100)}"
        list[1] = "new ObservableArrayList${Random.nextInt(100)}"
    }

}