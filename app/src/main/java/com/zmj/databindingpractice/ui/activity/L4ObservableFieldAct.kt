package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActObservableFieldBinding
import com.zmj.databindingpractice.entry.GoodsBean
import com.zmj.databindingpractice.entry.ObservableGoodsBean
import kotlin.random.Random

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class L4ObservableFieldAct: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActObservableFieldBinding>(this,R.layout.act_observable_field)

        val observableGoods = ObservableGoodsBean("第一行代码","Hello",45.8f)
        binding.goodsBean = observableGoods
        binding.goodsHandler = ObservableGoodsHandler(observableGoods)
    }

    class ObservableGoodsHandler(private val observableGoodsBean: ObservableGoodsBean){
        fun changeGoodsName(){
            observableGoodsBean.name.set("fieldName${Random.nextInt(100)}")
        }

        fun changeDetailsAndPrice(){
            observableGoodsBean.details.set("fieldDetails${Random.nextInt(1000)}")
            observableGoodsBean.price.set(Random.nextFloat() * 100)
        }
    }
}