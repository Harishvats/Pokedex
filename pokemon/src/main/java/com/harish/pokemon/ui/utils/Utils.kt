package com.harish.pokemon.ui.utils

object Utils {

    fun formatId(index: String): String {
        return when (index.length) {
            3 -> index
            2 -> "0$index"
            1 -> "00$index"
            else -> {
                index
            }
        }
    }
}