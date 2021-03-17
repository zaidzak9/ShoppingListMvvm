package com.zaidzakir.shoppinglistmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem

/**
 *Created by Zaid Zakir
 */
@Dao
interface ShoppingDao {
    //suspend function to make it eligible with coroutines
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query(value = "SELECT * FROM shopping_items")
    //live data to make recycler view efficient
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
}