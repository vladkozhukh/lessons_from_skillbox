package com.example.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lists.adapters.CranesAdapter
import com.example.lists.databinding.FragmentListBinding
import jp.wasabeef.recyclerview.animators.FadeInAnimator
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {
    private var cranes: ArrayList<Cranes> = arrayListOf(
        Cranes.Auto(
            1,
            "https://belasz.by/wp-content/uploads/2020/08/e628d685c76aecb80fadcd25935dd82f.jpg",
            "ZOOMLION QY160",
            "63.0",
            "160"
        ),
        Cranes.Tower(
            2,
            "https://belasz.by/wp-content/uploads/2020/08/209bfcce8b1c26ad3dcd3fed299809f6.jpg",
            "POTAIN MC 235B",
            "65.0",
            "10.0"
        ),
        Cranes.Auto(
            3,
            "https://belasz.by/wp-content/uploads/2020/08/97ee07fdab9230e9b2a0e0ac4077cf83-1.jpg",
            "GROVE GMK6300L-1",
            "117.0",
            "300"
        ),
        Cranes.Tower(
            4,
            "https://belasz.by/wp-content/uploads/2020/08/1fd8092563151ef9ed4c36d529929e05.jpg",
            "ZOOMLION 6516A-8",
            "60.0",
            "8"
        )
    )

    var checkedTower: Boolean = false
    private var cranesAdapter: CranesAdapter? = null
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        if (savedInstanceState != null){
            cranes = savedInstanceState.getParcelableArrayList(KEY_CRANE)!!
            binding.emptyListTextView.isVisible = savedInstanceState.getBoolean(KEY_VIEW)
        }
        initList()
        binding.addFab.setOnClickListener {
            AddDialogFragment().show(childFragmentManager, "AddDialogFragmentTag")
        }
        cranesAdapter?.items = cranes
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cranesAdapter = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(KEY_CRANE, cranes)
        outState.putBoolean(KEY_VIEW, binding.emptyListTextView.isVisible)
        }

    private fun initList() {
        cranesAdapter = CranesAdapter { position -> deleteItem(position) }
        with(binding.craneList) {
            adapter = cranesAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)

            // п.6 Добавление анимации добавления/удаления элементов
            itemAnimator = FadeInAnimator()
        }
    }

    private fun deleteItem(position: Int) {
        cranes = cranes.filterIndexed { index, _ -> index != position } as ArrayList<Cranes>
        cranesAdapter?.items = cranes
        cranesAdapter?.notifyItemRemoved(position)
        if (cranes == emptyList<String>()) {
            emptyListTextView.visibility = View.VISIBLE
        }
    }

    fun addItem(
        id: Long,
        avatarLink: String,
        name: String,
        jib: String,
        lifting: String
    ) {
        val newCrane: ArrayList<Cranes> = arrayListOf()
        if (checkedTower)
            newCrane.add(Cranes.Tower(id, avatarLink, name, jib, lifting))
        else
            newCrane.add(Cranes.Auto(id, avatarLink, name, jib, lifting))
        cranes = (newCrane + cranes) as ArrayList<Cranes>
        cranesAdapter?.items = cranes
        binding.craneList.scrollToPosition(0)
        if (cranes != emptyList<String>()) {
            emptyListTextView.visibility = View.GONE
        }
    }

    companion object {
        private const val KEY_CRANE = "CRANE"
        private const val KEY_VIEW = "VIEW"
    }
}
