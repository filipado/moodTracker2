package com.example.moodtracker2

import android.content.Context

class MoodBank(private val context: Context) {

    fun getMoods(): Array<Mood> {
        return arrayOf(
            Mood(
                0,
                R.color.banana_yellow,
                1.0F
            ),
            Mood(
                1,
                R.color.light_sage,
                0.8F
            ),
            Mood(
                2,
                R.color.cornflower_blue_65,
                0.6F
            ),
            Mood(
                3,
                R.color.warm_grey,
                0.4F
            ),
            Mood(
                4,
                R.color.faded_red,
                0.2F
            )

        )
    }
}