/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.vvoitsekh.databindinglivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

import com.example.vvoitsekh.databindinglivedata.db.Book
import dagger.android.AndroidInjection
import javax.inject.Inject

class BooksBorrowedByUserActivity : AppCompatActivity() {

    @Inject
    lateinit var mViewModel: BooksBorrowedByUserViewModel

    private var mBooksTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.db_activity)
        mBooksTextView = findViewById(R.id.books_tv)

        // Get a reference to the ViewModel for this screen.
        //mViewModel = ViewModelProviders.of(this).get(BooksBorrowedByUserViewModel::class.java)
        // Update the UI whenever there's a change in the ViewModel's data.
        subscribeUiBooks()
    }

    fun onRefreshBtClicked(view: View) {
        //mViewModel.createDb();
        mViewModel.addBook()
        var intent = Intent(this, BooksBorrowedByUserActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    private fun subscribeUiBooks() {
        mViewModel.books.observe(this, object : Observer<List<Book>> {
            override fun onChanged(t: List<Book>?) {
                mBooksTextView?.text = t?.toString()
            }
        })
    }

    private fun showBooksInUi(books: List<Book>) {
        val sb = StringBuilder()

        for (book in books) {
            sb.append(book.title)
            sb.append("\n")

        }
        mBooksTextView!!.text = sb.toString()
    }
}
