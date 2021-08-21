package com.example.rhythm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.app.ActivityOptionsCompat
import com.example.rhythm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onBackPressed() {
        super.onBackPressed()
        System.exit(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeScreen()
    }


    private fun homeScreen() {
        val countDown: CountDownTimer
        countDown = object : CountDownTimer(3500, 1000) {
            override fun onTick(millisecsToFinish: Long) {}
            override fun onFinish() {
                val intent = Intent(this@MainActivity, Player::class.java)

                val compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity)

                startActivity(intent,compat.toBundle())
            }
        }
        countDown.start()
    }
}