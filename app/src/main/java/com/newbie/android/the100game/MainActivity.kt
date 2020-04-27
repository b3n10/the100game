package com.newbie.android.the100game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.forEach
import androidx.databinding.DataBindingUtil
import com.newbie.android.the100game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val question = Question()
        binding.question = question

        binding.linearLayoutContainer.forEach { button ->
            button.setOnClickListener {
                    view -> checkAnswer(view as Button, question)
            }
        }
    }

    private fun checkAnswer(button: Button, question: Question) {
        val textButton = button.text
        val textAnswer = question.correctAnswer.toString()

        val text = if (textAnswer == textButton)
            "Correct: button is $textButton, answer is $textAnswer"
        else
            "Incorrect: button is $textButton, answer is $textAnswer"

        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }
}
