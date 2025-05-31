package com.example.code

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SummarizedEmailCardRepository(private val context: Context) {

    fun getSummarizedEmailCardData(): List<SummarizedEmailCard> {
        val json = context.resources.openRawResource(R.raw.summarized_email_card_data)
            .bufferedReader()
            .use { it.readText() }

        return Gson().fromJson(json, object : TypeToken<List<SummarizedEmailCard>>() {}.type)
    }
}
