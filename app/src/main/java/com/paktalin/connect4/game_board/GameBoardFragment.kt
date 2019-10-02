package com.paktalin.connect4.game_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paktalin.connect4.R
import com.paktalin.connect4.game_board.GameBoardFragment.Constants.NUM_COLUMNS
import com.paktalin.connect4.game_board.GameBoardFragment.Constants.NUM_ROWS
import kotlinx.android.synthetic.main.fragment_grid.view.*

class GameBoardFragment : Fragment() {

    private lateinit var gameBoardAdapter: GameBoardAdapter

    private object Constants {
        const val NUM_ROWS = 6
        const val NUM_COLUMNS = 7
    }

    private val items = MutableList(NUM_ROWS*NUM_COLUMNS) { State.EMPTY }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gameBoardAdapter = GameBoardAdapter(items, context!!)
        return inflater.inflate(R.layout.fragment_grid, container, false)
            .apply { grid_view.adapter = gameBoardAdapter }
    }

    fun placeItem(selectedColumn: Int) {
        for (row in (NUM_ROWS-1) downTo 0) {
            val index = row * NUM_COLUMNS + selectedColumn
            if (items[index] == State.EMPTY) {
                items[index] = State.PLAYER_1
                gameBoardAdapter.notifyDataSetChanged()
                return
            }
        }
    }
}