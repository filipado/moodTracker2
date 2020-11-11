package com.example.moodtracker2

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comment_edit_text.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Adding RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_id)

        recyclerView.run {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false)
            adapter = MyAdapter()


            // This makes mood_layout snap to grid (full screen)
            PagerSnapHelper().attachToRecyclerView(this)
        }
        //Accessing Recycler View position and displaying it in the TextView
        recyclerView.setOnClickListener(){
            val position = MyViewHolder().adapterPosition.toString()
            val displayPosition: TextView = findViewById(R.id.textView_position)
            displayPosition.setText(position)

        }

        //Adding AlertDialog to add comments
        btn_addNote.setOnClickListener {
            //Setting Inflater to inflate Dialog with comment_edit_text.xml layout
            val dialogLayout = LayoutInflater.from(this).inflate(R.layout.comment_edit_text, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogLayout)
                .show()

            //Adding Shared Preferences to save a comment on confirmCommentButton button

            builder.confirmCommentButton.setOnClickListener {

                //creating instance of Shared Preferences
                val pref = getSharedPreferences("commentSharedPreferences", Context.MODE_PRIVATE)
                val editor = pref.edit()

                //ACCESSING COMMENT WRITTEN BY USER in AlertDialog.Builder - val builder
                val insertedName = builder.editTextComment.text.toString()

                //Saving shared Preferences
                editor.apply {
                    putString("STRING_KEY", insertedName)
                    apply()
                }

                // Toast to confirm saved data
                Toast.makeText(this, "Comment Saved", Toast.LENGTH_SHORT).show()
                //close Dialog on CONFIRM button click
                builder.dismiss()
           }
           //CANCEL button that closes Dialog on click
           builder.cancelCommentButton.setOnClickListener{
               builder.dismiss()
           }
           builder.setOnDismissListener {

            }


            //Aktualny dzien
            //val dzisiaj = LocalDate.now().toString()
            //val textViewMainActivity = findViewById<TextView>(R.id.textView_position)
            //textViewMainActivity.setText(dzisiaj)
        }
    } // onCreate FINISHES

    //HISTORY button taking user to HistoryActivity on click

    fun history(view: View) {
        // New Activity to open HistoryActivity
        var historyActivity: Intent = Intent(applicationContext, HistoryActivity::class.java)
        startActivity(historyActivity)
    }
} // MAIN ACTIVITY FINISHES
