package com.example.hw4_favoriteanimal

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_animal.*
import kotlinx.android.synthetic.main.fragment_rate.*

class MainActivity : AppCompatActivity() {


    private val RATES_FILE = "MyRatings"
    private val animalrates = mutableListOf<RatingsClass>()
    private val myanimalfragment = AnimalFragment()
    private val myratefragment = RateFragment()
    private val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(RATES_FILE, Context.MODE_PRIVATE)
        val rateData = sharedPreferences.getString("Rates", "")?:""
        val gson = Gson()

        if (rateData.isNotEmpty()) {
            val sType = object : TypeToken<List<RatingsClass>>() {}.type
            val savedRatingsList = gson.fromJson<List<RatingsClass>>(rateData, sType)

            for (A in savedRatingsList) {
                animalrates.add(A)
            }
            bundle.putString("ratingdog", animalrates[0].rating)
            bundle.putString("ratingcat", animalrates[1].rating)
            bundle.putString("ratingbear", animalrates[2].rating)
            bundle.putString("ratingrabbit", animalrates[3].rating)
            myanimalfragment.arguments = bundle

        }
        else {
            animalrates.add(RatingsClass("Dog", "Your Rating: 0"))
            animalrates.add(RatingsClass("Cat", "Your Rating: 0"))
            animalrates.add(RatingsClass("Bear", "Your Rating: 0"))
            animalrates.add(RatingsClass("Rabbit", "Your Rating: 0"))

            bundle.putString("ratingdog", animalrates[0].rating)
            bundle.putString("ratingcat", animalrates[1].rating)
            bundle.putString("ratingbear", animalrates[2].rating)
            bundle.putString("ratingrabbit", animalrates[3].rating)
            myanimalfragment.arguments = bundle
        }

        supportFragmentManager.beginTransaction().replace(R.id.main_container, myanimalfragment).addToBackStack(null).commit()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction().replace(R.id.rate_container, myratefragment).addToBackStack(null).commit()
        }
    }

}
