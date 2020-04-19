package com.lewisdeane.livedataextensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val liveName = MutableLiveData<String>().apply {
        value = ""
    }

    private val liveAge = MutableLiveData<Int>().apply {
        value = 0
    }

    private val liveCountry = MutableLiveData<String>().apply {
        value = ""
    }

    private val liveIsAsleep = MutableLiveData<Boolean>().apply {
        value = false
    }

    val liveGreeting =
        liveName.map { name ->
            "Hello $name!"
        }

    val liveGreetingWithAge =
        liveName.mapWith(liveAge) { name, age ->
            "Hello $name, you are $age!"
        }

    val liveGreetingWithAgeAndCountry =
        liveName.mapWith(liveAge, liveCountry) { name, age, country ->
            "Hello $name, you are $age and are from $country!"
        }

    val liveNameAndCountry =
        Transformations.map(liveName, liveCountry) { name, country ->
            "Hello $name, you are from $country"
        }

    val liveAllInfo =
        Transformations.map(
            liveName,
            liveAge,
            liveCountry,
            liveIsAsleep
        ) { name, age, country, isAsleep ->
            "$name ($age, $country), ${if (isAsleep) "wake up" else "go to sleep"}! "
        }

    fun setName(name: String) {
        liveName.postValue(name)
    }

    fun setAge(age: Int) {
        liveAge.postValue(age)
    }

    fun setCountry(country: String) {
        liveCountry.postValue(country)
    }

    fun setIsAsleep(isAsleep: Boolean) {
        liveIsAsleep.postValue(isAsleep)
    }
}