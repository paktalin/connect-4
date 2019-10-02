package com.paktalin.connect4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.paktalin.connect4.add_item.AddItemFragment
import com.paktalin.connect4.game_board.GameBoardFragment
import kotlinx.android.synthetic.main.activity_game.*

private const val KEY_ADD_ITEM_FRAGMENT = "add_item_fragment"
private const val KEY_GAME_BOARD_FRAGMENT = "game_board_fragment"

class GameActivity: AppCompatActivity() {

    private lateinit var gameBoardFragment: GameBoardFragment
    private lateinit var addItemFragment: AddItemFragment

    private var player: Player = Player.PLAYER_1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        if (savedInstanceState == null) {
            gameBoardFragment = GameBoardFragment()
            addItemFragment = AddItemFragment()
        } else
            restoreState(savedInstanceState)

        btn_ok.setOnClickListener { submitTurn() }
        addFragments()

        tv_turn.text = resources.getString(R.string.your_turn, player.mName)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        supportFragmentManager.putFragment(outState, KEY_ADD_ITEM_FRAGMENT, addItemFragment)
        supportFragmentManager.putFragment(outState, KEY_GAME_BOARD_FRAGMENT, gameBoardFragment)
    }

    private fun restoreState(savedInstanceState: Bundle) {
        addItemFragment = supportFragmentManager.getFragment(savedInstanceState, KEY_ADD_ITEM_FRAGMENT) as AddItemFragment
        gameBoardFragment = supportFragmentManager.getFragment(savedInstanceState, KEY_GAME_BOARD_FRAGMENT) as GameBoardFragment

    }

    private fun addFragments() {
        supportFragmentManager.commit(true) {
            replace(R.id.container_game_board, gameBoardFragment)
            replace(R.id.container_add_item, addItemFragment)
        }
    }

    private fun submitTurn() {
        addItemFragment.selected()?.let { it1 -> gameBoardFragment.placeItem(it1) }
        addItemFragment.resetItems()
        player = if (player == Player.PLAYER_1) Player.PLAYER_2 else Player.PLAYER_1
        tv_turn.text = resources.getString(R.string.your_turn, player.mName)
    }
}