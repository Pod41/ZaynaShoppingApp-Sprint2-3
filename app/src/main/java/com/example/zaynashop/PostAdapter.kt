package com.example.zaynashop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import java.util.zip.Inflater

class PostAdapter(val context: Context, val posts: List<Post>)
    :RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.shopping_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount() = posts.size
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //val tv_name : TextView
        val im_photo: ImageView
        //val tv_description: TextView
        //val tv_size: TextView

        init {
            itemView.setOnClickListener(this)
            //tv_name = itemView.findViewById(R.id.tv_name)
            im_photo = itemView.findViewById(R.id.im_photo)
            //tv_description = itemView.findViewById(R.id.tv_description)
            //tv_size = itemView.findViewById(R.id.tv_size)
        }

        fun bind(post: Post) {
            //tv_name.text = post.getName()
            Glide.with(itemView.context).load(post.getImage()?.url).placeholder(R.drawable.tshirt).centerCrop().into(im_photo)
            //tv_description.text = post.getDescription()
            //tv_size.text = "Size: "+post.getSize()
        }

        override fun onClick(v: View?) {
            Toast.makeText(itemView.context, "$itemView", Toast.LENGTH_SHORT).show()
            launchComposeView()
        }
        fun launchComposeView() {
            val intent = Intent(itemView.context, ItemFragment::class.java)
            itemView.context.startActivity(intent)
        }



    }



}