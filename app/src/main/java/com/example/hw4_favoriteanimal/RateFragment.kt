package com.example.hw4_favoriteanimal

import android.content.Context.MODE_PRIVATE
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_rate.*
import kotlinx.android.synthetic.main.fragment_rate.view.*


/**
 * A simple [Fragment] subclass.
 */
class RateFragment : Fragment() {
    private val TAG = "RateFragment"

    private val RATES_FILE = "MyRatings"
    private val animalrates = mutableListOf<RatingsClass>()

    private lateinit var viewModel: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rate, main_container, false)
        val bundle = Bundle()

        view.savebutton.setOnClickListener {
            val dog = RatingsClass("Dog", arguments?.getString("ratingdog") ?:"")
            val cat = RatingsClass("Cat",arguments?.getString("ratingcat") ?:"")
            val bear = RatingsClass("Bear",arguments?.getString("ratingbear") ?:"")
            val rabbit = RatingsClass("Rabbit",arguments?.getString("ratingrabbit") ?:"")

            bundle.putString("ratingdog", dog.rating)
            bundle.putString("ratingcat", cat.rating)
            bundle.putString("ratingbear", bear.rating)
            bundle.putString("ratingrabbit", rabbit.rating)

            val myanimalfragment = AnimalFragment()
            val rating = "Your Rating: " + ratingBar.rating.toString()

            bundle.putString("animal", animalname.text.toString())
            bundle.putString("rate", rating)
            myanimalfragment.arguments = bundle

            when (animalname.text.toString()) {
                "Dog" -> dog.rating = rating
                "Cat" -> cat.rating = rating
                "Bear" -> bear.rating = rating
                "Rabbit" -> rabbit.rating = rating
            }

            animalrates.add(dog)
            animalrates.add(cat)
            animalrates.add(bear)
            animalrates.add(rabbit)

            val sharedPreferences = this.activity!!.getSharedPreferences(RATES_FILE, MODE_PRIVATE)
            val rateData = sharedPreferences.getString("Rates", "")?:""
            val gson = Gson()
            val editor = sharedPreferences.edit()

            val savedRatingsListJson = gson.toJson(animalrates)
            editor.putString("Rates", savedRatingsListJson)
            editor.apply()

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myanimalfragment).addToBackStack(null).commit()
            }
            else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myanimalfragment).addToBackStack(null).commit()
            }
        }


        return view
    }

    override fun onStart() {
        super.onStart()
        ratingBar.rating = 0.0F
        if (arguments != null) {
            val animal = arguments?.getString("animal") ?:""
            updateAnimal(animal)
        }
    }

    fun updateAnimal( animal: String) {
        animalname.text = animal
        val image = when(animal) {
            "Dog" -> R.drawable.dog
            "Cat" -> R.drawable.cat
            "Bear" -> R.drawable.bear
            else -> R.drawable.rabbit
        }

        animalpic.setImageResource(image)
    }

}
