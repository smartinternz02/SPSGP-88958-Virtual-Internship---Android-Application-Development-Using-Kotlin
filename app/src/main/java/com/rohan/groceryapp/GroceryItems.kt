package com.rohan.groceryapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_items")
data class GroceryItems (

    @ColumnInfo(name = "ItemName")
    var itemName:String,

    @ColumnInfo(name = "ItemQuantity")
    var ItemQuantity:Int,

    @ColumnInfo(name = "ItemPrice")
    var ItemPrice:Int,


){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null


}