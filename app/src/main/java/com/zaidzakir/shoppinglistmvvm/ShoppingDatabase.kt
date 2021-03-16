package com.zaidzakir.shoppinglistmvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *Created by Zaid Zakir
 */

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase:RoomDatabase() {
    abstract fun getShoppingDao():ShoppingDao

    //creating a single instance
    companion object{
        //only one thread at a time can write to this instance
        @Volatile
         private var instance:ShoppingDatabase?=null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context:Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java,"ShoppingDB.db").build()
    }
}