package com.harish.pokemon.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun FilterDialog() {
    val openFilterDialog = remember { mutableStateOf(true) }
    when {
        openFilterDialog.value ->

            Dialog(onDismissRequest = { openFilterDialog.value = false }) {
                Surface(
                    shape = RoundedCornerShape(16.dp), color = Color.White
                ) {
                    Box(
                        modifier = Modifier.height(600.dp)
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {

                            FilterDialogHeader {
                                openFilterDialog.value = false
                            }
                            FilterDisplay("Type", true)
                            FilterDisplay("Gender", false)
                        }
                        FilterDialogBottomButton(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .background(color = Color.White)
                        )

                    }

                }
            }

    }
}

