package com.example.lists

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PersonAdapter(
    private val onItemClicked: (position: Int) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var persons: List<Person> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_USER -> UserHolder(parent.inflate(R.layout.item_user), onItemClicked)
            TYPE_DEVELOPER -> DeveloperHolder(parent.inflate(R.layout.item_developer),
                onItemClicked)
            else -> error("Incorrect viewType = $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        // 1.2. передаем
        return when (persons[position]) {
            is Person.Developer -> TYPE_DEVELOPER
            is Person.User -> TYPE_USER
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is UserHolder -> {
                val person = persons[position].let { it as? Person.User }
                    ?: error("Person it position = $position is not user")
                holder.bind(person)
            }
            is DeveloperHolder -> {
                val person = persons[position].let { it as? Person.Developer }
                    ?: error("Person it position = $position is not developer")
                holder.bind(person)
            }
            else -> error("Incorrect view holder = $holder")
        }
    }

    override fun getItemCount(): Int = persons.size

    fun updatePersons(newPersons: List<Person>) {
        persons = newPersons
    }

    abstract class BasePersonHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = view.findViewById(R.id.ageTextView)
        private val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

        init {
            view.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        protected fun bindMainInfo(
            name: String,
            avatarLink: String,
            age: Int,
        ) {
            nameTextView.text = name
            ageTextView.text = "Возраст = $age"

            Glide.with(itemView)
                .load(avatarLink)
                .placeholder(R.drawable.ic_portrait)
                .into(avatarImageView)

        }
    }

    class UserHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BasePersonHolder(view, onItemClicked) {
        init {
            view.findViewById<TextView>(R.id.developerTextView).isVisible = false
        }

        fun bind(person: Person.User) {
            bindMainInfo(person.name, person.avatarLink, person.age)
        }
    }

    class DeveloperHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit,
    ) : BasePersonHolder(view, onItemClicked) {
        private val programmingLanguageView: TextView =
            view.findViewById(R.id.programmingLanguageTextView)

        fun bind(person: Person.Developer) {
            bindMainInfo(person.name, person.avatarLink, person.age)
            programmingLanguageView.text = "Язык ${person.programmingLanguage}"
            //itemView.context.resources.getString(R.string.app_name)
        }
    }

    // 1.1. создаем
    companion object {
        private const val TYPE_USER = 1
        private const val TYPE_DEVELOPER = 2
    }

}