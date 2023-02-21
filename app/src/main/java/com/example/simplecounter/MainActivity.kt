package com.example.simplecounter

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.simplecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val button = binding.button
        val upgradeBtn = binding.upgradeBtn
        val textView = binding.textView

        count = 98
        button.setOnClickListener {
            count++
            textView.text = count.toString()

            if (count >= 100) {
                upgradeBtn.visibility = View.VISIBLE
                upgradeBtn.setOnClickListener {
                    button.text = "Add 2"

                    button.setOnClickListener {
                        count += 2
                        textView.text = count.toString()
                    }
                    upgradeBtn.visibility = View.GONE
                }
            }

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}