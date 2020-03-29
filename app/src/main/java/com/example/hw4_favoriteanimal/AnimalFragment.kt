package com.example.hw4_favoriteanimal

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_animal.*
import kotlinx.android.synthetic.main.fragment_animal.view.*

/**
 * A simple [Fragment] subclass.
 */
class AnimalFragment : Fragment() {
    private val TAG = "AnimalFragment"
    val myratefragment = RateFragment()
    val bundle = Bundle()

//    private lateinit var viewModel: AnimalRateClass
    private lateinit var viewModel: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal, main_container, false)

        view.dogbutton.setOnClickListener {
            bundle.putString("ratingdog", view.ratingdog.text.toString())
            bundle.putString("ratingcat", view.ratingcat.text.toString())
            bundle.putString("ratingbear", view.ratingbear.text.toString())
            bundle.putString("ratingrabbit", view.ratingrabbit.text.toString())
            bundle.putString("animal", "Dog")

            myratefragment.arguments = bundle

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myratefragment).addToBackStack(null).commit()
            }
            else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.rate_container, myratefragment).addToBackStack(null).commit()
            }
        }

        view.catbutton.setOnClickListener {
            bundle.putString("ratingdog", view.ratingdog.text.toString())
            bundle.putString("ratingcat", view.ratingcat.text.toString())
            bundle.putString("ratingbear", view.ratingbear.text.toString())
            bundle.putString("ratingrabbit", view.ratingrabbit.text.toString())
            bundle.putString("animal", "Cat")
            myratefragment.arguments = bundle

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myratefragment).addToBackStack(null).commit()
            }
            else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.rate_container, myratefragment).addToBackStack(null).commit()
            }
        }

        view.bearbutton.setOnClickListener {
            bundle.putString("ratingdog", view.ratingdog.text.toString())
            bundle.putString("ratingcat", view.ratingcat.text.toString())
            bundle.putString("ratingbear", view.ratingbear.text.toString())
            bundle.putString("ratingrabbit", view.ratingrabbit.text.toString())
            bundle.putString("animal", "Bear")
            myratefragment.arguments = bundle

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myratefragment).addToBackStack(null).commit()
            }
            else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.rate_container, myratefragment).addToBackStack(null).commit()
            }
        }
            view.rabbitbutton.setOnClickListener {
            bundle.putString("ratingdog", view.ratingdog.text.toString())
            bundle.putString("ratingcat", view.ratingcat.text.toString())
            bundle.putString("ratingbear", view.ratingbear.text.toString())
            bundle.putString("ratingrabbit", view.ratingrabbit.text.toString())
            bundle.putString("animal", "Rabbit")
            myratefragment.arguments = bundle

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container, myratefragment).addToBackStack(null).commit()
            }
            else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.rate_container, myratefragment).addToBackStack(null).commit()
            }
        }
        return view
    }

//    override fun onStart() {
//        super.onStart()
//        if (arguments != null) {
//            val Animal = arguments?.getString("animal") ?:""
//            val Rate = arguments?.getString("rate") ?:""
//            val AnimalRate = RatingsClass(Animal, Rate)
//            updateRating(AnimalRate)
//        }
//    }

    override fun onStart() {
        super.onStart()
        if (arguments != null) {
            val dog = arguments?.getString("ratingdog") ?:""
            val cat = arguments?.getString("ratingcat") ?:""
            val bear = arguments?.getString("ratingbear") ?:""
            val rabbit = arguments?.getString("ratingrabbit") ?:""

            ratingdog.text = dog
            ratingcat.text = cat
            ratingbear.text = bear
            ratingrabbit.text = rabbit

            val Animal = arguments?.getString("animal") ?:""
            val Rate = arguments?.getString("rate") ?:""
            val AnimalRate = RatingsClass(Animal, Rate)
            updateRating(AnimalRate)

        }
    }

    fun updateRating( Animal: RatingsClass) {
         when(Animal.animal) {
             "Dog" -> ratingdog.text = Animal.rating
             "Cat" -> ratingcat.text = Animal.rating
             "Bear" -> ratingbear.text = Animal.rating
             "Rabbit" -> ratingrabbit.text = Animal.rating
        }

    }

}
