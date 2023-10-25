package com.harish.pokemon.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harish.pokemon.R
import com.harish.pokemon.ui.theme.TextColor

@Composable
fun FilterDialogBottomButton(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = { },
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(size = 8.dp),
            ) {
                CustomText(
                    text = stringResource(id = R.string.reset),
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )
            }

            Button(
                onClick = { },
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(size = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = TextColor)
            ) {
                CustomText(
                    text = stringResource(id = R.string.apply),
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    textColor = Color.White
                )
            }
        }
    }
}