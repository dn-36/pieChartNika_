package org.example.project.presentation.add_transaction.name_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconIntents
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconViewModel
import org.example.project.presentation.add_transaction.name_feature.viewmodel.NameIntents
import org.example.project.presentation.add_transaction.name_feature.viewmodel.NameViewModel
import org.jetbrains.compose.resources.painterResource

import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button

object NameScreen: Screen {
    val vm = NameViewModel(StaticDate)
    @Composable
    override fun Content() {
        var name by remember { mutableStateOf("name") }

        Box(modifier = Modifier.fillMaxSize()) {
            Column {

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.25f)
                        .fillMaxWidth()
                        .background(Color(0xFF027B5B))
                ) {
                    Image(
                        painter = painterResource(Res.drawable.back_button),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 20.dp)
                            .size(20.dp)
                            .align(Alignment.TopStart)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(NameIntents.Back)}
                    )
                    Column(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxHeight(0.7f)
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.SpaceAround
                        , horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box() {
                            Column {
                                Text(
                                    text = "Balance",
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.85f)
                                        .fillMaxHeight(0.6f)
                                        .border(
                                            1.dp,
                                            color = Color.White,
                                            RoundedCornerShape(20.dp)
                                        )
                                ) {
                                    Text(
                                        text = "50000$",
                                        color = Color.White,
                                        fontSize = 35.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }
                        }
                        Text(
                            text = "Add Transaction",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                    , contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxHeight(0.8f)
                        , verticalArrangement = Arrangement.SpaceBetween
                        , horizontalAlignment = Alignment.CenterHorizontally) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Name", fontSize = 15.sp, color = Color.DarkGray)
                            Box(
                                modifier = Modifier.padding(top = 30.dp).clip(RoundedCornerShape(10.dp))
                                    .fillMaxWidth(0.8f).fillMaxHeight(0.15f)
                                    .background(Color(0xFFF0F2F6)), contentAlignment = Alignment.Center
                            ) {
                                BasicTextField(
                                    value = name,
                                    onValueChange = { name = it },
                                    textStyle = TextStyle(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                )
                            }
                        }
                        Image(painter = painterResource(Res.drawable.next_button), contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(NameIntents.Next(name)) })
                    }
                }
            }
        }
    }
}