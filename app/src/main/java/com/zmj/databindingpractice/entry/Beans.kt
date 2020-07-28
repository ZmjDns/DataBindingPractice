package com.zmj.databindingpractice.entry

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import com.zmj.databindingpractice.BR

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/27
 * Description :
 */
class UserBean(var name: String,var passWord: String)

class ObservableGoodsBean(name: String,details: String,price: Float){
    val name: ObservableField<String> = ObservableField(name)
    val details: ObservableField<String> = ObservableField(details)
    val price: ObservableFloat = ObservableFloat(price)
}

class GoodsBean : BaseObservable(){

    @Bindable
    var name = ""
        set(value) {
            field = value
            //只更新本字段
            notifyPropertyChanged(BR.name)
        }
    @Bindable
    var details = ""
        set(value) {
            field = value
            //更新所有字段
            notifyChange()
        }
    var price = 0f
}

class ImageBean(url: String){
    var url: ObservableField<String> = ObservableField(url)
}
