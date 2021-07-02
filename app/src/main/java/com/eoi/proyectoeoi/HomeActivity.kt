package com.eoi.proyectoeoi

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eoi.proyectoeoi.databinding.ActivityHomeBinding
import com.eoi.proyectoeoi.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val DBName = "SportApp"
    val USERNAME = "username"

    private lateinit var b: ActivityHomeBinding
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityHomeBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        sharedPref = getSharedPreferences(DBName, Context.MODE_PRIVATE)

        val name = sharedPref.getString(USERNAME, null)

        if(name != null) {
            showApp(name)
        }

        b.btSignUp.setOnClickListener {
            requestName()
        }

        b.btOkSign.setOnClickListener {
            checkRegister()
        }

    }

    fun showApp(name: String) {
        b.linearHome.visibility = View.VISIBLE
        b.linearSign.visibility = View.GONE
    }

    fun requestName() {
        b.linearHome.visibility = View.GONE
        b.linearSign.visibility = View.VISIBLE
    }

    fun signEnd() {

    }

    fun checkRegister() {
        val okPassword = b.etPassword.toString()
        if(okPassword.length < 6) {
            val edit = sharedPref.edit()
            edit.putString(USERNAME, okPassword)
            edit.apply()

            signEnd()
        } else {
            Toast.makeText(this, "Introduce una contraseña válida", Toast.LENGTH_SHORT).show()
        }
    }
}