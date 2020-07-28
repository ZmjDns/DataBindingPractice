package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.zmj.databindingpractice.BR
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActBaseObservableBinding
import com.zmj.databindingpractice.entry.GoodsBean
import kotlin.random.Random

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class L3BaseObservableAct : BaseActivity() {

    private val TAG = "BaseObservableAct"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActBaseObservableBinding>(this, R.layout.act_base_observable)

        val goods = GoodsBean()
        goods.name = "第一行代码"
        goods.details = "本书描述"
        goods.price = 48.5f

        binding.goods = goods

        binding.goodsHandler = GoodsHandler(goods)

        goods.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when(propertyId){
                    BR.name -> {Log.e(TAG,"BR.name -> ${BR.name}")}
                    BR.details -> {Log.e(TAG,"BR.details -> ${BR.details}")}
                    BR._all -> {Log.e(TAG,"BR._all -> ${BR._all}")}
                    else -> {Log.e(TAG,"未知.....")}
                }
            }
        })
    }

    class GoodsHandler(private val goodsBean: GoodsBean){

        fun changeGoodsName(){
            goodsBean.price = Random.nextFloat()
            goodsBean.name = "第一行代码${goodsBean.price}"
        }

        fun changeGoodsDetails(){
            goodsBean.price = Random.nextFloat()
            goodsBean.details = "Hello${goodsBean.price}"
        }
    }
}