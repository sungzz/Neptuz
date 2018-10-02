package com.neptuz.neptuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    val verifyURL = "http://192.168.5.101/neptuz/insert_data_user.php"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        register_button_register.setOnClickListener {

           sendData()

        }

        already_have_account_textview.setOnClickListener {

        // launch the login activity somehow
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)

        }


    }

    private fun sendData() {

        val username = username_edittext_register.text.toString()
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        Log.d("MainActivity", "Email is : " + email)
        Log.d("MainActivity", "Password is : $password")


        val requesQ = Volley.newRequestQueue(this@MainActivity)

        val stringRequest = object: StringRequest(Request.Method.POST, verifyURL, Response.Listener<String> {
            response ->

            Log.d("test", "response correct")
                val obj = JSONObject(response)

                Toast.makeText(applicationContext,obj.getString("username"), Toast.LENGTH_SHORT).show()

                }, Response.ErrorListener {

            error ->

            Log.d("test", "here error here")
            Toast.makeText(applicationContext, error?.message, Toast.LENGTH_SHORT).show()

        })
        {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()

                params.put("username", username)
                params.put("email", email)
                params.put("password", password)

                Log.d("test", "here : $username")

                return params

            }
        }

        requesQ.add(stringRequest)

    }

}
