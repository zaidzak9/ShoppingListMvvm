package com.zaidzakir.shoppinglistmvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *Created by Zaid Zakir
 */
@Entity(tableName = "shopping_items")
//data keyword tells kotlin the main purpose is to hold data
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
) {
    //no need to set id manually room db wil do it automatically
   @PrimaryKey(autoGenerate = true)
   var id:Int?=null
}