package com.newbie.android.the100game

data class Question(val mainNumber: Int = (Math.random() * 100).toInt()) {
    val correctAnswer: Int = 100 - mainNumber
    val correctButton: Int = (Math.random() * 10).toInt() % 4

    val buttonLists = listOf<Int>(
       // generateIncorrectAnswer()
    )

    private fun generateIncorrectAnswer() {
       // generate an incorrect answer based on correctAnswer
    }
}
