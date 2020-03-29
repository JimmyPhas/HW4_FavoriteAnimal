package com.example.hw4_favoriteanimal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

data class RatingsClass(var animal:String, var rating: String): Serializable

//class AnimalRateClass : ViewModel() {
//    private val rateArray = mutableListOf<RatingsClass>()
//
//
//    fun setAll(dog: RatingsClass, cat: RatingsClass, bear: RatingsClass, rabbit: RatingsClass,) {
//        rateArray.add(dog)
//        rateArray.add(cat)
//        rateArray.add(bear)
//        rateArray.add(rabbit)
//    }
//
//    fun setAnimal(rate: RatingsClass) {
//        when (rate.animal) {
//            "Dog" -> rateArray[0].rating = rate.rating
//            "Cat" -> rateArray[1].rating = rate.rating
//            "Bear" -> rateArray[2].rating = rate.rating
//            "Rabbit" -> rateArray[3].rating = rate.rating
//        }
//    }
//}