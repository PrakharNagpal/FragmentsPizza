package com.example.androidfragmentpizzakotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidfragmentpizzakotlin.Data.Pizza
import com.example.androidfragmentpizzakotlin.R
import java.text.FieldPosition

class PizzaDetailFragment: Fragment() {
    var position=0
    var tvTitle: TextView?=null
    var tvDetails:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            if(arguments!=null){
                position= requireArguments().getInt("position",0)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_pizza_detail,parent,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvTitle=view.findViewById<View>(R.id.tvTitle) as TextView
        tvDetails=view.findViewById<View>(R.id.tvDetails) as TextView
        tvTitle!!.text = Pizza.pizzaMenu[position]
        tvDetails!!.text = Pizza.pizzaDetails[position]

    }
    fun updateView(position: Int) {
    tvTitle!!.text= Pizza.pizzaMenu[position]
        tvDetails!!.text=Pizza.pizzaDetails[position]
    }
}