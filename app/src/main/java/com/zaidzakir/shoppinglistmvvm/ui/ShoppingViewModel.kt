package com.zaidzakir.shoppinglistmvvm.ui

import androidx.lifecycle.ViewModel
import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.zaidzakir.shoppinglistmvvm.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by Zaid Zakir
 */
class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {
    //self note
    //using Main instead of IO because room db provides main safety, default is used for long running processes
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItem()

}