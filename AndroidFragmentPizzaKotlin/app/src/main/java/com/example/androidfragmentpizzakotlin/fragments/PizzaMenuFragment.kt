package com.example.androidfragmentpizzakotlin.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.androidfragmentpizzakotlin.Data.Pizza
import com.example.androidfragmentpizzakotlin.R
import kotlinx.coroutines.NonDisposableHandle.parent

class PizzaMenuFragment: Fragment() {
    private var listener: OnItemSelectedListener? = null
    var itemsAdapter:ArrayAdapter<String>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemsAdapter= context?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1,Pizza.pizzaMenu) }
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_menu,parent ,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lvItems=view.findViewById<View>(R.id.lvItems) as ListView
        lvItems.adapter=itemsAdapter
        lvItems.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                // go to activity to load pizza details fragment
                listener!!.onPizzaItemSelected(position) // (3) Communicate with Activity using Listener
            }

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnItemSelectedListener)
        {
            listener=context
        }
        else
        {
            throw ClassCastException(
                context.toString()+" must implement PizzaMenuFragment"
            )
        }
    }


    interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        fun onPizzaItemSelected(position: Int)
    }


}