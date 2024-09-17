package org.example.project.presentation.registerAndStart.gender_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.GenderIntents
import org.example.project.presentation.registerAndStart.gender_feature.viewmodel.GenderViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.woman_ava
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.man_ava

object GenderScreen: Screen {
val vm = GenderViewModel(StaticDate)
    @Composable
    override fun Content(){

        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .background(Color(0xFF027B5B)), contentAlignment = Alignment.Center
                ) {
                    Text("Your gender", color = Color.White, fontSize = 30.sp
                        , fontWeight = FontWeight.Bold)
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                        , horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth(0.7f)
                        , horizontalArrangement = Arrangement.SpaceBetween
                        , verticalAlignment = Alignment.CenterVertically){
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(Res.drawable.man_ava),
                                    contentDescription = null,
                                    modifier = Modifier.size(100.dp)
                                )
                                Box(modifier = Modifier.padding(top = 10.dp)
                                    .size(40.dp)
                                    .background(GenderViewModel.genderState.colorMan.value)
                                    .clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() })
                                    { vm.processIntent(GenderIntents.ChoosingMan) })
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(Res.drawable.woman_ava),
                                    contentDescription = null,
                                    modifier = Modifier.size(100.dp)
                                )
                                Box(modifier = Modifier.padding(top = 10.dp)
                                    .size(40.dp)
                                    .background(GenderViewModel.genderState.colorWoman.value)
                                    .clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() })
                                    { vm.processIntent(GenderIntents.ChoosingWoman) })
                        }
                    }
                        Image(painter = painterResource(Res.drawable.next_button), contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.07f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(GenderIntents.Next) })
                    }
                }
            }
        }
    }
}