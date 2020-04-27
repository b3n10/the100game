package com.newbie.android.the100game

data class Question(val mainNumber: Int = (Math.random() * 100).toInt()) {
    private val correctAnswer: Int = 100 - mainNumber
}
