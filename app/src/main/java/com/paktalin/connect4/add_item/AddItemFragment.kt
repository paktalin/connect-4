package com.paktalin.connect4.add_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paktalin.connect4.R
import kotlinx.android.synthetic.main.fragment_grid.view.*

class AddItemFragment : Fragment() {

    private lateinit var addItemAdapter: AddItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addItemAdapter = AddItemAdapter(context!!, 3)
        return inflater.inflate(R.layout.fragment_grid, container, false)
            .apply { grid_view.adapter = addItemAdapter }
    }

    fun resetItems() {
        addItemAdapter.selected = null
        addItemAdapter.notifyDataSetChanged()
    }

    fun selected(): Int? = addItemAdapter.selected
}