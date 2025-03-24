package com.example.map524_assignment3

import android.content.Intent
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
            Product(1, R.drawable.product1, "iPhone16 Pro", "Storage: 256GB\n" +
                    "Screen: 6.9\" or 6.3\"\n" +
                    "Apple Intelligence" +
                    "From $1449"),
            Product(2, R.drawable.product2, "iPhone16", "Storage: 128GB\n" +
                    "Screen: 6.7\" or 6.1\"\n" +
                    "Apple Intelligence" +
                    "From $1129"),
            Product(3, R.drawable.product3, "MacBook Pro", "14\" or 16\"\n" +
                    "Memory: 16GB or 24GB or 32GB\n" +
                    "Storage: 512GB or 1TB or 2TB\n" +
                    "From $2099"),
            Product(4, R.drawable.product4, "MacBook Air", "13\" or 15\"\n" +
                    "Memory: 16GB or 24GB or 32GB\n" +
                    "Storage: 512GB or 1TB or 2TB\n" +
                    "From $1399"),
            Product(5, R.drawable.product5, "Airpods Pro2", "Up to 5 hrs of listening time on a single charge\n" +
                    "Up to 30 hrs of total listening time, using the case\n" +
                    "Dust-, sweat- and water- resistant\n" +
                    "From $329"),
            Product(6, R.drawable.product6, "Airpods Max", "Up to 20 hours of listening time on a single charge " +
                    "with Active Noise Cancellation enabled Footnote\n" +
                    "Dust-, sweat- and water- resistant\n" +
                    "From $779")
        )

        val productList = mutableListOf<Product>()
        var idCounter = 1

        while (productList.size < 50) {
            baseProducts.forEach { product ->
                if (productList.size < 50) {
                    productList.add(product.copy(id = idCounter++))
                }
            }
        }

        recyclerView.adapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("product_id", product.id)
                putExtra("product_image", product.imageId)
                putExtra("product_title", product.title)
                putExtra("product_description", product.desc)
            }
            startActivity(intent)
        }
    }
}
