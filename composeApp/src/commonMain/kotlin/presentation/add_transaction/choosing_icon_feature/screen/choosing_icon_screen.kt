package org.example.project.presentation.add_transaction.choosing_icon_feature.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryViewModel
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryIntents
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconIntents
import org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel.ChoosingIconViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.balance
import room_cmp.composeapp.generated.resources.car
import room_cmp.composeapp.generated.resources.card
import room_cmp.composeapp.generated.resources.cup
import room_cmp.composeapp.generated.resources.food
import room_cmp.composeapp.generated.resources.music
import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.people
import room_cmp.composeapp.generated.resources.phone
import room_cmp.composeapp.generated.resources.photoapp
import room_cmp.composeapp.generated.resources.planet
import room_cmp.composeapp.generated.resources.two_yellow_phone
import room_cmp.composeapp.generated.resources.yellow_calendar
import room_cmp.composeapp.generated.resources.yellow_home
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.cup

object ChoosingIconScreen: Screen {
    val vm = ChoosingIconViewModel(StaticDate)
    @Composable
    override fun Content() {
        val isVisible by remember { mutableStateOf(Animatable(0f)) }
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
                            { vm.processIntent(ChoosingIconIntents.Back)}
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
                            Text("Choose Icon", fontSize = 15.sp, color = Color.DarkGray)
                            LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
                                itemsIndexed(
                                    listOf(
                                        Res.drawable.cup, Res.drawable.photoapp,
                                        Res.drawable.card, Res.drawable.music,
                                        Res.drawable.people, Res.drawable.planet,
                                        Res.drawable.yellow_home, Res.drawable.yellow_calendar,Res.drawable.phone,
                                        Res.drawable.two_yellow_phone,Res.drawable.food,Res.drawable.car
                                    ).chunked(3)
                                ) { indexes, item ->
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth(0.5f),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        item.forEachIndexed { index, image ->
                                            val correctIndex =
                                                indexes * 3 + index // Правильная индексация
                                            Box(
                                                modifier = Modifier
                                                    .clip(CircleShape)
                                                    .size(50.dp)
                                                    .border(2.dp,ChoosingIconViewModel.choosingIconState.listColorBorder[correctIndex],RoundedCornerShape(100.dp))
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() }
                                                    ) { vm.processIntent(ChoosingIconIntents.ChoosingIcon(correctIndex,image))},
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(painter = painterResource(image), contentDescription = null
                                                , modifier = Modifier.size(50.dp))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Image(painter = painterResource(Res.drawable.next_button), contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(ChoosingIconIntents.Next) })
                    }
                }
            }
            if (ChoosingIconViewModel.choosingIconState.toast.value) {
                LaunchedEffect(key1 = true) {
                    delay(0)
                    isVisible.animateTo(
                        targetValue = 1f
                    )

                    delay(800) // видимость на 1 секунду
                    isVisible.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = LinearEasing
                        ) // плавное исчезновение

                    )
                    ChoosingIconViewModel.choosingIconState.toast.value = false
                }

            }
            Box(
                modifier = Modifier
                    .padding(bottom = 150.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .alpha(isVisible.value)
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .width(250.dp).height(50.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF027B5B),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Select an icon", fontSize = 15.sp,
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
    }
}