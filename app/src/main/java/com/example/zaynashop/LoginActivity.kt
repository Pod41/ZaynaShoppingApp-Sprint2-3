package com.example.zaynashop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var username = findViewById<EditText>(R.id.et_username)
        var password = findViewById<EditText>(R.id.et_password)
        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        val btn_sign_in = findViewById<Button>(R.id.btn_sign_in)

        val currentUser = ParseUser.getCurrentUser()
        if (currentUser != null) {
            goToMainActivity()
        }
        btn_sign_up.setOnClickListener() {
            sign_up(username.text.toString(), password.text.toString())
        }
        btn_sign_in.setOnClickListener() {
            sign_in(username.text.toString(), password.text.toString())
        }
    }

    private fun sign_in(username: String, password: String) {
        ParseUser.logInInBackground(username, password, ({ user, e ->
            if (user != null) {
                Toast.makeText(this, "Signed in successfully.", Toast.LENGTH_SHORT).show()
                Log.i(TAG, "Signed in successfully.")
                clear()
                goToMainActivity()
            } else {
                Toast.makeText(this, "Failed to sign in.", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Failed to sign in. ${e.stackTrace}")
            }})
        )
    }

    private fun sign_up(username: String, password: String) {
        val user = ParseUser()
        user.setUsername(username)
        user.setPassword(password)
        user.signUpInBackground { e ->
            if (e == null) {
                Toast.makeText(this, "Signed up successfully.", Toast.LENGTH_SHORT).show()
                Log.i(TAG, "Signed up successfully.")
                clear()
            } else {
                Toast.makeText(this, "Failed to sign up.", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Failed to sign up. ${e.stackTrace}")
            }
        }
    }

    private fun clear() {
        findViewById<EditText>(R.id.et_username).setText("")
        findViewById<EditText>(R.id.et_password).setText("")
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}