package org.example.project.presentation.registerAndStart.filling_name_feature.screen

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.FillingNameIntents
import org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.FillingNameViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.next_button

object FillingNameScreen: Screen {
    var vm = FillingNameViewModel(StaticDate)
    @Composable
    override fun Content(){
        val isVisible by remember { mutableStateOf(Animatable(0f)) }

        var name by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .background(Color(0xFF027B5B)), contentAlignment = Alignment.Center
                ) {
                    Text("Write your name", color = Color.White, fontSize = 30.sp
                        , fontWeight = FontWeight.Bold)
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                    , horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(0.7f).fillMaxHeight(0.1f)
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

                        Image(
                            painter = painterResource(Res.drawable.next_button),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(FillingNameIntents.Next(name)) }
                        )
                    }
                    if(FillingNameViewModel.fillingNameState.toast.value) {
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
                            FillingNameViewModel.fillingNameState.toast.value = false
                        }

                    }
                    Box(modifier = Modifier
                        .padding(bottom = 50.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .alpha(isVisible.value)
                        .align(Alignment.BottomCenter)
                        .background(Color.White)
                        .width(250.dp).height(50.dp)
                        .border(width = 2.dp,
                            color = Color(0xFF027B5B),
                            shape = RoundedCornerShape(15.dp))
                        ,
                        contentAlignment = Alignment.Center) {
                        Text("Fill in the field", fontSize = 15.sp,
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}