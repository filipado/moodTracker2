package com.example.moodtracker2

import android.content.Context

class MoodBank(private val context: Context) {

    fun getMoods(): Map<Int, Mood> {
        return mapOf(
            0 to Mood(
                R.color.banana_yellow,
                1.0F
            ),
            1 to Mood(
                R.color.light_sage,
                0.8F
            ),
            2 to Mood(
                R.color.cornflower_blue_65,
                0.6F
            ),
            3 to Mood(
                R.color.warm_grey,
                0.4F
            ),
            4 to Mood(
                R.color.faded_red,
                0.2F
            ),
            //set default mood
            9 to Mood(
                R.color.white,
                1.2F
            )


        )
    }
}

// val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)