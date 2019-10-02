package com.paktalin.connect4.game_board

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.paktalin.connect4.R
import kotlinx.android.synthetic.main.item_game_board.view.*

internal class GameBoardAdapter(private var items: List<State>, private var context: Context) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_game_board, parent, false)

        view.circle_game_board.imageTintList = ContextCompat.getColorStateList(context,
            R.color.colorPrimary
        )

        view.circle_game_board.apply {

            if (items[position] == State.EMPTY)
                visibility = View.GONE
            else {
                visibility = View.VISIBLE
                if(items[position] == State.PLAYER_1)
                    imageTintList = ContextCompat.getColorStateList(context,
                        R.color.color_player1
                    )
                else
                    ContextCompat.getColorStateList(context,
                        R.color.color_player2
                    )
            }
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}