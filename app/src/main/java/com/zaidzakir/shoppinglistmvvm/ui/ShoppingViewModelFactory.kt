package com.zaidzakir.shoppinglistmvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zaidzakir.shoppinglistmvvm.data.repositories.ShoppingRepository

/**
 *Created by Zaid Zakir
 */
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory (private val repository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}