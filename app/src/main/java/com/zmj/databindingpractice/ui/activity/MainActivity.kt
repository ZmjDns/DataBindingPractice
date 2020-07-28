package com.zmj.databindingpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zmj.databindingpractice.R
import com.zmj.databindingpractice.ui.fragment.L11BlankFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun <T: BaseActivity>startActivity(activity: Class<T>){
        startActivity(Intent(this,activity))
    }

    fun singleDoubleBinding(view: View) {
        startActivity(L2DataSingleDoubleBindingAct::class.java)
    }

    fun baseObservable(view: View) {
        startActivity(L3BaseObservableAct::class.java)
    }

    fun observableField(view: View) {
        startActivity(L4ObservableFieldAct::class.java)
    }

    fun observableCollect(view: View) {
        startActivity(L5ObservableCollectionAct::class.java)
    }

    fun bindEvent(view: View) {
        startActivity(L6EventBindingAct::class.java)
    }

    fun viewStubIncludeBinding(view: View) {
        startActivity(L7ViewStubAndIncludeAct::class.java)
    }

    fun setSystem(view: View) { startActivity(L8SetAct::class.java) }
    fun convert(view: View) { startActivity(L9BindingAdapterConversionAct::class.java) }
    fun sourceLink(view: View) { startActivity(L10ResourceLinkAct::class.java) }
    fun fragment(view: View) { startActivity(L11FragmentAct::class.java) }
    fun recycler(view: View) { startActivity(L12RecyclerAct::class.java) }
    fun observableList(view: View) { startActivity(L13ObservableArrayListAct::class.java) }
}