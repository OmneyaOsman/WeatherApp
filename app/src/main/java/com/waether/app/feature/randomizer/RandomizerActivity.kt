package com.waether.app.feature.randomizer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.omni.usescases.randomNumberGenerator
import com.waether.app.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_randomizer.*
import java.util.concurrent.TimeUnit

private const val FINISH_AFTER = 10L
private const val INTERVAL_IN = 1L

class RandomizerActivity : AppCompatActivity() {

    private lateinit var timerSubscription: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)

//        val viewModel = ViewModelProviders.of(this).get(RandomizerViewModel::class.java)
//        viewModel.numberLiveData.observe(this, Observer {
//            random_number_text_view.text = it?.toString()
//        })

        timerSubscription =   Observable
            .interval(INTERVAL_IN , FINISH_AFTER,TimeUnit.SECONDS , Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { random_number_text_view.text = randomNumberGenerator().toInt().toString()}
//        timerSubscription = Observable.interval(1 , TimeUnit.SECONDS)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeWith(getTimerObserver())
    }

    private fun getTimerObserver() = object : DisposableObserver<Long>(){
        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
        }

        override fun onNext(t: Long) {
            random_number_text_view.text = randomNumberGenerator().toInt().toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (!timerSubscription.isDisposed)
            timerSubscription.dispose()
    }
}
