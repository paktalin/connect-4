package com.paktalin.connect4.add_item

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.paktalin.connect4.R
import kotlinx.android.synthetic.main.item_add.view.*

internal class AddItemAdapter(
    private val context: Context,
    var selected: Int?
) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_add, parent, false)
            .apply { setOnClickListener { onClick(position) } }
            .apply { circle_add_item.visibility = if (position == selected) VISIBLE else INVISIBLE }
            .apply { circle_add_item.imageTintList = ContextCompat.getColorStateList(context, R.color.color_player1) }
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return 7
    }

    private fun onClick(position: Int) {
        selected = position
        notifyDataSetChanged()
    }
}