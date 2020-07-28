package com.zmj.databindingpractice.ui.adpter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zmj.databindingpractice.App
import com.zmj.databindingpractice.databinding.RvItemBinding
import com.zmj.databindingpractice.entry.UserBean

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/28
 * Description :  此适配器需要配合ViewModel来执行
 * 实例之后
 * ViewModel.Data.observer(viewLifecycleOwner){
 *      adapter.submitList(data)
 * }
 *
 *
 */
class L12RecyclerListAdapter: ListAdapter<UserBean,L12RecyclerListAdapter.ListAdapterViewHolder>(UserDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {

        return ListAdapterViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ListAdapterViewHolder(val itemBinding:RvItemBinding):RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.setClickListener {
                itemBinding.userInfo?.let { userBean ->
                    doSomeThing(userBean,it)
                }
            }
        }
        private fun doSomeThing(userBean: UserBean, it: View) {
            Toast.makeText(App.getApplicationContext(),userBean.name,Toast.LENGTH_SHORT).show()
        }

        fun bind(itemData: UserBean){
            itemBinding.apply {
                userInfo = itemData
                executePendingBindings()
            }
        }
    }
}

class UserDiffCallBack: DiffUtil.ItemCallback<UserBean>(){
    override fun areItemsTheSame(oldItem: UserBean, newItem: UserBean): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: UserBean, newItem: UserBean): Boolean {
        return oldItem == newItem
    }

}