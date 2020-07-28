package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import androidx.core.database.DatabaseUtilsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL12RecyclerBinding
import com.zmj.databindingpractice.entry.UserBean
import com.zmj.databindingpractice.ui.adpter.L12RecyclerBindingAdapter
import com.zmj.databindingpractice.ui.adpter.L12RecyclerListAdapter

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L12RecyclerAct: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActL12RecyclerBinding = DataBindingUtil.setContentView(this, R.layout.act_l12_recycler)

        val data: ArrayList<UserBean> = createData()

        binding.rvView.adapter = L12RecyclerBindingAdapter(data)
        binding.rvView.adapter
        binding.rvView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }

    private fun createData(): ArrayList<UserBean> {

        val data = ArrayList<UserBean>()

        for (i in 0 until 20){
            data.add(UserBean("zmj$i","zmjPass$i"))
        }
        return data
    }
}