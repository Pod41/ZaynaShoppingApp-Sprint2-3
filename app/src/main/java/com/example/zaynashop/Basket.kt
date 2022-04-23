package com.example.zaynashop

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("basket")
class Basket: ParseObject() {
    fun getQuantity(): Int? {
        return getInt(KEY_QUANTITY)
    }
    fun setQuantity(name:String) {
        put(KEY_QUANTITY, name)
    }
    fun getItem(): String? {
        return getString(KEY_ITEM)
    }
    fun setItem(parseUser: ParseUser) {
        put(KEY_USER, parseUser)
    }
    fun getUser(): ParseUser?{
        return getParseUser(KEY_USER)
    }
    fun setUser(seller: ParseUser) {
        put(KEY_USER, seller)
    }
    companion object {
        const val KEY_QUANTITY = "quantity"
        const val KEY_ITEM = "item"
        const val KEY_USER = "user"
    }
}