package com.example.relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Dynamically creating relative layout

        val relativeLayout = RelativeLayout(this)
        val layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        val helloWorldTextView = TextView(this)
        helloWorldTextView.text = "Hello, World!"
        helloWorldTextView.id = View.generateViewId()
        helloWorldTextView.gravity = Gravity.CENTER
        val helloWorldTextViewParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        helloWorldTextViewParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        helloWorldTextView.layoutParams = helloWorldTextViewParams

        val thisIsRelativeLayoutTextView = TextView(this)
        thisIsRelativeLayoutTextView.text = "This is a RelativeLayout"
        thisIsRelativeLayoutTextView.id = View.generateViewId()
        val thisIsRelativeLayoutLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        thisIsRelativeLayoutLayoutParams.addRule(RelativeLayout.BELOW, helloWorldTextView.id)
        thisIsRelativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_LEFT, helloWorldTextView.id)
        thisIsRelativeLayoutLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.margin_16)

        val niceToMeetYouTextView = TextView(this)
        niceToMeetYouTextView.text = "Nice to meet you!"
        niceToMeetYouTextView.id = View.generateViewId()
        val niceToMeetYouLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        niceToMeetYouLayoutParams.addRule(RelativeLayout.RIGHT_OF, helloWorldTextView.id)
        niceToMeetYouLayoutParams.addRule(RelativeLayout.ALIGN_TOP, helloWorldTextView.id)
        niceToMeetYouLayoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.margin_16)

        val clickMeButton = Button(this)
        clickMeButton.text = "Click me!"
        clickMeButton.id = View.generateViewId()
        val clickMeButtonLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        clickMeButtonLayoutParams.addRule(RelativeLayout.BELOW, thisIsRelativeLayoutTextView.id)
        clickMeButtonLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        clickMeButtonLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.margin_16)

        val noClickMeButton = Button(this)
        noClickMeButton.text = "No, click me!"
        val noClickMeButtonLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        noClickMeButtonLayoutParams.addRule(RelativeLayout.BELOW, clickMeButton.id)
        noClickMeButtonLayoutParams.addRule(RelativeLayout.ALIGN_LEFT, clickMeButton.id)
        noClickMeButtonLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.margin_16)

        relativeLayout.addView(helloWorldTextView)
        relativeLayout.addView(thisIsRelativeLayoutTextView, thisIsRelativeLayoutLayoutParams)
        relativeLayout.addView(niceToMeetYouTextView, niceToMeetYouLayoutParams)
        relativeLayout.addView(clickMeButton, clickMeButtonLayoutParams)
        relativeLayout.addView(noClickMeButton, noClickMeButtonLayoutParams)

        setContentView(relativeLayout, layoutParams)

    }
}