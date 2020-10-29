package com.example.moodtracker2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.nonindividual_mood_layout.view.*

class MyViewHolder(val view : View):RecyclerView.ViewHolder(view)

class MyAdapter : RecyclerView.Adapter<MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val nonindividual_mood = layoutInflater.inflate(R.layout.nonindividual_mood_layout, parent, false)
        return MyViewHolder(nonindividual_mood)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val  context = holder.view.context
        var i = position

        var emoji = holder.view.emoji_img
        var background = holder.view.my_layout_id

        when(i){
            0 -> {emoji.setImageResource(R.drawable.smiley_super_happy)
                background.setBackgroundColor(context.resources.getColor(R.color.banana_yellow))}

            1 -> {emoji.setImageResource(R.drawable.smiley_happy)
                background.setBackgroundColor(context.resources.getColor(R.color.light_sage))}

            2 -> {emoji.setImageResource(R.drawable.smiley_normal)
                background.setBackgroundColor(context.resources.getColor(R.color.cornflower_blue_65))}

            3 -> {emoji.setImageResource(R.drawable.smiley_disappointed)
                background.setBackgroundColor(context.resources.getColor(R.color.warm_grey))}

            4 -> {emoji.setImageResource(R.drawable.smiley_sad)
                background.setBackgroundColor(context.resources.getColor(R.color.faded_red))}
        }


    }

    override fun getItemCount(): Int {
        return 5
    }


}

