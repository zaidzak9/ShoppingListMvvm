package com.zaidzakir.shoppinglistmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.zaidzakir.shoppinglistmvvm.R
import com.zaidzakir.shoppinglistmvvm.data.db.ShoppingDatabase
import com.zaidzakir.shoppinglistmvvm.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)
    }
}
