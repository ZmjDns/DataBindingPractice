package com.zmj.databindingpractice.ui.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.DataBindingUtil
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL9BindingAdapterConversionBinding
import com.zmj.databindingpractice.entry.ImageBean
import kotlin.random.Random

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L9BindingAdapterConversionAct : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActL9BindingAdapterConversionBinding = DataBindingUtil.setContentView(this,R.layout.act_l9_binding_adapter_conversion)

        binding.image = ImageBean("www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png")
        binding.handler = Handler()

    }

    inner class Handler{
        fun onCLick(imageBean: ImageBean):Boolean{
            imageBean.url.set("XXXXX${Random.nextInt(1000)}")
            return true
        }
    }
}

@BindingAdapter("url")
fun loadImage(view: ImageView,url: String){
    Log.e("L9BindingAdapter","loadImageUrl$url")
}

@BindingConversion
fun convertString2Drawable(str: String): Drawable{
    return when(str){
        "红色" -> {
            ColorDrawable(Color.parseColor("#FF4081"))
        }
        "蓝色" -> {
            ColorDrawable(Color.parseColor("#3F51B5"))
        }
        else -> {
            ColorDrawable(Color.parseColor("#344567"))
        }
    }
}

@BindingConversion
fun convertString2Color(str: String): Int{
    return when(str){
        "红色" -> {
            Color.parseColor("#FF4081")
        }
        "蓝色" -> {
            Color.parseColor("#3F51B5")
        }
        else -> {
            Color.parseColor("#344567")
        }
    }
}