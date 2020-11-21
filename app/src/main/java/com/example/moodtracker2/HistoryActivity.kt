package com.example.moodtracker2

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_history.*
import java.time.LocalDate


class HistoryActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //get today LocalDate value
        val today = LocalDate.now()

        //shared preferences to access moods
        val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)

        //shared preferences to access comments
        val sharedPrefComment = getSharedPreferences("comment", MODE_PRIVATE)

        //YESTERDAY LAYOUT SET-UP
        //get yesterday's date
        val yesterday = today.minusDays(0).toString()
        //get yesterday's mood
        val yesterdayMood = sharedPref.getInt(yesterday, -1)
        //get yesterday comment value
        val yesterdayComment = sharedPrefComment.getString(yesterday, null)

        //now set the mood in the yesterday layout
        when(yesterdayMood) {
            0 -> {(yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }

        //TWO DAYS AGO LAYOUT SET-UP
        //get two_days_ago's date
        val twoDaysAgo = today.minusDays(2).toString()
        //get two days ago's mood
        val twoDaysAgoMood = sharedPref.getInt(twoDaysAgo, -1)
        //get two days ago comment value
        val twoDaysAgoComment = sharedPrefComment.getString(twoDaysAgo, null)

        //now set the mood in the 2 days ago layout
        when(twoDaysAgoMood) {
            0 -> {
                (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }

        //THREE DAYS AGO LAYOUT SET-UP
        //get three_days_ago's date
        val threeDaysAgo = today.minusDays(3).toString()
        //get three days ago's mood
        val threeDaysAgoMood = sharedPref.getInt(threeDaysAgo, -1)
        //get three days ago comment value
        val threeDaysAgoComment = sharedPrefComment.getString(threeDaysAgo, null)

        //now set the mood in the 3 days ago layout
        when(threeDaysAgoMood) {
            0 -> {
                (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }

        //FOUR DAYS AGO LAYOUT SET-UP
        //get fourDaysAgo date
        val fourDaysAgo = today.minusDays(4).toString()
        //get fourDaysAgo's mood
        val fourDaysAgoMood = sharedPref.getInt(fourDaysAgo, -1)
        //get fourDaysAgo comment value
        val fourDaysAgoComment = sharedPrefComment.getString(fourDaysAgo, null)

        //now set the mood in the 4 days ago layout
        when(fourDaysAgoMood) {
            0 -> {
                (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }


        //FIVE DAYS AGO LAYOUT SET-UP
        //get fiveDaysAgo date
        val fiveDaysAgo = today.minusDays(5).toString()
        //get fiveDaysAgo's mood
        val fiveDaysAgoMood = sharedPref.getInt(fiveDaysAgo, -1)
        //get fiveDaysAgo comment value
        val fiveDaysAgoComment = sharedPrefComment.getString(fiveDaysAgo, null)

        //now set the mood in the five days ago layout
        when(fiveDaysAgoMood) {
            0 -> {
                (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }

        //SIX DAYS AGO LAYOUT SET-UP
        //get sixDaysAgo date
        val sixDaysAgo = today.minusDays(6).toString()
        //get sixDaysAgo's mood
        val sixDaysAgoMood = sharedPref.getInt(sixDaysAgo, -1)
        //get sixDaysAgo comment value
        val sixDaysAgoComment = sharedPrefComment.getString(sixDaysAgo, null)

        //now set the mood in the sixDaysAgo layout
        when(sixDaysAgoMood) {
            0 -> {
                (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }

        //SEVEN DAYS AGO LAYOUT SET-UP
        //get sevenDaysAgo date
        val sevenDaysAgo = today.minusWeeks(1).toString()
        //get sevenDaysAgo's mood
        val sevenDaysAgoMood = sharedPref.getInt(sevenDaysAgo, -1)
        //get sevenDaysAgo comment value
        val sevenDaysAgoComment = sharedPrefComment.getString(sevenDaysAgo, null)

        //now set the mood in the sevenDaysAgo layout
        when(sevenDaysAgoMood) {
            0 -> {
                (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    1.0F
                one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            1 -> {
                (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.8F
                one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
            2 -> {
                (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.6F
                one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.cornflower_blue_65))
            }
            3 -> {
                (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.4F
                one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.warm_grey))
            }
            4 -> {
                (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth =
                    0.2F
                one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(R.color.faded_red))
            }
        }
    }

}