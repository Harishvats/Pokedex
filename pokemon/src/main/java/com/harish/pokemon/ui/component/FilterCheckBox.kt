package com.harish.pokemon.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun FilterCheckBox(filterName: String) {
    val checkedState = remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = TextColor,
            )
        )
        CustomText(
            text = filterName,
            modifier = Modifier.padding(10.dp),
            textSize = 14,
            fontWeight = 400
        )
    }
}