package com.example.moodtracker2

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.activity_history.*
import java.time.LocalDate


class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //initializing timezone information
        AndroidThreeTen.init(this)


        //get today LocalDate value
        val today = org.threeten.bp.LocalDate.now()
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

        //get yesterday comment value
        val yesterdayComment = sharedPrefComment.getString(yesterday, null)

        //make comment button visible and add toast to show comment
        if (yesterdayComment == null) {comment_yesterday.visibility = INVISIBLE}
        else if (yesterdayComment == "") {comment_yesterday.visibility = INVISIBLE}
        else {comment_yesterday.visibility = VISIBLE
        comment_yesterday.setOnClickListener{
            Toast.makeText(this, yesterdayComment, Toast.LENGTH_SHORT).show()}}


        //TWO DAYS AGO LAYOUT SET-UP
        //get two_days_ago's date
        val twoDaysAgo = today.minusDays(2).toString()
        //get two days ago's mood
        val twoDaysAgoMood = sharedPref.getInt(twoDaysAgo, 9)

        //now set the mood in the 2 days ago layout
        val moodLayoutTwoDaysAgo = moods[twoDaysAgoMood]
        (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutTwoDaysAgo!!.width
        two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutTwoDaysAgo!!.colour))

        //get two days ago comment value
        val twoDaysAgoComment = sharedPrefComment.getString(twoDaysAgo, null)

        //make comment button visible and add toast to show comment
        if (twoDaysAgoComment!=null){comment_2daysAgo.visibility = View.VISIBLE}
        comment_2daysAgo.setOnClickListener{
            Toast.makeText(this, twoDaysAgoComment, Toast.LENGTH_SHORT).show()}

        //THREE DAYS AGO LAYOUT SET-UP
        //get three_days_ago's date
        val threeDaysAgo = today.minusDays(3).toString()
        //get three days ago's mood
        val threeDaysAgoMood = sharedPref.getInt(threeDaysAgo, 9)

        //now set the mood in the 3 days ago layout
        val moodLayoutThreeDaysAgo = moods[threeDaysAgoMood]
        (three_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutThreeDaysAgo!!.width
        three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutThreeDaysAgo!!.colour))

        //get three days ago comment value
        val threeDaysAgoComment = sharedPrefComment.getString(threeDaysAgo, null)

        //make comment button visible and add toast to show comment
        if (threeDaysAgoComment!=null){
            comment_3daysAgo.visibility = View.VISIBLE
        }

        comment_3daysAgo.setOnClickListener{
            Toast.makeText(this, threeDaysAgoComment, Toast.LENGTH_SHORT).show()
        }

        //FOUR DAYS AGO LAYOUT SET-UP
        //get fourDaysAgo date
        val fourDaysAgo = today.minusDays(4).toString()
        //get fourDaysAgo's mood
        val fourDaysAgoMood = sharedPref.getInt(fourDaysAgo, 9)

        val moodLayoutFourDaysAgo = moods[fourDaysAgoMood]
        (four_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutFourDaysAgo!!.width
        four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFourDaysAgo!!.colour))

        //get fourDaysAgo comment value
        val fourDaysAgoComment = sharedPrefComment.getString(fourDaysAgo, null)

        if (fourDaysAgoComment!=null){
            comment_4daysAgo.visibility = View.VISIBLE
        }

        comment_4daysAgo.setOnClickListener {
            Toast.makeText(this, fourDaysAgoComment, Toast.LENGTH_SHORT).show()
        }


        //FIVE DAYS AGO LAYOUT SET-UP
        //get fiveDaysAgo date
        val fiveDaysAgo = today.minusDays(5).toString()
        //get fiveDaysAgo's mood
        val fiveDaysAgoMood = sharedPref.getInt(fiveDaysAgo, 9)

        //now set the mood in the five days ago layout
        val moodLayoutFiveDaysAgo = moods[fiveDaysAgoMood]
        (five_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutFiveDaysAgo!!.width
        five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFiveDaysAgo!!.colour))

        //get fiveDaysAgo comment value
        val fiveDaysAgoComment = sharedPrefComment.getString(fiveDaysAgo, null)

        //make comment button visible and add toast to show comment
        if (fiveDaysAgoComment!=null){
            comment_5daysAgo.visibility = View.VISIBLE
        }

        comment_5daysAgo.setOnClickListener{
            Toast.makeText(this, fiveDaysAgoComment, Toast.LENGTH_SHORT).show()
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

        //get sixDaysAgo comment value
        val sixDaysAgoComment = sharedPrefComment.getString(sixDaysAgo, null)

        //make comment button visible and add toast to show comment
        if (sixDaysAgoComment!=null){
            comment_6daysAgo.visibility = View.VISIBLE
        }

        comment_6daysAgo.setOnClickListener{
            Toast.makeText(this, sixDaysAgoComment, Toast.LENGTH_SHORT).show()
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

        //get sevenDaysAgo comment value
        val sevenDaysAgoComment = sharedPrefComment.getString(sevenDaysAgo, null)

        //make comment button visible and add toast to show comment
        if (sevenDaysAgoComment!=null){
            comment_7daysAgo.visibility = View.VISIBLE
        }

        comment_7daysAgo.setOnClickListener{
            Toast.makeText(this, sevenDaysAgoComment, Toast.LENGTH_SHORT).show()
        }
    }

}