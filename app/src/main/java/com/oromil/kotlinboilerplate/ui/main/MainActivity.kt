package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.Observer
import android.support.constraint.ConstraintLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.oromil.kotlinboilerplate.R
import com.oromil.kotlinboilerplate.dagger.components.ActivityComponent
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import com.oromil.kotlinboilerplate.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onComponentCreated(component: ActivityComponent) = component.inject(this)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initViews() {
        swipeRefreshLayout = refreshLayout

//        swipeRefreshLayout.setOnRefreshListener { mPresenter.loadNews() }

        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.adapter = NewsAdapter()

        newsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy < 0) {
                    btn_top.visibility = View.VISIBLE
                } else btn_top.visibility = View.GONE
            }
        })

        btn_top.setOnClickListener { newsRecyclerView.scrollToPosition(0) }
    }

    override fun subscribeOnViewModelLiveData() {

        mViewModel.subscribeOnNewsUpdates().observe(this, Observer { data ->
            (newsRecyclerView.adapter as NewsAdapter).updateData(data as List<StoryEntity>)
            swipeRefreshLayout.isRefreshing = false
        })
    }
}
