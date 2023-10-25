package com.harish.pokemon.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.harish.pokemon.R
import com.harish.pokemon.ui.theme.DividerGray

@Composable
fun FilterDisplay(filterName:String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 28.dp, bottom = 10.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF2E3156),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomText(
                        text = filterName,
                        textSize = 18,
                        fontWeight = 800,
                        modifier = Modifier.weight(1f)

                        )
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(2f)
                    ) {

                        Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .height(31.dp),
                            color = DividerGray,
                            thickness = 1.dp
                        )
                        CustomText(
                            text = "(Normal + 5 More)",
                            textSize = 14,
                            fontWeight = 300,
                            modifier = Modifier.padding(start = 10.dp)

                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Close",
                        contentScale = ContentScale.None,
                        modifier = Modifier.clickable { }
                    )
                }
            }
        }
    }
}