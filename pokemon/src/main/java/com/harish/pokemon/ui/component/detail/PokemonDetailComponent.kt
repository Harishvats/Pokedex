package com.harish.pokemon.ui.component.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.screens.pokemonList.compose.DetailPageHeader
import com.harish.pokemon.ui.theme.PageBackground
import com.harish.pokemon.ui.theme.TextColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonDetailComponent() {

    var openReadMoreDialog by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        modifier = Modifier
            .background(PageBackground)
            .verticalScroll(rememberScrollState())
    ) {
        DetailPageHeader("Pikacchu", "003")

        PokemonImageAndTextComponent {
            openReadMoreDialog = it
        }

        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(id = R.string.height),
                    attributeValue = "5'7'"
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(id = R.string.weight),
                    attributeValue = "68kg"
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(id = R.string.gender),
                    attributeValue = "Male, Female"
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(id = R.string.egg_group),
                    attributeValue = "Monstor, Dragon"
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(id = R.string.abilities),
                    attributeValue = "Blaze, Solar-Power"
                )
            }

            Row(modifier = Modifier.weight(.5f)) {
                PokemonColoredAttributesComponent(stringResource(id = R.string.types))
            }

            Row(modifier = Modifier.weight(1f)) {
                PokemonColoredAttributesComponent(stringResource(id = R.string.weak))
            }

        }

        PokemonStatsComponent("HP", "78", 0.78f)
        EvolutionChainComponent()

        PokemonBottomButtonComponent()

        if (openReadMoreDialog) {
            Popup(
                alignment = Alignment.Center,
                properties = PopupProperties(clippingEnabled = false)
            ) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 20.dp,
                            spotColor = TextColor,
                            ambientColor = TextColor
                        )
                        .background(
                            color = TextColor,
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(350.dp)
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        CustomText(
                            text = "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally. When expelling a blast of super hot fire, the red flame at the tip of its tail burns more intensely. If CHARIZARD becomes furious, the flame at the tip of its tail flares up in a whitish-blue color. Breathing intense, hot flames, it can melt almost any thing. Its breath inflicts terrible pain on enemies. It uses its wings to fly high. The temperature of its fire increases as it gains expeience in battle. CHARIZARD flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything. However, it never turns its fiery breath on any opponent weaker than itself. Its wings can carry this POKéMON close to an altitude of 4,600 feet. It blows out fire at very high temperatures. It is said that CHARIZARD’s fire burns hotter if it has experienced harsh battles.",
                            textSize = 14,
                            fontWeight = FontWeight.Normal.weight,
                            textColor = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_close),
                            contentDescription = "Cross",
                            modifier = Modifier.clickable {
                                openReadMoreDialog = false
                            }
                        )
                    }
                }
            }
        }

    }


}

