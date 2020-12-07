package com.example.moodtracker2

import org.junit.Assert.*
import org.junit.Test

class MoodTest {

    private val moods = MoodBank().getMoods()

    @Test
    fun `validate colour`() {
        var mood = moods[1]
        assertEquals(mood?.colour, R.color.light_sage)

        mood = moods[2]
        assertEquals(mood?.colour, R.color.cornflower_blue_65)
    }

    @Test
    fun `validate width`() {
        var mood = moods[3]
        assertEquals(mood?.width, 0.45F)

        mood = moods[4]
        assertEquals(mood?.width, 0.3F)
    }

    @Test
    fun `validate string`() {
        var mood = moods[4]
        assertEquals(mood?.message, "sad")

        mood = moods[9]
        assertEquals(mood?.message, "No mood yet")
    }
}