package com.eoi.proyectoeoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.eoi.proyectoeoi.databinding.ActivityMainBinding
import com.rommansabbir.animationx.Fade
import com.rommansabbir.animationx.animationXFade

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        appear()
        disappear()
        goHome()
    }

    fun appear() {
        b.projectlogo.animationXFade(Fade.FADE_IN)
    }

    fun disappear() {
        Handler(Looper.getMainLooper()).postDelayed({
            b.projectlogo.animationXFade(Fade.FADE_OUT)
        }, 2000)
    }

    fun goHome() {
        Handler(Looper.getMainLooper()).postDelayed({
           startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 3100)
    }
}