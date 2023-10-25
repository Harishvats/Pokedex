package com.harish.pokemon.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.harish.pokemon.R
import com.harish.pokemon.ui.theme.DividerGray
import com.harish.pokemon.ui.theme.TextColor

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
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                CustomText(
                                    text = stringResource(id = R.string.filters),
                                    textSize = 25,
                                    fontWeight = 800,

                                    )
                                Image(painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "Close",
                                    contentScale = ContentScale.None,
                                    modifier = Modifier.clickable {
                                        openFilterDialog.value = false
                                    })
                            }

                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 9.dp),
                                color = DividerGray,
                                thickness = 1.dp
                            )

                            FilterDisplay("Type")
                            FilterDisplay("Gender")
                        }

                        Column(
                            modifier = Modifier.align(Alignment.BottomStart)
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

                }
            }

    }
}