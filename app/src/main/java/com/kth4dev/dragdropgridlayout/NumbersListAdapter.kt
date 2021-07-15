package com.kth4dev.dragdropgridlayout

import android.R.attr.data
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class NumbersListAdapter: RecyclerView.Adapter<NumbersListAdapter.NumberViewHolder>(),ItemMoveCallBack.ItemTouchHelperContract {
    private val numberList= arrayListOf<String>("1","2","3","4","5","6","7","8","9")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_number,parent,false))
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.tv_number.text = numberList[position]
    }

    override fun getItemCount(): Int {
       return numberList.size
    }


    class NumberViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
       val tv_number=itemView.findViewById<TextView>(R.id.tv_number)
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(numberList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(numberList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(myViewHolder: NumberViewHolder?) {
        myViewHolder?.tv_number?.setBackgroundColor(Color.GRAY);
    }

    override fun onRowClear(myViewHolder: NumberViewHolder?) {
        myViewHolder?.tv_number?.setBackgroundColor(Color.WHITE);
    }

}