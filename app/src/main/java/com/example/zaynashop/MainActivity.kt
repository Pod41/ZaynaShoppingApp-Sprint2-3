package com.example.zaynashop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queryPost()

        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val shoppingFragment: Fragment = ShoppingFragment()
        val checkoutFragment: Fragment = CheckoutFragment()
        val profileFragment: Fragment = ProfileFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_favorites -> fragment = shoppingFragment
                R.id.action_schedules -> fragment = checkoutFragment
                R.id.action_music -> fragment = profileFragment
            }
            fragmentManager.beginTransaction().replace(R.id.Fragment, fragment).commit()
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.action_favorites
    }

    private fun queryPost() {
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.findInBackground(object : FindCallback<Post> {
            override fun done(posts: MutableList<Post>?, e: ParseException?) {
                if (e != null) {
                    Toast.makeText(this@MainActivity, "Query failed.", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "Query failed. ${e.printStackTrace()}")
                } else {
                    if (posts != null){
                        Log.e(TAG, "Successfully queried.")
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                }
            }

        })
    }


    companion object {
        private const val TAG = "MainActivity"
    }
}
