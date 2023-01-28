package com.example.androidfragmentpizzakotlin

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidfragmentpizzakotlin.Data.Pizza
import com.example.androidfragmentpizzakotlin.fragments.PizzaDetailFragment
import com.example.androidfragmentpizzakotlin.fragments.PizzaMenuFragment

class MainActivity : AppCompatActivity(),PizzaMenuFragment.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", resources.configuration.orientation.toString() + "")

        if (savedInstanceState == null) {
            val firstFragment = PizzaMenuFragment()

            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flContainer, firstFragment)
            ft.commit()
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val secondFragment = PizzaDetailFragment()
            val args = Bundle()
            args.putInt("position", 0)
            secondFragment.arguments = args
            val ft2 = supportFragmentManager.beginTransaction()
            ft2.add(R.id.flContainer2, secondFragment)
            ft2.commit()

        }
    }

       override fun onPizzaItemSelected(position: Int) {
            Toast.makeText(this, "Called By Fragment A: position - $position", Toast.LENGTH_SHORT)
                .show()

            // Load Pizza Detail Fragment
            val secondFragment = PizzaDetailFragment()
            val args = Bundle()
            args.putInt("position", position)
            secondFragment.arguments = args // (1) Communicate with Fragment using Bundle
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment) // replace flContainer
                    //.addToBackStack(null)
                    .commit()
            } else { // PORTRAIT Orientation
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment) // replace flContainer
                    .addToBackStack(null)
                    .commit()
            }
        }

}