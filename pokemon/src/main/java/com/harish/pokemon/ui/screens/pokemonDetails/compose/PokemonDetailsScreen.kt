package com.harish.pokemon.ui.screens.pokemonDetails.compose

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.harish.core.ViewState
import com.harish.domain.model.EggGroup
import com.harish.domain.model.PokemonDescription
import com.harish.domain.model.PokemonDetails
import com.harish.domain.model.PokemonWeakness
import com.harish.pokemon.R
import com.harish.pokemon.ui.component.CustomText
import com.harish.pokemon.ui.component.detail.PokemonAttributesComponent
import com.harish.pokemon.ui.component.detail.PokemonColoredAttributesComponent
import com.harish.pokemon.ui.component.detail.PokemonDescriptionComponent
import com.harish.pokemon.ui.component.detail.PokemonStatsComponent
import com.harish.pokemon.ui.screens.pokemonDetails.viewmodel.PokemonDetailsViewModel
import com.harish.pokemon.ui.theme.PageBackground
import com.harish.pokemon.ui.theme.TextColor
import com.harish.pokemon.ui.utils.AppConstants

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonDetailsScreen(
    pokemonDetailsViewModel: PokemonDetailsViewModel,
    selectedPokemonName: String,
    selectedPokemonId: String,
    onCloseClicked: () -> Unit
) {
    var openReadMoreDialog by remember { mutableStateOf(false) }
    var descriptionText = ""
    var eggGroups= listOf<EggGroup>()

    LaunchedEffect(key1 = Unit, block = {
        pokemonDetailsViewModel.getPokemonDescription(selectedPokemonId.trim().toInt())
        pokemonDetailsViewModel.getPokemonDetails(selectedPokemonId.trim().toInt())
        pokemonDetailsViewModel.getPokemonWeakness(selectedPokemonId.trim().toInt())

    })
    Column(
        modifier = Modifier
            .background(PageBackground)
            .verticalScroll(rememberScrollState())
    ) {
        DetailPageHeader(selectedPokemonName, selectedPokemonId, onCloseClicked)

        val descriptionValue = pokemonDetailsViewModel.pokemonDescriptionStateFlow.collectAsState()
        if (descriptionValue.value is ViewState.SuccessState) {
            descriptionText =
                (descriptionValue.value as ViewState.SuccessState<PokemonDescription>).data.description

            eggGroups= (descriptionValue.value as ViewState.SuccessState<PokemonDescription>).data.eggGroups

            PokemonDescriptionComponent(
                description = descriptionText,
                imageUrl = AppConstants.IMG_URL_PREFIX + selectedPokemonId + AppConstants.IMG_EXT,
            ) {
                openReadMoreDialog = it
            }

        }

        val detailsValue = pokemonDetailsViewModel.pokemonDetailStateFlow.collectAsState()
        val weaknessValue=pokemonDetailsViewModel.pokemonWeaknessStateFlow.collectAsState()

        if (detailsValue.value is ViewState.SuccessState && weaknessValue.value is ViewState.SuccessState) {
           val pokemonDetails= (detailsValue.value as ViewState.SuccessState<PokemonDetails>).data
            val weakness= (weaknessValue.value as ViewState.SuccessState<PokemonWeakness>).data

            FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(R.string.height),
                    attributeValue = listOf(String.format("%.1f M", pokemonDetails.height.toFloat() / 10))
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                PokemonAttributesComponent(
                    attributeName = stringResource(R.string.weight),
                    attributeValue = listOf(String.format("%.1f KG", pokemonDetails.weight.toFloat() / 10))
                )
            }
            Row(modifier = Modifier.weight(.5f)) {
                    PokemonAttributesComponent(
                        attributeName = stringResource(R.string.gender),
                        attributeValue = listOf("male")
                    )
            }
            Row(modifier = Modifier.weight(.5f)) {
                eggGroups.map { it.name }.let {
                    PokemonAttributesComponent(
                        attributeName = stringResource(R.string.egg_group),
                        attributeValue = it
                    )
                }
            }
            Row(modifier = Modifier.weight(.5f)) {
                pokemonDetails.abilities.map { it.ability.name }.let {
                    PokemonAttributesComponent(
                        attributeName = stringResource(R.string.abilities),
                        attributeValue = it
                    )
                }
            }

            Row(modifier = Modifier.weight(.5f)) {
                pokemonDetails.types.map { it.type.name }.let {
                    PokemonColoredAttributesComponent(
                        stringResource(R.string.types),
                        it
                    )
                }
            }

            Row(modifier = Modifier.weight(1f)) {
                weakness.weakness.map { it.name }.let {
                    PokemonColoredAttributesComponent(
                        stringResource(R.string.weak),
                        it
                    )
                }
            }

        }

            PokemonStatsComponent(pokemonDetails.stats)
    }


        if (openReadMoreDialog) {
            Popup(
                alignment = Alignment.Center, properties = PopupProperties(clippingEnabled = false)
            ) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 20.dp, spotColor = TextColor, ambientColor = TextColor
                        )
                        .background(
                            color = TextColor, shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(350.dp)
                        .height(500.dp)
                        .padding(20.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        val scroll = rememberScrollState(0)

                        CustomText(
                            text = descriptionText,
                            textSize = 14,
                            fontWeight = FontWeight.Normal.weight,
                            textColor = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .verticalScroll(scroll)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_popup_cross),
                            contentDescription = stringResource(id = R.string.close),
                            modifier = Modifier.clickable {
                                openReadMoreDialog = false
                            })
                    }
                }
            }
        }

    }
}