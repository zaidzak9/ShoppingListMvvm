package com.zaidzakir.shoppinglistmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem

/**
 *Created by Zaid Zakir
 */

@Database(
    entities = [ShoppingItem::class],
    //every time you change your database make sure you update this +1
    version = 1
)
abstract class ShoppingDatabase:RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao
    //creating a single instance, companion is equivalent to static in java
    companion object{
        //annotate with volatile so only one thread at a time can write to this instance
        @Volatile
         private var instance: ShoppingDatabase?=null
        private val LOCK = Any()

        //executed when ever shoppingDatabase instance is created, synchronized(LOCK) so only 1 thread can call at 1 time
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun createDatabase(context:Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java,"ShoppingDB.db").build()
    }
}