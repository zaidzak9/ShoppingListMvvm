package com.zaidzakir.shoppinglistmvvm.data.repositories

import com.zaidzakir.shoppinglistmvvm.data.db.ShoppingDatabase
import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem

/**
 *Created by Zaid Zakir
 */
//to be accessed by viewmodel
class ShoppingRepository (private val db : ShoppingDatabase){
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItems()
}