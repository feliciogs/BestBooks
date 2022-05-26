package com.fegs.bestbooks.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.fegs.bestbooks.data.model.Book
import com.fegs.bestbooks.databinding.ItemBookBinding

class BooksAdapter(
    private val books: List<Book>
    ) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private lateinit var binding: ItemBookBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return  BooksViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){
        private val title = binding.textTitle
        private val author = binding.textAuthor

        fun bindView(book:Book){
            title.text = book.title
            author.text = book.author
        }
    }
}