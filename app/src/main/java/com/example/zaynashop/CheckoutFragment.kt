package com.example.zaynashop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

lateinit var rv_Basket : RecyclerView
lateinit var adapterbasket: BasketAdapter
var allitems: MutableList<Basket> = mutableListOf()


class CheckoutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_Basket = view.findViewById(R.id.rv_items_in_basket)
        adapterbasket = BasketAdapter(requireContext(), allitems)
        rv_Basket.adapter = adapterbasket
        rv_Basket.layoutManager = LinearLayoutManager(requireContext())
        queryBasket()
    }

    private fun queryBasket() {
        val query: ParseQuery<Basket> = ParseQuery.getQuery(Basket::class.java)
        query.findInBackground(object : FindCallback<Basket>{
            override fun done(baskets: MutableList<Basket>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Failed to query for baskets.")
                    Toast.makeText(requireContext(), "Failed to query for baskets.", Toast.LENGTH_SHORT).show()
                } else {
                    if (baskets != null) {
                        allitems.addAll(baskets)
                        adapterbasket.notifyDataSetChanged()
                    }
                }
            }

        })
    }


    companion object {
        private const val TAG = "MainActivity"
    }
}