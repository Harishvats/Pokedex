package com.harish.pokemon.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun TextDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            CustomText(
                text = "The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. The following example is a basic implementation of the Dialog composable. Note that it uses a Card as the secondary container. Without the Card, the Text component would appear alone above the main app content.",
                modifier = Modifier
                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center)
                    .background(color = Color.DarkGray),
                textAlign = TextAlign.Center,
                textColor = Color.White
            )
        }
    }
}