package org.example.project.presentation.statistic_feature.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.add_transaction.finish_fetaure.viewmodel.FinishViewModel
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.car
import room_cmp.composeapp.generated.resources.card
import room_cmp.composeapp.generated.resources.cup
import room_cmp.composeapp.generated.resources.food
import room_cmp.composeapp.generated.resources.music
import room_cmp.composeapp.generated.resources.people
import room_cmp.composeapp.generated.resources.phone
import room_cmp.composeapp.generated.resources.photoapp
import room_cmp.composeapp.generated.resources.planet
import room_cmp.composeapp.generated.resources.two_yellow_phone
import room_cmp.composeapp.generated.resources.yellow_calendar
import room_cmp.composeapp.generated.resources.yellow_home


@Composable
fun Transactions(){
    Column(modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Top) {
        Text(
            "Transactions", color = Color.Black, fontSize = 23.sp,
            fontWeight = FontWeight.Bold,modifier = Modifier.padding(top = 20.dp)
        )
        LazyColumn {
            itemsIndexed(StatisticViewModel.statisticState.listTransactions) { index, item ->
                Row(
                    modifier = Modifier.padding(top = 10.dp)
                        .fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val img = when(FinishViewModel.finishState.transaction.value.img){
                        "0" -> { Res.drawable.cup}
                        "1" -> { Res.drawable.photoapp}
                        "2" -> { Res.drawable.card}
                        "3" -> { Res.drawable.music}
                        "4" -> { Res.drawable.people}
                        "5" -> { Res.drawable.planet}
                        "6" -> { Res.drawable.yellow_home}
                        "7" -> { Res.drawable.yellow_calendar}
                        "8" -> { Res.drawable.phone}
                        "9" -> { Res.drawable.two_yellow_phone}
                        "10" -> { Res.drawable.food}
                        else -> { Res.drawable.car}
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(img
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
                        val color = when(FinishViewModel.finishState.transaction.value.sign){
                            "-" -> {Color.Red}
                            else -> {Color(0xFFF8DB1C)}
                        }
                        Text(
                            text = "${FinishViewModel.finishState.transaction.value.sign}${FinishViewModel.finishState.transaction.value.sum}",
                            color = color
                            ,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${FinishViewModel.finishState.transaction.value.month} ${FinishViewModel.finishState.transaction.value.day}, ${FinishViewModel.finishState.transaction.value.year}",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}