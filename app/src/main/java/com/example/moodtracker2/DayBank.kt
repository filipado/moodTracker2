package com.example.moodtracker2

import org.threeten.bp.LocalDate

class DayBank {

    private val today = LocalDate.now()

    fun getDays(): Map<Int, Day> {
        return mapOf(
            1 to Day(
                "yesterday",
                today.minusDays(1).toString(),
                R.id.yesterday_constraintLayout,
                R.id.comment_yesterday
                ),

            2 to Day(
                "two days ago",
                today.minusDays(2).toString(),
                R.id.two_days_ago_constraintLayout,
                R.id.comment_2daysAgo
            ),

            3 to Day(
                "three days ago",
                today.minusDays(3).toString(),
                R.id.three_days_ago_constraintLayout,
                R.id.comment_3daysAgo
            ),

            4 to Day(
                "four days ago",
                today.minusDays(4).toString(),
                R.id.four_days_ago_constraintLayout,
                R.id.comment_4daysAgo
            ),

            5 to Day(
                "five days ago",
                today.minusDays(5).toString(),
                R.id.five_days_ago_constraintLayout,
                R.id.comment_5daysAgo
            ),
            6 to Day(
                "six days ago",
                today.minusDays(6).toString(),
                R.id.six_days_ago_constraintLayout,
                R.id.comment_6daysAgo
            ),
            7 to Day(
                "one week ago",
                today.minusWeeks(1).toString(),
                R.id.one_week_ago_constraintLayout,
                R.id.comment_7daysAgo
            )
        )
    }

}