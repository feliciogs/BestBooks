package com.fegs.bestbooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fegs.bestbooks.R
import com.fegs.bestbooks.data.model.Book
import com.fegs.bestbooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(binding.toolbarMain)

        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(binding.recyclerBooks){
                    layoutManager = LinearLayoutManager(this@BooksActivity,RecyclerView.VERTICAL,false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })
        viewModel.getBooks()
    }
}