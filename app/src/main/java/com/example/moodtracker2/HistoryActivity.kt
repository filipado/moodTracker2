package com.example.moodtracker2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
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

        //importing moods from the Mood Bank
        val moods = MoodBank(applicationContext).getMoods()


        //YESTERDAY LAYOUT SET-UP
        //get yesterday's date
        val yesterday = today.minusDays(1).toString()
        //get yesterday's mood
        val yesterdayMood = sharedPref.getInt(yesterday, 9)

        //now set the layout according to mood
        val moodLayoutYesterday = moods[yesterdayMood]
        (yesterday_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutYesterday!!.width
        yesterday_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutYesterday!!.colour))

        //adding sharing functionality
        yesterday_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        //make comment button visible and add toast to show comment
        when (val yesterdayComment = sharedPrefComment.getString(yesterday, null)) {
            null -> {
                comment_yesterday.visibility = INVISIBLE
            }
            "" -> {
                comment_yesterday.visibility = INVISIBLE
            }
            else -> {comment_yesterday.visibility = VISIBLE
                comment_yesterday.setOnClickListener{
                    Toast.makeText(this, yesterdayComment, Toast.LENGTH_SHORT).show()}}
        }


        //TWO DAYS AGO LAYOUT SET-UP:

        //get two_days_ago's date
        val twoDaysAgo = today.minusDays(2).toString()
        //get two days ago's mood
        val twoDaysAgoMood = sharedPref.getInt(twoDaysAgo, 9)

        //now set the mood in the 2 days ago layout
        val moodLayoutTwoDaysAgo = moods[twoDaysAgoMood]
        (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutTwoDaysAgo!!.width
        two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutTwoDaysAgo!!.colour))

        //adding sharing functionality
        two_days_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
        //make comment button visible and add toast to show comment
        when (val twoDaysAgoComment = sharedPrefComment.getString(twoDaysAgo, null)) {
            null -> {
                comment_2daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_2daysAgo.visibility = View.INVISIBLE
            }
            else -> {comment_2daysAgo.visibility = VISIBLE
                comment_2daysAgo.setOnClickListener{
                    Toast.makeText(this, twoDaysAgoComment, Toast.LENGTH_SHORT).show()}}
        }

        //THREE DAYS AGO LAYOUT SET-UP:

        //get three_days_ago's date
        val threeDaysAgo = today.minusDays(3).toString()
        //get three days ago's mood
        val threeDaysAgoMood = sharedPref.getInt(threeDaysAgo, 9)

        //now set the mood in the 3 days ago layout
        val moodLayoutThreeDaysAgo = moods[threeDaysAgoMood]
        (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutThreeDaysAgo!!.width
        three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutThreeDaysAgo!!.colour))

        //adding sharing functionality
        three_days_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        //make comment button visible and add toast to show comment
        when (val threeDaysAgoComment = sharedPrefComment.getString(threeDaysAgo, null)) {
            null -> {
                comment_3daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_3daysAgo.visibility = View.INVISIBLE
            }
            else -> {
                comment_3daysAgo.visibility = VISIBLE
                comment_3daysAgo.setOnClickListener {
                    Toast.makeText(this, threeDaysAgoComment, Toast.LENGTH_SHORT).show()}
                }
        }

        //FOUR DAYS AGO LAYOUT SET-UP:

        //get fourDaysAgo date
        val fourDaysAgo = today.minusDays(4).toString()
        //get fourDaysAgo's mood
        val fourDaysAgoMood = sharedPref.getInt(fourDaysAgo, 9)

        val moodLayoutFourDaysAgo = moods[fourDaysAgoMood]
        (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutFourDaysAgo!!.width
        four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFourDaysAgo!!.colour))

        //adding sharing functionality
        four_days_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        when (val fourDaysAgoComment = sharedPrefComment.getString(fourDaysAgo, null)) {
            null -> {
                comment_4daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_4daysAgo.visibility = View.INVISIBLE
            }
            else -> {comment_4daysAgo.visibility = VISIBLE
                comment_4daysAgo.setOnClickListener {
                    Toast.makeText(this, fourDaysAgoComment, Toast.LENGTH_SHORT).show()}}
        }


        //FIVE DAYS AGO LAYOUT SET-UP:

        //get fiveDaysAgo date
        val fiveDaysAgo = today.minusDays(5).toString()
        //get fiveDaysAgo's mood
        val fiveDaysAgoMood = sharedPref.getInt(fiveDaysAgo, 9)

        //now set the mood in the five days ago layout
        val moodLayoutFiveDaysAgo = moods[fiveDaysAgoMood]
        (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutFiveDaysAgo!!.width
        five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFiveDaysAgo!!.colour))

        //adding sharing functionality
        five_days_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        //make comment button visible and add toast to show comment
        when (val fiveDaysAgoComment = sharedPrefComment.getString(fiveDaysAgo, null)) {
            null -> {
                comment_5daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_5daysAgo.visibility = View.INVISIBLE
            }
            else -> {comment_5daysAgo.visibility = VISIBLE
                comment_5daysAgo.setOnClickListener{
                    Toast.makeText(this, fiveDaysAgoComment, Toast.LENGTH_SHORT).show()}}
        }

        //SIX DAYS AGO LAYOUT SET-UP

        //get sixDaysAgo date
        val sixDaysAgo = today.minusDays(6).toString()
        //get sixDaysAgo's mood
        val sixDaysAgoMood = sharedPref.getInt(sixDaysAgo, 9)

        //now set the mood in the sixDaysAgo layout
        val moodLayoutSixDaysAgo = moods[sixDaysAgoMood]
        (six_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutSixDaysAgo!!.width
        six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutSixDaysAgo!!.colour))

        //adding sharing functionality
        six_days_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        //get sixDaysAgo comment value
        when (val sixDaysAgoComment = sharedPrefComment.getString(sixDaysAgo, null)) {
            null -> {
                comment_6daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_6daysAgo.visibility = View.INVISIBLE
            }
            else -> {comment_6daysAgo.visibility = VISIBLE
                comment_6daysAgo.setOnClickListener{
                    Toast.makeText(this, sixDaysAgoComment, Toast.LENGTH_SHORT).show()}}
        }

        //SEVEN DAYS AGO LAYOUT SET-UP

        //get sevenDaysAgo date
        val sevenDaysAgo = today.minusDays(7).toString()
        //get sevenDaysAgo's mood
        val sevenDaysAgoMood = sharedPref.getInt(sevenDaysAgo, 9)

        //now set the mood in the sevenDaysAgo layout
        val moodLayoutOneWeekAgo = moods[sevenDaysAgoMood]
        (one_week_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutOneWeekAgo!!.width
        one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutOneWeekAgo!!.colour))

        //adding sharing functionality
        one_week_ago_constraintLayout.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain";
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood is...")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi! " +
                    "I wanted to share my mood with you today from my Mood Tracker App. " +
                    "If you would like to track your mood everyday for a week and share it with your friends, you can download it from Google App Store!")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        //get sevenDaysAgo comment value
        when (val sevenDaysAgoComment = sharedPrefComment.getString(sevenDaysAgo, null)) {
            null -> {
                comment_7daysAgo.visibility = View.INVISIBLE
            }
            "" -> {
                comment_7daysAgo.visibility = View.INVISIBLE
            }
        else -> {comment_7daysAgo.visibility = VISIBLE
        comment_7daysAgo.setOnClickListener{
            Toast.makeText(this, sevenDaysAgoComment, Toast.LENGTH_SHORT).show()
        }}
        }
    }
}
