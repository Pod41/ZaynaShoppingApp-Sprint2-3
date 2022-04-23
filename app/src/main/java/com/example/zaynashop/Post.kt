package com.example.zaynashop

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import java.io.File

@ParseClassName("Post")
class Post: ParseObject()  {
    fun getName(): String? {
        return getString(KEY_NAME)
    }
    fun setName(name:String) {
        put(KEY_NAME, name)
    }
    fun getSize(): String? {
        return getString(KEY_SIZE)
    }
    fun setSize(size: Int) {
        put(KEY_SIZE, size)
    }
    fun getSeller(): ParseUser?{
        return getParseUser(KEY_SELLER)
    }
    fun setSeller(seller: ParseUser) {
        put(KEY_SELLER, seller)
    }
    fun getImage(): ParseFile? {
        return getParseFile(KEY_IMAGE)
    }
    fun setImage(image: ParseFile) {
        put(KEY_IMAGE, image)
    }
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }
    fun setDescription(description: String) {
        put(KEY_DESCRIPTION, description)
    }
    companion object {
        private const val TAG = "Post"
        const val KEY_NAME = "name"
        const val KEY_SIZE = "size"
        const val KEY_SELLER = "user"
        const val KEY_IMAGE = "image"
        const val KEY_DESCRIPTION = "description"
    }
}