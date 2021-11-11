package com.example.userssp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.adapter.UserAdapter
import com.example.userssp.databinding.ActivityMainBinding
import com.example.userssp.interfaces.OnClickListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handlePreferences()
        initRecyclerView()
    }

    private fun handlePreferences() {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        if (isFirstTime) {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                    preferences
                        .edit()
                        .putBoolean(getString(R.string.sp_first_time), false)
                        .commit()
                }
                .setNegativeButton("Cerrar", null)
                .show()

        }

    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User> {
        val user = mutableListOf<User>()
        val giuseppe = User(
            1,
            "Giuseppe",
            "Varas",
            "https://www.bovinoapp.com/wp-content/uploads/2019/02/WhatsApp-Image-2019-02-26-at-11.14.30.jpeg"
        )
        val pepe = User(
            2,
            "Pepe",
            "Varas",
            "https://www.bovinoapp.com/wp-content/uploads/2019/02/WhatsApp-Image-2019-02-26-at-11.14.30.jpeg"
        )
        val jose = User(
            3,
            "Jose",
            "Varas",
            "https://www.bovinoapp.com/wp-content/uploads/2019/02/WhatsApp-Image-2019-02-26-at-11.14.30.jpeg"
        )
        user.add(giuseppe)
        user.add(pepe)
        user.add(jose)
        user.add(giuseppe)
        user.add(pepe)
        user.add(jose)
        user.add(giuseppe)
        user.add(pepe)
        user.add(jose)
        user.add(giuseppe)
        user.add(pepe)
        user.add(jose)
        user.add(giuseppe)
        user.add(pepe)
        user.add(jose)
        return user
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${user.getFullName()}", Toast.LENGTH_SHORT).show()
    }
}