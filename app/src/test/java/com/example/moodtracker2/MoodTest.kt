package com.example.moodtracker2

import org.junit.Assert
import org.junit.Test

class MoodTest{

    @Test
    fun `validate colour`() {
        val mood = Mood (R.color.light_sage, 0.8F, "happy")
        Assert.assertEquals(mood.colour, R.color.light_sage)
    }

    @Test
    fun `validate width`() {
        val mood = Mood (R.color.banana_yellow, 1.0F, "super happy")
        Assert.assertEquals(mood.width, 1.0F)
    }

    @Test
    fun `validate message`() {
        val mood = Mood (R.color.banana_yellow, 1.0F, "super happy")
        Assert.assertEquals(mood.message, "super happy")
    }
}