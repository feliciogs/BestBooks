package com.fegs.bestbooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fegs.bestbooks.data.APIService
import com.fegs.bestbooks.data.model.Book
import com.fegs.bestbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel: ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks(){
        APIService.service.getBooks().enqueue(object : Callback<BookBodyResponse>{
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if(response.isSuccessful){
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for(result in bookBodyResponse.bookResults){
                            val book = Book(
                                title= result.bookDetailsResponse[0].title,
                                author = result.bookDetailsResponse[0].author
                            )
                            books.add(book)
                        }
                    }
                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }
        })
    }

}
