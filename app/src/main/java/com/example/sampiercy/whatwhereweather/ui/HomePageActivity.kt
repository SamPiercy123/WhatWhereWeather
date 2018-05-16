package com.example.sampiercy.whatwhereweather.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.sampiercy.whatwhereweather.R
import com.example.sampiercy.whatwhereweather.extensions.tag
import com.example.sampiercy.whatwhereweather.ui.adapter.HomePageAdapter
import com.example.sampiercy.whatwhereweather.viewmodels.WeatherViewModel
import com.example.sampiercy.whatwhereweather.viewmodels.WeatherViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_home_page.*
import javax.inject.Inject

class HomePageActivity : DaggerAppCompatActivity() {

    /*  @Inject*/
    lateinit var weatherViewModel: WeatherViewModel

    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory

    var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        weatherViewModel = ViewModelProviders.of(this, weatherViewModelFactory).get(WeatherViewModel::class.java)

        compositeDisposable = CompositeDisposable()

        progress_loader.visibility = View.VISIBLE

        compositeDisposable?.add(
                weatherViewModel.getWeather(false).subscribeBy(
                        onSuccess = {
                            progress_loader.visibility = View.GONE
                            recyclerView.layoutManager = LinearLayoutManager(this)
                            recyclerView.adapter = HomePageAdapter(it, this)
                        },
                        onError = { it.message?.let { Log.e(tag(), it) } }
                )
        )

        swipeRefresh.setOnRefreshListener {
            refresh()
        }

    }

    fun refresh() {
        compositeDisposable?.add(
                weatherViewModel.getWeather(true).subscribeBy(
                        onSuccess = {
                            recyclerView.adapter = HomePageAdapter(it, this)
                            swipeRefresh.isRefreshing = false
                        },
                        onError = {
                            it.message?.let { Log.e(tag(), it) }
                            swipeRefresh.isRefreshing = false
                        }
                )
        )
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_refresh) {
            swipeRefresh.isRefreshing = true
            refresh()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.dispose()
    }

}
