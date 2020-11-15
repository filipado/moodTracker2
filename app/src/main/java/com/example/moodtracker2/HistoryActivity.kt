package com.example.moodtracker2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Comment
import java.security.cert.LDAPCertStoreParameters
import java.text.FieldPosition
import java.time.LocalDate

class HistoryActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //shared preferences to access mood
        val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)
        val date = LocalDate.now().toString()
        val savedMood = sharedPref.getInt(date, 0)

        recyclerview_id.setOnScrollChangeListener() {

            //shared preferences to access mood
            val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)
            val date = LocalDate.now().toString()
            val savedMood = sharedPref.getInt(date, 0)


            if (savedMood == 0) {
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.banana_yellow))
            }
            if (savedMood == 1) {
                yesterday_constraintLayout.setBackgroundColor(resources.getColor(R.color.light_sage))
            }
        }

        //moods class
        fun Mood(){
            val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)
            val date = LocalDate.now().toString()
            val savedMood = sharedPref.getInt(date, 0)

            var yesterdayConsLay = findViewById<ConstraintLayout>(R.id.yesterday_constraintLayout)
            var twoDayAgoConsLay =
                findViewById<ConstraintLayout>(R.id.two_days_ago_constraintLayout)
            var threeDaysAgoConsLay =
                findViewById<ConstraintLayout>(R.id.three_days_ago_constraintLayout)
            var fourDaysAgoConsLay =
                findViewById<ConstraintLayout>(R.id.four_days_ago_constraintLayout)
            var fiveDaysAgoConsLay =
                findViewById<ConstraintLayout>(R.id.five_days_ago_constraintLayout)
            var sixDaysAgoConsLay =
                findViewById<ConstraintLayout>(R.id.six_days_ago_constraintLayout)
            var sevenDaysAgoConsLay =
                findViewById<ConstraintLayout>(R.id.one_week_ago_constraintLayout)

            val today = LocalDate.now()
            val yesterday = LocalDate.now().minusDays(1)
            val twoDaysAgo = LocalDate.now().minusDays(2)
            val threeDaysAgo = LocalDate.now().minusDays(3)
            val fourDaysAgo = LocalDate.now().minusDays(4)
            val fiveDaysAgo = LocalDate.now().minusDays(5)
            val sixDaysAgo = LocalDate.now().minusDays(6)
            val sevenDAysAgo = LocalDate.now().minusWeeks(1)


/*
            when (savedMood) {
                0 -> {
                    setWidthPercent(1)
                    setBackgroundColor(R.color.banana_yellow)
                }

                1 -> {
                    setWidthPercent(0.8)
                    setBackgroundColor(R.color.light_sage)
                }

                2 -> {
                    setWidthPercent(0.6)
                    setBackgroundColor(R.color.cornflower_blue_65)
                }

                3 -> {
                    setWidthPercent(0.4)
                    setBackgroundColor(R.color.warm_grey)
                }

                4 -> {
                    setWidthPercent(0.2)
                    setBackgroundColor(R.color.faded_red)
                }
            }

 */

            //shared preferences to access comment
            val sharedPrefComment = getSharedPreferences("comment", MODE_PRIVATE)
            val savedComment = sharedPrefComment.getString(date, null)

        }
    }
}