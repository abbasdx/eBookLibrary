package com.example.e_book.presentation.nav

import kotlinx.serialization.Serializable

sealed class Routes{

    @Serializable
    object New

    @Serializable
    object Home

    @Serializable
    data class BookByCategory(
        val categoryName: String
    )

    @Serializable
    object AllBooks

    @Serializable
    data class PdfViewScreen(
        val Bookurl: String
    )
}