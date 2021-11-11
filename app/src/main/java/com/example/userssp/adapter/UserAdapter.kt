package com.example.userssp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.R
import com.example.userssp.User
import com.example.userssp.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val user = users.get(position)
        with(holder){
            binding.tvOrder.text = user.id.toString()
            binding.tvName.text = user.name
        }
    }

    override fun getItemCount(): Int = users.size
}