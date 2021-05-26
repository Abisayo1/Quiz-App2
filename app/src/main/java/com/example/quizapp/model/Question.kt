package com.example.quizapp.model

/*
You can think of other possible fields to add to the Question data class e.g
subject, date, etc
*/
data class Question(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswer: String
)