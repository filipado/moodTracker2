package com.example.moodtracker2

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comment_edit_text.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_id)

        recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = MyAdapter()

            // This makes mood_layout snap to grid (full screen)
            PagerSnapHelper().attachToRecyclerView(this)
        }

    } // onCreate FINISHES



    // AlertDialog for adding a comment



    fun addNote(view: View) {

        val positiveButtonClick = { dialog: DialogInterface, which: Int ->
            //Shared Preferences
            val pref = getSharedPreferences("commentSharedPreferences", Context.MODE_PRIVATE)
            val editor = pref.edit()
            val typeCommentButton = editTextComment
            var comment = typeCommentButton.text.toString()
            editor.putString("COMMENT_KEY", comment)
            editor.apply()

            //TOAST
            Toast.makeText(this, "Comment saved", Toast.LENGTH_SHORT).show()
        }

        val negativeButtonClick = { dialog: DialogInterface, which: Int ->}

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

        // Intent to HistoryActivity

    fun history(view: View) {

        // New Activity to open HistoryActivity
        var historyActivity: Intent = Intent(applicationContext, HistoryActivity::class.java)
        startActivity(historyActivity)

    }

    private fun saveComment(){

        val sharedPreferencesComment = getSharedPreferences("commentPreferences", MODE_PRIVATE)
        val editor = sharedPreferencesComment.edit()

        val insertedComment = editTextComment.text.toString()

        editor.apply {
            putString("COMMENT_KEY", insertedComment)
            apply()
        }

        Toast.makeText(this, "Comment Saved", Toast.LENGTH_SHORT).show()
    }





} // MAIN ACTIVITY FINISHES
