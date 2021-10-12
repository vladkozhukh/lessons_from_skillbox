package com.example.lists

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(
    private val users: List<User>,
) : RecyclerView.Adapter<UserAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //        val inflater = LayoutInflater.from(parent.context)
        //        val view = inflater.inflate(R.layout.item_user,parent, false)
        //        return Holder(view)
        // упрощается через ViewExtensions.kt
        return Holder(parent.inflate(R.layout.item_user))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = users.size

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = view.findViewById(R.id.ageTextView)
        private val developerTextView: TextView = view.findViewById(R.id.developerTextView)
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

        fun bind(user: User){
            nameTextView.text=user.name
            ageTextView.text="Возраст = ${user.age}"
            developerTextView.visibility = if(user.isDeveloper) View.VISIBLE else View.GONE

            Glide.with(itemView)
                .load(user.avatarLink)
                .placeholder(R.drawable.ic_portrait)
                .into(avatarImageView)


        }
    }
}