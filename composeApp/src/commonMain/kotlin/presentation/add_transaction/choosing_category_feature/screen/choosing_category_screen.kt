package org.example.project.presentation.add_transaction.choosing_category_feature.screen

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
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryIntents
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryViewModel
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.next_button


object ChoosingCategoryScreen:Screen {
    val vm = ChoosingCategoryViewModel(StaticDate)
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
                            { vm.processIntent(ChoosingCategoryIntents.Back)}
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.7f)
                            .padding(bottom = 10.dp)
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
                            Text("Category", fontSize = 15.sp, color = Color.DarkGray)
                            LazyColumn {
                                itemsIndexed(
                                    listOf(
                                        "Bank transfer", "Food",
                                        "Travelling", "Family",
                                        "House", "Pets",
                                        "Taxi", "Car", "Credit",
                                        "Holiday", "Vacation", "Other"
                                    ).chunked(3)
                                ) { indexes, item ->
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth(0.85f),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        item.forEachIndexed { index, text ->
                                            val correctIndex =
                                                indexes * 3 + index // Правильная индексация
                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(25.dp))
                                                    .width(100.dp)
                                                    .height(40.dp)
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() }
                                                    ) {
                                                        vm.processIntent(ChoosingCategoryIntents.ChoosingCategory(correctIndex,text))
                                                    }
                                                    .background(ChoosingCategoryViewModel.choosingCategoryState.listColors[correctIndex]),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    "${text}",
                                                    color = Color.Black,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
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
                                {vm.processIntent(ChoosingCategoryIntents.Next) })
                    }
                }
            }
            if (ChoosingCategoryViewModel.choosingCategoryState.toast.value) {
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
                    ChoosingCategoryViewModel.choosingCategoryState.toast.value = false
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
                    "Select a category", fontSize = 15.sp,
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
    }
}