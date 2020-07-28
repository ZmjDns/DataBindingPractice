package com.zmj.databindingpractice.ui.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zmj.databindingpractice.App
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.databinding.RvItemBinding
import com.zmj.databindingpractice.entry.UserBean

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description : 
 */
class L12RecyclerBindingAdapter(val mData: List<UserBean>): RecyclerView.Adapter<L12RecyclerBindingAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val binding: RvItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.rv_item,parent,false)
        //return MyViewHolder(binding)
        return MyViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class MyViewHolder(val itemBinding: RvItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.setClickListener {
                itemBinding.userInfo?.let {userInfo ->
                    doSomeThing(userInfo,it)
                }
            }
        }

        private fun doSomeThing(userInfo: UserBean, it: View) {
            Toast.makeText(App.getApplicationContext(),userInfo.name,Toast.LENGTH_SHORT).show()
        }

        fun bind(itemUser: UserBean){
            itemBinding.apply {
                userInfo = itemUser
                executePendingBindings()
            }
        }
    }
}