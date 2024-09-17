package org.example.project.presentation.add_transaction.finish_fetaure.screen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.FinishIntents
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.FinishViewModel
import org.example.project.presentation.add_transaction.sum_feature.viewmodel.SumIntents
import org.example.project.presentation.add_transaction.sum_feature.viewmodel.SumViewModel
import org.jetbrains.compose.resources.painterResource

import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.car
import room_cmp.composeapp.generated.resources.finish_button

object FinishScreen: Screen {
    val vm = FinishViewModel(StaticDate)
    @Composable
    override fun Content() {
vm.processIntent(FinishIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Column {

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.25f)
                        .fillMaxWidth()
                        .background(Color(0xFF027B5B))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.7f)
                            .align(Alignment.Center),
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
                            text = "Great!",
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
                            Text("New transaction added", fontSize = 30.sp, color = Color(0xFF027B5B)
                            , fontWeight = FontWeight.Bold)
                            Row(modifier = Modifier
                                .padding(top = 50.dp)
                                .fillMaxWidth(0.9f)
                                , horizontalArrangement = Arrangement.SpaceBetween
                                , verticalAlignment = Alignment.CenterVertically){
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(FinishViewModel.finishState.img.value
                                        ),
                                        contentDescription = null,
                                        modifier = Modifier.size(50.dp)
                                    )
                                    Column {
                                        Text(
                                            text = "   ${FinishViewModel.finishState.transaction.value.category}",
                                            color = Color.Black,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "   ${FinishViewModel.finishState.transaction.value.name}",
                                            color = Color.Black,
                                            fontSize = 15.sp
                                        )
                                    }
                                }
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(text = "${FinishViewModel.finishState.transaction.value.sign}${FinishViewModel.finishState.transaction.value.sum}", color =FinishViewModel.finishState.color.value
                                        , fontSize = 17.sp, fontWeight = FontWeight.Bold)
                                    Text(text = "${FinishViewModel.finishState.transaction.value.month} ${FinishViewModel.finishState.transaction.value.day}, ${FinishViewModel.finishState.transaction.value.year}", color = Color.Black, fontSize = 12.sp)
                                }
                            }
                        }
                        Image(painter = painterResource(Res.drawable.finish_button), contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(FinishIntents.Finish) })
                    }
                }
            }
        }
    }
}