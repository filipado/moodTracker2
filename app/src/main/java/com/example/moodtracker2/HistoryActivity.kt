package com.example.moodtracker2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_history.*
import java.time.LocalDate

class HistoryActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //shared preferences to access mood
        val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)
        val date = LocalDate.now().toString()

        val savedMood = sharedPref.getInt(date, 0)

        yesterday_textView.setText(savedMood.toString())

        //shared preferences to access comment
        val sharedPrefComment = getSharedPreferences("comment", MODE_PRIVATE)
        val savedComment = sharedPrefComment.getString(date, null)


        //alertDialog to show comment:
        comment_imageButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(savedComment.toString())
            builder.show()
        }


    }
}