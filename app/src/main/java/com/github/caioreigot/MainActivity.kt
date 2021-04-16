package com.github.caioreigot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.caioreigot.model.Email
import com.github.caioreigot.model.email
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mooveit.library.Fakeit
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewMain: RecyclerView
    lateinit var adapter: EmailAdapter

    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fakeit.init()
        setContentView(R.layout.activity_main)

        recyclerViewMain = findViewById(R.id.recycler_view_main)
        fab = findViewById(R.id.fab)

        // Criando os primeiros emails fakes
        val fakeEmails: MutableList<Email> = mutableListOf<Email>().apply {
            repeat(15) {
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).parse(
                        Fakeit.dateTime().dateFormatter()
                )

                add(email {
                    stared = (0 until 10).random() > 7
                    unread = true
                    user = Fakeit.name().firstName()
                    subject = Fakeit.company().name()
                    date = SimpleDateFormat("d MMM", Locale("pt", "BR")).format(sdf)

                    preview = mutableListOf<String>().apply  {
                        repeat(10) {
                            add(Fakeit.lorem().words())
                        }
                    }.joinToString(" ")
                })
            }
        }

        adapter = EmailAdapter(fakeEmails)

        recyclerViewMain.adapter = adapter
        recyclerViewMain.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener() {
            addEmail()
            recyclerViewMain.scrollToPosition(0)
        }

        val helper = ItemTouchHelper(
                ItemTouchHelper(androidx.recyclerview.widget.ItemTouchHelper.UP
                or androidx.recyclerview.widget.ItemTouchHelper.DOWN,
                androidx.recyclerview.widget.ItemTouchHelper.LEFT)
        )

        helper.attachToRecyclerView(recyclerViewMain)
    }

    inner class ItemTouchHelper(dragDirs: Int, swipeDirs: Int) : androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback(
            dragDirs, swipeDirs
    ) {
        // Mover itens
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            val from: Int = viewHolder.adapterPosition
            val to: Int = target.adapterPosition

            // Trocando a pos na lista
            Collections.swap(adapter.emails, from, to)

            // Trocando a pos na RecyclerView
            adapter.notifyItemMoved(from, to)

            return true
        }

        // Excluir dados no swipe
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
    }

    fun addEmail() {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).parse(
            Fakeit.dateTime().dateFormatter()
        )

        adapter.emails.add(0,
            email {
                stared = (0 until 10).random() > 5
                unread = true
                user = Fakeit.name().firstName()
                subject = Fakeit.company().name()
                date = SimpleDateFormat("d MMM", Locale("pt", "BR")).format(sdf)

                preview = mutableListOf<String>().apply  {
                    repeat(10) {
                        add(Fakeit.lorem().words())
                    }
                }.joinToString(" ")
            })

        adapter.notifyItemInserted(0)
    }

}