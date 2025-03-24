package com.example.map524_assignment3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val productImage: ImageView = findViewById(R.id.product_image)
        val productTitle: TextView = findViewById(R.id.product_title)
        val productDescription: TextView = findViewById(R.id.product_description)

        val imageRes = intent.getIntExtra("product_image", 0)
        val title = intent.getStringExtra("product_title")
        val description = intent.getStringExtra("product_description")

        productImage.setImageResource(imageRes)
        productTitle.text = title
        productDescription.text = description
    }
}
