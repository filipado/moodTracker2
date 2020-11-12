package com.example.moodtracker2

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mood_layout.view.*
import java.time.LocalDate
import java.time.LocalDateTime

class MyViewHolder(val view : View):RecyclerView.ViewHolder(view){}

class MyAdapter : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val moodInflater = layoutInflater.inflate(R.layout.mood_layout, parent, false)
        return MyViewHolder(moodInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val sharedPref = holder.view.context.getSharedPreferences("mood", MODE_PRIVATE)
        val editor = sharedPref.edit()

        //Get the current date
        val date = LocalDateTime.now().toString()

        editor.putInt(date, position)
        editor.apply()

        val context = holder.view.context

        val emoji = holder.view.emoji_img
        val background = holder.view.moodLayout_id
        val moodSelected = position

        when(moodSelected){
            0 -> {emoji.setImageResource(R.drawable.smiley_super_happy)
                background.setBackgroundColor(context.resources.getColor(R.color.banana_yellow))

            }

            1 -> {emoji.setImageResource(R.drawable.smiley_happy)
                background.setBackgroundColor(context.resources.getColor(R.color.light_sage))
            }

            2 -> {emoji.setImageResource(R.drawable.smiley_normal)
                background.setBackgroundColor(context.resources.getColor(R.color.cornflower_blue_65))
            }

            3 -> {emoji.setImageResource(R.drawable.smiley_disappointed)
                background.setBackgroundColor(context.resources.getColor(R.color.warm_grey))
            }

            4 -> {emoji.setImageResource(R.drawable.smiley_sad)
                background.setBackgroundColor(context.resources.getColor(R.color.faded_red))
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }




}

