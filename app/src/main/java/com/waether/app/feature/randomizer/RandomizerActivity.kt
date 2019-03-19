package com.waether.app.feature.randomizer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.waether.app.R
import kotlinx.android.synthetic.main.activity_randomizer.*

class RandomizerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        val viewModel = ViewModelProviders.of(this).get(RandomizerViewModel::class.java)
        viewModel.numberLiveData.observe(this, Observer {
            random_number_text_view.text = it?.toString()
        })

        increment_button.setOnClickListener {
            viewModel.incrementNumber()
        }
    }
}
