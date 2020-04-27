package com.newbie.android.the100game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.databinding.DataBindingUtil
import com.newbie.android.the100game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var question: Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        question = Question()
        binding.question = question

        binding.linearLayoutContainer.forEach { button ->
            button.setOnClickListener { view ->
                checkAnswer(view, question)
                binding.buttonNext.visibility = View.VISIBLE
                binding.linearLayoutContainer.visibility = View.GONE
                binding.textViewMessage.visibility = View.GONE
            }
        }

        binding.buttonNext.setOnClickListener { view ->
            question = Question()
            binding.question = question
            view.visibility = View.INVISIBLE
            binding.linearLayoutContainer.visibility = View.VISIBLE
            binding.textViewMessage.visibility = View.VISIBLE
        }
    }

    private fun checkAnswer(view: View, question: Question) {
        val textButton = (view as Button).text
        val textAnswer = question.correctAnswer.toString()

        val text = if (textAnswer == textButton)
            "You are Correct!"
        else
            "WRONG:\nYou chose $textButton\nCorrect answer is $textAnswer"

        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).apply {
            val layout: LinearLayout = getView() as LinearLayout
            if (layout.childCount > 0) {
                val textView = layout.getChildAt(0) as TextView
                textView.gravity = Gravity.CENTER_HORIZONTAL
            }

            setGravity(Gravity.CENTER, 0, -100)
            show()
        }
    }
}
