package com.example.quizapp.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParseQuestionsJsonIntoKotlinObjectsTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private lateinit var moshi: Moshi
    private lateinit var parseQuestionsJsonIntoKotlinObjects: ParseQuestionsJsonIntoKotlinObjects

    @Before
    fun setUp() {
        moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
            .build()
        parseQuestionsJsonIntoKotlinObjects = ParseQuestionsJsonIntoKotlinObjects(moshi, context)
    }

    @After
    fun tearDown() {
    }

    @ExperimentalStdlibApi
    @Test
    fun convertQuestionsJsonToKotlinObject() {
        parseQuestionsJsonIntoKotlinObjects.convertQuestionsJsonToKotlinObject().let {
            assert(it.isNotEmpty())
            assertEquals(1, it[0].id)
            assertEquals("Muhammadu Buhari",it[0].correctAnswer)
            assertEquals(4, it[1].answers.size)
        }
    }
}