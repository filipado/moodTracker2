package com.example.moodtracker2

class MoodBank {

    fun getMoods(): Map<Int, Mood> {
        return mapOf(
            0 to Mood(
                R.color.banana_yellow,
                1.0F,
                "super happy"
            ),
            1 to Mood(
                R.color.light_sage,
                0.8F,
                "happy"
            ),
            2 to Mood(
                R.color.cornflower_blue_65,
                0.6F,
                "normal"
            ),
            3 to Mood(
                R.color.warm_grey,
                0.45F,
                "disappointed"
            ),
            4 to Mood(
                R.color.faded_red,
                0.3F,
                "sad"
            ),
            //set default mood
            9 to Mood(
                R.color.white,
                1.2F,
                "No mood yet"
            )
        )
    }
}