package com.neptuz.neptuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        register_button_register.setOnClickListener {

            val email = email_edittext_register.text.toString()
            val password = password_edittext_register.text.toString()

            Log.d("MainActivity", "Email is : " + email)
            Log.d("MainActivity", "Password is : $password")

        }


        already_have_account_textview.setOnClickListener {

        // laounch the login activity somehow
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)


        }

    }
}
