package com.mtsarkov.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnItemReselectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, R.string.favorite, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, R.string.watch_later, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, R.string.selections, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        poster_2.setOnClickListener{
            poster_2.animate()
                .setDuration(300)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .scaleX(0.9f)
                .scaleY(0.9f)
                .start()
        }
    }



}