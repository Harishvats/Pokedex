package com.harish.pokemon.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harish.pokemon.R
import com.harish.pokemon.ui.theme.DividerGray

@Composable
fun FilterDialogHeader(dialogDismiss: () -> Unit) {
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
                dialogDismiss()
            })
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 9.dp),
        color = DividerGray,
        thickness = 1.dp
    )
}
