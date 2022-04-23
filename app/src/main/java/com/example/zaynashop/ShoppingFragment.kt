package com.example.zaynashop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

lateinit var rv_posts: RecyclerView
lateinit var adapter: PostAdapter
var allPosts: MutableList<Post> = mutableListOf()
class ShoppingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_shopping, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv_posts = view.findViewById(R.id.rv_shopping_items)
        adapter = PostAdapter(requireContext(), allPosts)
        rv_posts.adapter = adapter
        rv_posts.layoutManager = gridLayoutManager
    }



    companion object {
        private const val TAG = "MainActivity"
    }
}