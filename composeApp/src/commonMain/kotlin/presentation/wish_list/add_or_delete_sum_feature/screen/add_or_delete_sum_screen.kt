package org.example.project.presentation.wish_list.add_or_delete_sum_feature.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteIntents
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.done_button

object AddOrDeleteScreen: Screen {
    var vm = AddOrDeleteViewModel(StaticDate)
    @Composable
    override fun Content(){
        val isVisible by remember { mutableStateOf(Animatable(0f)) }

        var sum by remember { mutableStateOf("") }

        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15f)
                        .background(Color(0xFF027B5B))
                ) {
                    Image(
                        painter = painterResource(Res.drawable.back_button),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 25.dp, start = 20.dp)
                            .size(20.dp)
                            .align(Alignment.TopStart)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(AddOrDeleteIntents.Back)}
                    )
                    Text(
                        "ADD SUM",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 20.dp).align(Alignment.TopCenter)
                    )
                    Row(modifier = Modifier.fillMaxWidth(0.7f)
                        .padding(bottom = 15.dp).align(Alignment.BottomCenter)
                    , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Column {
                            Text(text = "Add", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(AddOrDeleteViewModel.addOrDeleteState.alphaAdd.value)
                                .padding(top = 5.dp).width(30.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                   vm.processIntent(AddOrDeleteIntents.Add) })
                        }
                        Column {
                            Text(text = "Delete", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(AddOrDeleteViewModel.addOrDeleteState.alphaDelete.value)
                                .padding(top = 5.dp).width(50.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(AddOrDeleteIntents.Delete) })
                        }
                    }
                }
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(0.7f).fillMaxHeight(0.1f)
                                .background(Color(0xFFF0F2F6)),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicTextField(
                                value = sum,
                                onValueChange = { sum = it },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                            )
                        }


                        Image(
                            painter = painterResource(Res.drawable.done_button),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                {vm.processIntent(AddOrDeleteIntents.Done(sum))}
                        )
                    }
                    if (AddOrDeleteViewModel.addOrDeleteState.toast.value) {
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
                            AddOrDeleteViewModel.addOrDeleteState.toast.value = false
                        }

                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .alpha(isVisible.value)
                            .align(Alignment.BottomCenter)
                            .background(Color.White)
                            .width(300.dp).height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFF027B5B),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            AddOrDeleteViewModel.addOrDeleteState.toastText.value, fontSize = 15.sp,
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}