package org.example.project.presentation.calculator_feature.model

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
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.calculator_feature.screen.CalculatorScreen.vm
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorIntents
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.open_button

@Composable
fun Loan(){
    Box(modifier = Modifier.fillMaxSize()) {

        val isVisible by remember { mutableStateOf(Animatable(0f)) }

        var sum by remember { mutableStateOf("") }

        var term by remember { mutableStateOf("") }

        var rate by remember { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 80.dp)
                .align(Alignment.TopCenter).fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Loan Sum", color = Color.Black, fontSize = 20.sp)

            Box(
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(0.7f).height(60.dp)
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
                        fontSize = 23.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                )
            }
            Text("Loan Term", color = Color.Black, fontSize = 20.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.7f).height(60.dp)
                        .background(Color(0xFFF0F2F6)),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BasicTextField(
                            value = term,
                            onValueChange = { term = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 23.sp
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                        )

                        Box(
                            modifier = Modifier.padding(start = 10.dp)
                                .width(1.dp).height(40.dp).background(Color.Gray)
                        )
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(start = 20.dp)
                        ) {
                            if (!CalculatorViewModel.calculatorState.openMonth.value) {
                                Text(
                                    CalculatorViewModel.calculatorState.month.value,
                                    color = Color.Black,
                                    fontSize = 12.sp
                                )
                            } else {
                                Text("Month", color = Color.Black, fontSize = 12.sp,
                                    modifier = Modifier.clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(CalculatorIntents.ChoosingTerm("Month"))
                                    })
                                Text("Year", color = Color.Black, fontSize = 12.sp,
                                    modifier = Modifier.clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(CalculatorIntents.ChoosingTerm("Year"))
                                    })
                            }
                            Image(
                                painter = painterResource(Res.drawable.open_button),
                                contentDescription = null,
                                modifier = Modifier.size(10.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    vm.processIntent(CalculatorIntents.OpenMonth)
                                }
                            )
                        }
                    }
                }
            }
            Text("Interest Rate", color = Color.Black, fontSize = 20.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(0.7f).height(80.dp)
                        .background(Color(0xFFF0F2F6)),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BasicTextField(
                            value = rate,
                            onValueChange = { rate = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 23.sp
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                        )

                        Box(
                            modifier = Modifier.padding(start = 10.dp)
                                .width(1.dp).height(50.dp).background(Color.Gray)
                        )
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(start = 20.dp)
                        ) {
                            if (!CalculatorViewModel.calculatorState.openPercentMonth.value) {
                                Text(
                                    CalculatorViewModel.calculatorState.percent.value,
                                    color = Color.Black,
                                    fontSize = 12.sp
                                )
                            } else {
                                Text("% Month", color = Color.Black, fontSize = 12.sp,
                                    modifier = Modifier.clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(CalculatorIntents.ChoosingRate("% Month"))
                                    })
                                Text("% Day", color = Color.Black, fontSize = 12.sp,
                                    modifier = Modifier.clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(CalculatorIntents.ChoosingRate("% Day"))
                                    })
                                Text("% Year", color = Color.Black, fontSize = 12.sp,
                                    modifier = Modifier.clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(CalculatorIntents.ChoosingRate("% Year"))
                                    })
                            }
                            Image(
                                painter = painterResource(Res.drawable.open_button),
                                contentDescription = null,
                                modifier = Modifier.size(10.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    vm.processIntent(CalculatorIntents.OpenPercentMonth)
                                }
                            )
                        }
                    }
                }
            }
        }
        if (CalculatorViewModel.calculatorState.toast.value) {
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
                CalculatorViewModel.calculatorState.toast.value = false
            }

        }
        Box(
            modifier = Modifier
                .padding(bottom = 10.dp)
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
                "Fill in the fields", fontSize = 15.sp,
                color = Color.Black, textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(Res.drawable.next_button),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { vm.processIntent(CalculatorIntents.Next(sum,term,rate))}
        )
    }
}