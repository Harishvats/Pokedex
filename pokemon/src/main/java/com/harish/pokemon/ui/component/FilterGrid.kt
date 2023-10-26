package com.harish.pokemon.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterGrid(modifier: Modifier) {
    val list = listOf(
        "Bulbasor",
        "Saursoaus",
        "sajashaj",
        "Bulbasor",
        "Saursoaus",
        "sajashaj",
    )
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        content = {
            items(list.size) {
                FilterCheckBox(list[it])
            }
        })
}