package com.example.map524_assignment3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val baseProducts = listOf(
            Product(1, R.drawable.product1, "iPhone16 Pro", "This is iPhone16 Pro."),
            Product(2, R.drawable.product2, "iPhone16", "This is iPhone16."),
            Product(3, R.drawable.product3, "MacBook Pro", "This is MacBook Pro"),
            Product(4, R.drawable.product4, "MacBook Air", "This is MacBook Air"),
            Product(5, R.drawable.product5, "Airpods Pro", "This is Airpods Pro"),
            Product(6, R.drawable.product6, "Airpods Max", "This is Airpods Max"),
        )

        val productList = mutableListOf<Product>()
        var idCounter = 1
        while (productList.size < 50) {
            baseProducts.forEach {
                if (productList.size < 50) {
                    productList.add(it.copy(id = idCounter++))
                }
            }
        }

        recyclerView.adapter = ProductAdapter(productList)
    }
}