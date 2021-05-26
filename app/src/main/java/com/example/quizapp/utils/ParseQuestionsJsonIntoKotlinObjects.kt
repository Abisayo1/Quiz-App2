package com.example.quizapp.utils

import android.content.Context
import com.example.quizapp.model.Question
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import java.io.InputStreamReader

/*
This class does the following
1. It reads out the json string inside the Questions.json file in the assets folder
2. It uses moshi to convert the json strings into kotlin Question object that can be used
by the app
*/
class ParseQuestionsJsonIntoKotlinObjects(
    private val moshi: Moshi,
    private val context: Context
) {

    @ExperimentalStdlibApi
    fun convertQuestionsJsonToKotlinObject(): List<Question> {
        context.assets.open("Questions.json").apply {
            val inputStreamReader = InputStreamReader(this)
            val questionsJsonString = inputStreamReader.readText()
            // close input stream reader
            inputStreamReader.close()

            // convert questionsJsonString to kotlin object list using moshi
            return moshi.adapter<List<Question>>().fromJson(questionsJsonString) ?: mutableListOf()
        }
    }
}