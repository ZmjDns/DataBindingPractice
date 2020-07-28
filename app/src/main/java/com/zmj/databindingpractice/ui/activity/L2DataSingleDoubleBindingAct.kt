package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActivityDataSingleDoubleBindingBinding
import com.zmj.databindingpractice.entry.ObservableGoodsBean
import com.zmj.databindingpractice.entry.UserBean

/**
 * 数据单向/双向绑定
 */
class L2DataSingleDoubleBindingAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDataSingleDoubleBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_single_double_binding)

        val userBean = UserBean("Zmj","123123")
        binding.userInfo = userBean

        val goods = ObservableGoodsBean("Book","第一行代码",45.8f)

        binding.goods = goods
    }
}