package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.Observer
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.oromil.kotlinboilerplate.R
import com.oromil.kotlinboilerplate.dagger.components.ActivityComponent
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import com.oromil.kotlinboilerplate.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainMvpView, MainPresenter, MainViewModel>(), MainMvpView {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onComponentCreated(component: ActivityComponent) {
        component.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
//        test.setImageDrawable(getDrawable(R.drawable.ic_default1))
        swipeRefreshLayout = refreshLayout
        swipeRefreshLayout.setOnRefreshListener { mPresenter.loadNews() }
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.adapter = NewsAdapter()
    }

    override fun getViewModel(): MainViewModel {
        return mViewModel
    }

    override fun subscribeOnViewModelLiveData() {

        mViewModel.getLiveData().observe(this, Observer { data ->
            Log.d("update", "OK")
            (newsRecyclerView.adapter as NewsAdapter).updateData(data as List<StoryEntity>)
            swipeRefreshLayout.isRefreshing = false
        })
    }
}
