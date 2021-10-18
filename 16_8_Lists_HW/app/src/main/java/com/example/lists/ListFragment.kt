package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {
    private var cranes = listOf(
        Cranes.Auto(
            "https://belasz.by/wp-content/uploads/2020/08/e628d685c76aecb80fadcd25935dd82f.jpg",
            "ZOOMLION QY160",
            63F,
            160,
            "8x8"
        ),
        Cranes.Tower(
            "https://belasz.by/wp-content/uploads/2020/08/209bfcce8b1c26ad3dcd3fed299809f6.jpg",
            "POTAIN MC 235B",
            65F,
            10,
            95.7F
        ),
        Cranes.Auto(
            "https://belasz.by/wp-content/uploads/2020/08/97ee07fdab9230e9b2a0e0ac4077cf83-1.jpg",
            "GROVE GMK6300L-1",
            117F,
            300,
            "10x10"
        ),
        Cranes.Tower(
            "https://belasz.by/wp-content/uploads/2020/08/1fd8092563151ef9ed4c36d529929e05.jpg",
            "ZOOMLION 6516A-8",
            60F,
            8,
            85.2F
        )
    )
    private var cranesAdapter: CranesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        addFab.setOnClickListener { addItem() }
        cranesAdapter?.updateCrane(cranes)
    }

    private fun showDialog() {
//        AlertDialog.Builder(requireContext())
//            .setTitle("Добавление")
//            .setPositiveButton("Добавить") { _, _ ->
//                spinner.onItemSelectedListener object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>?,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    when (position){
//                        0->{
//
//                        }
//                        1->{
//
//                        }
//                    }
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//
//                }
//
//            }
//            }
//            .setNegativeButton("Отменить") { _, _ -> }
//            .setNeutralButton("Детали") { _, _ -> }
//            .create()
//            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cranesAdapter = null
    }

    private fun initList() {
        cranesAdapter = CranesAdapter { position -> deleteItem(position) }
        with(craneList) {
            adapter = cranesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun deleteItem(position: Int) {
        cranes = cranes.filterIndexed { index, _ -> index != position }
        cranesAdapter?.updateCrane(cranes)
        cranesAdapter?.notifyItemRemoved(position)
    }


    private fun addItem() {
        val newCrane = cranes.random()
        cranes = listOf(newCrane) + cranes
        cranesAdapter?.updateCrane(cranes) // передаем новый список пользователей
        cranesAdapter?.notifyItemInserted(0) // добавление на первую строку

        craneList.scrollToPosition(0) // 3.5 скролинг к добавленой позиции
    }
}