package com.fegs.bestbooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fegs.bestbooks.R
import com.fegs.bestbooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = "Books"
        setSupportActionBar(binding.toolbarMain)
    }
}