package com.example.lists

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CranesAdapter(
    private var onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cranes: List<Cranes> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TOWER -> TowerHolder(parent.inflate(R.layout.item_towercrane), onItemClicked)
            TYPE_AUTO -> AutoHolder(
                parent.inflate(R.layout.item_autocrane),
                onItemClicked
            )
            else -> error("Incorrect viewType = $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cranes[position]) {
            is Cranes.Tower -> TYPE_TOWER
            is Cranes.Auto -> TYPE_AUTO
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TowerHolder -> {
                val crane = cranes[position].let { it as? Cranes.Tower }
                    ?: error("Crane it position = $position is not Tower")
                holder.bind(crane)
            }
            is AutoHolder -> {
                val crane = cranes[position].let { it as? Cranes.Auto }
                    ?: error("Crane it position = $position is not Auto")
                holder.bind(crane)
            }
            else -> error("Incorrect view holder = $holder")
        }
    }

    override fun getItemCount(): Int = cranes.size

    fun updateCrane(newCrane: List<Cranes>) {
        cranes = newCrane
    }

    abstract class BaseCranesHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val jibTextView: TextView = view.findViewById(R.id.jibTextView)
        private val liftingTextView: TextView = view.findViewById(R.id.liftingTextView)

        init {
            view.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        protected fun bindMainInfo(
            name: String,
            avatarLink: String,
            jib: Float,
            lifting: Int,
        ) {
            nameTextView.text = name
            jibTextView.text = "Стрела, max: $jib м."
            liftingTextView.text = "Грузоподъемность: $lifting т."

            Glide.with(itemView)
                .load(avatarLink)
                .placeholder(R.drawable.ic_image)
                .into(avatarImageView)

        }
    }

    class TowerHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BaseCranesHolder(view, onItemClicked) {
        private val heightTextView: TextView =
            view.findViewById(R.id.heightTextView)

        fun bind(cranes: Cranes.Tower) {
            bindMainInfo(cranes.name, cranes.avatarLink, cranes.jib, cranes.lifting)
            heightTextView.text = "Высота под крюк, max: ${cranes.height} м."
        }
    }


    class AutoHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BaseCranesHolder(view, onItemClicked) {
        private val outriggersTextView: TextView =
            view.findViewById(R.id.outriggersTextView)

        fun bind(cranes: Cranes.Auto) {
            bindMainInfo(cranes.name, cranes.avatarLink, cranes.jib, cranes.lifting)
            outriggersTextView.text = "Опорный контур, м: ${cranes.outriggers}"
        }
    }

    companion object {
        private const val TYPE_TOWER = 1
        private const val TYPE_AUTO = 2
    }

}