package com.harish.pokemon.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harish.pokemon.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(modifier: Modifier) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var text by remember { mutableStateOf("") }

    Row(
        modifier = modifier.height(57.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {


        BasicTextField(modifier = Modifier
            .weight(2f)
            .onFocusChanged {
                if (it.isFocused) {

                } else {

                }
            }, value = text, onValueChange = {
            text = it
        }, singleLine = true, textStyle = LocalTextStyle.current.copy(
            fontSize = 14.sp
        ), keyboardActions = KeyboardActions {
            keyboardController?.hide()
            focusManager.clearFocus()
        }, decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(
                    color = Color(0xFFC9DDE2), shape = RoundedCornerShape(
                        size = 8.dp
                    )
                )
            ) {
                Box(
                    Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    if (text.isEmpty()) {
                        CustomText(
                            text = stringResource(id = R.string.search_hint),
                            textColor = Color.Gray
                        )
                    }
                    innerTextField()
                }

                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                    contentDescription = LocalContext.current.getString(R.string.pokedex),
                    modifier = Modifier
                        .padding(end = 23.dp, top = 14.dp, bottom = 14.dp)
                        .clickable {

                        })


            }
        })

        Image(painter = painterResource(id = R.drawable.filter_icon),
            contentDescription = LocalContext.current.getString(R.string.pokedex),
            modifier = Modifier
//                .weight(1f)
                .padding(top = 4.dp, bottom = 4.dp, start = 22.dp)
                .fillMaxHeight()
                .clickable {

                })
    }
}