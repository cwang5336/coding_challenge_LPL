package com.example.code

data class SummarizedEmailCard(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
    var imageUri: String? = null
)
