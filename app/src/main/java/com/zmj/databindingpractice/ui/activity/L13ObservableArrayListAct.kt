package com.zmj.databindingpractice.ui.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DividerItemDecoration
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.ActL13ObservableArraylistBinding
import com.zmj.databindingpractice.entry.UserBean
import com.zmj.databindingpractice.ui.adpter.DynamicChangeCallBack
import com.zmj.databindingpractice.ui.adpter.L12RecyclerBindingAdapter
import kotlin.random.Random

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :
 */
class L13ObservableArrayListAct: BaseActivity() {

    private val observableListData = ObservableArrayList<UserBean>().apply {
        for (i in 0 until 3){
            add(UserBean("zmj$i","zmjPassword$i"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActL13ObservableArraylistBinding = DataBindingUtil.setContentView(this,R.layout.act_l13_observable_arraylist)

        val adapter = L12RecyclerBindingAdapter(observableListData)
        binding.rvRecycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        adapter.notifyDataSetChanged()

        observableListData.addOnListChangedCallback(DynamicChangeCallBack<UserBean>(adapter))

        binding.rvRecycler.adapter = adapter

    }


    fun addItem(view: View) {
        if (observableListData.size >= 3){
            val userBean = UserBean("user_100",Random.nextInt(10000).toString())
            observableListData.add(1,userBean)
        }
    }
    fun addItemList(view: View) {
        val addList = ArrayList<UserBean>()
        for (i in 0..2){
            addList.add(UserBean("addUser_$i","passs${Random.nextInt(100000)}"))
        }
        observableListData.addAll(1,addList)
    }
    fun removeItem(view: View) {
        if (observableListData.size >= 3){
            observableListData.removeAt(1)
        }
    }
    fun updateItem(view: View) {
        if (observableListData.size >= 3){
            val userBean = observableListData[1]
            userBean.name = "UpdateNameZMJ${Random.nextInt(10000)}"
            userBean.passWord = "UpdateZMJPass${Random.nextInt(10000)}"
            observableListData[1] = userBean
        }
    }

}