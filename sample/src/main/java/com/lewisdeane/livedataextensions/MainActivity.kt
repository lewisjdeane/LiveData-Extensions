package com.lewisdeane.livedataextensions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.liveGreeting.observe(this, Observer {
            greeting.text = it
        })

        viewModel.liveGreetingWithAge.observe(this, Observer {
            greetingWithAge.text = it
        })

        viewModel.liveGreetingWithAgeAndCountry.observe(this, Observer {
            greetingWithAgeAndCountry.text = it
        })

        viewModel.liveNameAndCountry.observe(this, Observer {
            greetingNameAndCountry.text = it
        })

        viewModel.liveAllInfo.observe(this, Observer {
            greetingAll.text = it
        })
    }

    private fun setupListeners() {
        name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setName(p0?.toString() ?: "")
            }
        })

        age.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setAge(p0?.toString()?.toInt() ?: 0)
            }
        })

        country.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setCountry(p0?.toString() ?: "")
            }
        })

        isAsleep.setOnCheckedChangeListener { _, isChecked -> viewModel.setIsAsleep(isChecked) }
    }
}
