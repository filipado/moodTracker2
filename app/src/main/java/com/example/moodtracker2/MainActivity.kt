package com.example.moodtracker2

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.comment_edit_text.*
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Adding RecyclerView

        recyclerview_id.run {
            layoutManager = LinearLayoutManager(
                application,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            adapter = MyAdapter()

            // This makes mood_layout snap to grid when scrolling
            PagerSnapHelper().attachToRecyclerView(this)

            //TRYING TO EXPORT THE VISIBLE POSITION FROM HERE

            val position = (recyclerview_id?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            //creating instance of Shared Preferences
            val positionSP = getSharedPreferences("mood", Context.MODE_PRIVATE)
            val editor = positionSP.edit()
            val date = LocalDate.now().toString()

            editor.putInt(date, position)
            editor.apply()
        }

       // var visibleChild = recyclerview_id.getChildAt(recyclerview_id.childCount.minus(1))
       // val lastChild: Int = recyclerview_id.getChildAdapterPosition(visibleChild)
       // val positionSP = getSharedPreferences("mood", Context.MODE_PRIVATE)
       // val editor = positionSP.edit()
       // val date = LocalDate.now().toString()

       // editor.putInt(date, lastChild)
       // editor.apply()



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
                val pref = getSharedPreferences("comment", Context.MODE_PRIVATE)
                val editor = pref.edit()
                val date = LocalDate.now().toString()
                val comment = builder.comment_editText.text.toString()

                editor.putString(date, comment)
                editor.apply()

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
        }
    } // onCreate FINISHES

    //HISTORY button taking user to HistoryActivity on click

    fun history(view: View) {
        // New Activity to open HistoryActivity
        var historyActivity: Intent = Intent(applicationContext, HistoryActivity::class.java)
        startActivity(historyActivity)
    }
} // MAIN ACTIVITY FINISHES
