package org.example.project.presentation.statistic_feature.model

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.statistic_feature.screen.StatisticScreen.vm
import org.example.project.presentation.statistic_feature.viewmodel.StatisticIntents
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.green_arrow_back
import room_cmp.composeapp.generated.resources.income_arrow_blue
import room_cmp.composeapp.generated.resources.income_arrow_orange

@Composable
fun Diagram(){
    val colors = listOf(Color(0xFF027B5B),Color(0xFFF8DB1C))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.size(30.dp).background(Color(0xFF027B5B)))
            Text("Income", color = Color.Black, fontSize = 20.sp)
            Box(modifier = Modifier.size(30.dp).background(Color(0xFFF8DB1C)))
            Text("Expense", color = Color.Black, fontSize = 20.sp)
        }
        Row(
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .height(210.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("2500", color = Color.Black, fontSize = 10.sp)
                Text("2000", color = Color.Black, fontSize = 10.sp)
                Text("1000", color = Color.Black, fontSize = 10.sp)
                Text("500", color = Color.Black, fontSize = 10.sp)
                Text("0", color = Color.Black, fontSize = 10.sp)
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(0.95f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                itemsIndexed(
                    listOf(
                        "1", "4", "7", "11", "14", "17",
                        "20", "23", "26", "29"
                    )
                ) { index, item ->
                    Column(
                        modifier = Modifier
                            .height(230.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(25.dp))
                                .background(Color(0xFF027B5B))
                                .height(StatisticViewModel.statisticState.listHeight[index].first.dp)
                                .width(10.dp).clip(
                                    RoundedCornerShape(25.dp)
                                )
                        )
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(25.dp))
                                .background(Color(0xFFF8DB1C))
                                .height(StatisticViewModel.statisticState.listHeight[index].second.dp)
                                .width(10.dp)
                        )
                        Text(item, color = Color.Black, fontSize = 10.sp)
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Image(
                    painter = painterResource(Res.drawable.income_arrow_blue),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Column {
                    Text(
                        "  ${StatisticViewModel.statisticState.incomeSum.value}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text("  Income", color = Color.Black, fontSize = 10.sp)
                }
            }
            Row() {
                Image(
                    painter = painterResource(Res.drawable.income_arrow_orange),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Column {
                    Text(
                        "  ${StatisticViewModel.statisticState.expenseSum.value}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text("  Expense", color = Color.Black, fontSize = 10.sp)
                }
            }
        }
        Canvas(modifier = Modifier.size(100.dp)) {
            // Угол начала первого сектора
            var startAngle = 0f
            listOf(
                StatisticViewModel.statisticState.percentIncome.value,
                StatisticViewModel.statisticState.percentExpense.value
            ).forEachIndexed { index, proportion ->
                // Рассчитываем угол сектора в градусах (360 градусов * доля)
                val sweepAngle = proportion * 360
                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true, // Если true, то рисует сектор с центром
                    size = Size(size.width, size.height)
                )

                // Обновляем угол начала для следующего сектора
                startAngle += sweepAngle
            }
    }
    }