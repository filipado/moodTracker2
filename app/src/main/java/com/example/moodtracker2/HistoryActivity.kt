package com.example.moodtracker2

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.threetenabp.AndroidThreeTen

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //initialize timezone information for ThreeTenBP library
        AndroidThreeTen.init(this)

        //loop repeating setLayout function for period of 7 days
        for (i in 1..7){

            //getting day according to the i
            val day = DayBank().getDays()[i]

            //setting layout in accordance to setLayout function -> see below
            if (day != null) {
                setLayout(day)
            }
        }
    }

    //functions:

    //elective functionality - allows to share the mood with relevant mood and day values
    private fun shareMood(mood: Mood, day: Day) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Mood")
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Hi, I felt ${mood.message} ${day.dayStringForComment}. If you would like to track your mood for a week and share it with your friends, download Mood Tracker from Play Store."
        )
        startActivity(Intent.createChooser(intent, "Send Email"))
    }

    //function that sets the layout according to the day
    private fun setLayout(day: Day){

        //shared preferences to access selected moods and comments
        val sharedPref = getSharedPreferences("mood", MODE_PRIVATE)
        val sharedPrefComment = getSharedPreferences("comment", MODE_PRIVATE)

        //get moods and time value
        val moods = MoodBank().getMoods()
        val daysAgo = day.dayValueForSharedPreferences

        //get mood for the day, default/blank mood is set-up
        val daysMood = sharedPref.getInt(daysAgo, 9)

        //get constraint layout and comment image view layout elements
        val layout = findViewById<ConstraintLayout>(day.constraintLayout)
        val commentImageButton = findViewById<ImageView>(day.commentButton)

        //now set the mood in relevant to the day
        val moodLayoutDaysAgo = moods[daysMood]

        //change layout width and colour
        (layout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutDaysAgo!!.width
        layout.setBackgroundColor(resources.getColor(moodLayoutDaysAgo.colour))

        //add sharing functionality using shareMood function
        if (daysMood!=9) layout.setOnClickListener{
            shareMood(moodLayoutDaysAgo, day)
        }

        //make comment button visible and show comment using Toast
        when (val daysAgoComment = sharedPrefComment.getString(daysAgo, null)) {
            null, "" -> commentImageButton.visibility = INVISIBLE
            else -> {commentImageButton.visibility = VISIBLE
                commentImageButton.setOnClickListener{
                    Toast.makeText(this, daysAgoComment, Toast.LENGTH_SHORT).show()}}
        }
    }
}

/* OLD CODE


        //TWO DAYS AGO LAYOUT SET-UP:

        //get two_days_ago's date
        val twoDaysAgo = today.minusDays(2).toString()
        //get two days ago's mood
        val twoDaysAgoMood = sharedPref.getInt(twoDaysAgo, 9)

        //now set the mood in the 2 days ago layout
        val moodLayoutTwoDaysAgo = moods[twoDaysAgoMood]
        (two_days_ago_constraintLayout.layoutParams as ConstraintLayout.LayoutParams).matchConstraintPercentWidth = moodLayoutTwoDaysAgo!!.width
        two_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutTwoDaysAgo.colour))

        //adding sharing functionality
        if (twoDaysAgoMood!=9) two_days_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutTwoDaysAgo)
        }
        //make comment button visible and add toast to show comment
        when (val twoDaysAgoComment = sharedPrefComment.getString(twoDaysAgo, null)) {
            null, "" -> comment_2daysAgo.visibility = INVISIBLE
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
        three_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutThreeDaysAgo.colour))

        //adding sharing functionality
        if (threeDaysAgoMood!=9) three_days_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutThreeDaysAgo)
        }

        //make comment button visible and add toast to show comment
        when (val threeDaysAgoComment = sharedPrefComment.getString(threeDaysAgo, null)) {
            null, "" -> comment_3daysAgo.visibility = INVISIBLE
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
        four_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFourDaysAgo.colour))

        //adding sharing functionality
        if (fourDaysAgoMood!=9) four_days_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutFourDaysAgo)
        }

        when (val fourDaysAgoComment = sharedPrefComment.getString(fourDaysAgo, null)) {
            null, "" -> comment_4daysAgo.visibility = INVISIBLE
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
        five_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutFiveDaysAgo.colour))

        //adding sharing functionality
        if (fiveDaysAgoMood!=9) five_days_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutFiveDaysAgo)
        }

        //make comment button visible and add toast to show comment
        when (val fiveDaysAgoComment = sharedPrefComment.getString(fiveDaysAgo, null)) {
            null, "" -> comment_5daysAgo.visibility = INVISIBLE
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
        six_days_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutSixDaysAgo.colour))

        //adding sharing functionality
        if (sixDaysAgoMood!=9) six_days_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutSixDaysAgo)
        }

        //get sixDaysAgo comment value
        when (val sixDaysAgoComment = sharedPrefComment.getString(sixDaysAgo, null)) {
            null, "" -> comment_6daysAgo.visibility = INVISIBLE
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
        one_week_ago_constraintLayout.setBackgroundColor(resources.getColor(moodLayoutOneWeekAgo.colour))

        //adding sharing functionality
        if (sevenDaysAgoMood!=9) one_week_ago_constraintLayout.setOnClickListener{
            shareMood(moodLayoutOneWeekAgo)
        }

        //get sevenDaysAgo comment value
        when (val sevenDaysAgoComment = sharedPrefComment.getString(sevenDaysAgo, null)) {
            null, "" -> comment_7daysAgo.visibility = INVISIBLE
        else -> {comment_7daysAgo.visibility = VISIBLE
        comment_7daysAgo.setOnClickListener{
            Toast.makeText(this, sevenDaysAgoComment, Toast.LENGTH_SHORT).show()
        }}
        }

 */
