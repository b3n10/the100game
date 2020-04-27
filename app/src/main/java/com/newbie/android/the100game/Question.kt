package com.newbie.android.the100game

class Question {
    val mainNumber: Int = randomNumber(100)
    val correctAnswer: Int = 100 - mainNumber

    val answers = mutableListOf<Int>().apply {
        val correctButton: Int = randomNumber(10) % 4

        for (i in 0..3) {
            if (i == correctButton)
                this.add(correctAnswer)
            else
                this.add(generateIncorrectAnswer())
        }
    }

    private fun generateIncorrectAnswer(): Int {
        var answer = randomNumber(100)

        while (answer == correctAnswer)
            answer = randomNumber(100)

        return answer
    }

    private fun randomNumber(limit: Int) = (Math.random() * limit).toInt()
}
