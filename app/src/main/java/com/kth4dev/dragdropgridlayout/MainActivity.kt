package com.kth4dev.dragdropgridlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbersListAdapter=NumbersListAdapter()
        val rvNumber=findViewById<RecyclerView>(R.id.rv_numbers)
        rvNumber.adapter=numbersListAdapter
        rvNumber.layoutManager=GridLayoutManager(this,3)


        val callback: ItemTouchHelper.Callback = ItemMoveCallBack(numbersListAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(rvNumber)

    }
}