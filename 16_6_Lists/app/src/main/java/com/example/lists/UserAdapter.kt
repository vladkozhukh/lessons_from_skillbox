package com.example.lists

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.FieldPosition

class UserAdapter(
    // 2.1. функция которая принимает position -> на выход ничего не производить и копируем в class Holder (..., сюда)
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<UserAdapter.Holder>() {

    // 1.4. придаем ему пустой список "... = emptyList()"
    private var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //        val inflater = LayoutInflater.from(parent.context)
        //        val view = inflater.inflate(R.layout.item_user,parent, false)
        //        return Holder(view)
        // упрощается через ViewExtensions.kt
        return Holder(
            parent.inflate(R.layout.item_user),
            onItemClicked
        ) // 2.4. "onItemClicked" передаем при создании
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    // 1.5. метод для обновления списка, который принимает новый список пользователей
    fun updateUsers(newUsers: List<User>) {
        users = newUsers
        // 1.6. оповещение адаптера об изменении списка
        // notifyDataSetChanged() -> 3.1 убираем для плавного добавления и удаления

    }

    override fun getItemCount(): Int = users.size

    class Holder(
        view: View,
        // 2.2 копируем функцию
        onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = view.findViewById(R.id.ageTextView)
        private val developerTextView: TextView = view.findViewById(R.id.developerTextView)
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

        init {
            view.setOnClickListener {
                // 2.3 действие при нажатии
                onItemClicked(adapterPosition)
            }
        }

        fun bind(user: User) {
            nameTextView.text = user.name
            ageTextView.text = "Возраст = ${user.age}"
            developerTextView.visibility = if (user.isDeveloper) View.VISIBLE else View.GONE

            Glide.with(itemView)
                .load(user.avatarLink)
                .placeholder(R.drawable.ic_portrait)
                .into(avatarImageView)


        }
    }
}