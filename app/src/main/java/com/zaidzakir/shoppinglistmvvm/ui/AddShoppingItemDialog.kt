package com.zaidzakir.shoppinglistmvvm.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.zaidzakir.shoppinglistmvvm.R
import com.zaidzakir.shoppinglistmvvm.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shoppingitem.*
import java.lang.NumberFormatException

/**
 *Created by Zaid Zakir
 */
class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener ) : AppCompatDialog(context ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shoppingitem)

        tvAdd.setOnClickListener {
            var amount = 0
            val name = etName.text.toString()
            try {
                amount = etAmount.text.toString().toInt()
            }catch (ex:NumberFormatException){
//                Toast.makeText(context,"Please enter a amount",Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
            }


            if (name.isNullOrEmpty()){
                Toast.makeText(context,"Please enter a name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }

}