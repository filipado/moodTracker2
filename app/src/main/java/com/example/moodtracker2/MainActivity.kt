package com.example.moodtracker2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_id)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = MyAdapter()
    }

        // AlertDialog for adding a comment

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->}
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->}

    fun addNote(view: View) {

        val builder = AlertDialog.Builder(this)
        val inflater =layoutInflater
        val dialogLayout = inflater.inflate(R.layout.comment_edit_text, null)


        with(builder)
        {
            setMessage("Comment")
            setView(dialogLayout)
            setPositiveButton("CONFIRM",DialogInterface.OnClickListener(positiveButtonClick))
            setNegativeButton("CANCEL", DialogInterface.OnClickListener(negativeButtonClick))
            show()
        }
    }

        // Intent - history button and HistoryActivity, dialogFragment or history_layout?

    fun history(view: View) {

        // New Activity to open HistoryActivity
        var historyActivity: Intent = Intent(applicationContext, HistoryActivity::class.java)
        startActivity(historyActivity)

    }



}