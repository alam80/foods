package com.alam.foods

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alam.foods.databinding.ActivityStartBinding


class StartActivity : AppCompatActivity() {
    private val binding: ActivityStartBinding by lazy {
     ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val  intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}