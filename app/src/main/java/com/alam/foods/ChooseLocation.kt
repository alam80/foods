package com.alam.foods

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alam.foods.databinding.ActivityChooseLocationBinding

class ChooseLocation : AppCompatActivity() {
    private val  binding:ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val locationList= arrayOf("ranchi","Bihar","Jaipur","Delhi")
        val  adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        }
    }
