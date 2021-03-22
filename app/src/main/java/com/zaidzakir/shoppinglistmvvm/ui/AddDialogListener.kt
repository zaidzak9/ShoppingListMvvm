package com.zaidzakir.shoppinglistmvvm.ui

import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem

/**
 *Created by Zaid Zakir
 */
interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}