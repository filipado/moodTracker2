package com.example.moodtracker2

import android.content.Context.MODE_PRIVATE
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mood_layout.view.*
import java.security.AccessController.getContext
import java.time.LocalDate
import java.time.LocalDateTime

//initiating ViewHolder
class MyViewHolder(val view : View):RecyclerView.ViewHolder(view){}

//initiating Adapter
class MyAdapter : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val moodInflater = layoutInflater.inflate(R.layout.mood_layout, parent, false)
        return MyViewHolder(moodInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val context = holder.view.context

        //Adding values and "when" method to initiate recycler view data

        val emoji = holder.view.emoji_img
        val background = holder.view.moodLayout_id

        when(position){
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

