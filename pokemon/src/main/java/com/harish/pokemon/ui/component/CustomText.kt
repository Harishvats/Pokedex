package com.harish.pokemon.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.harish.pokemon.R

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int = 16, // Default text size
    textColor: Color = Color.Black, // Default text color,
    fontWeight: Int = 500,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign= TextAlign.Center

) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = textSize.sp,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            fontWeight = FontWeight(fontWeight),
            color = textColor,
        ),
        modifier = modifier,
        maxLines=maxLines,
        textAlign = textAlign
    )
}