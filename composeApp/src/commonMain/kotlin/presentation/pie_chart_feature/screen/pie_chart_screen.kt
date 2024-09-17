package org.example.project.presentation.pie_chart_feature.screen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartIntents
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartViewModel
import org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel.FillingNameViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.ok_button

object PieChartScreen: Screen {
    var vm = PieChartViewModel(StaticDate)
    @Composable
    override fun Content(){
        val colors = listOf(Color(0xFF027B5B),Color(0xFFF8DB1C))
        vm.processIntent(PieChartIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15f)
                        .background(Color(0xFF027B5B))
                ) {
                    Text("PIE CHART", color = Color.White, fontSize = 30.sp
                        , fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Center))
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                        , horizontalAlignment = Alignment.CenterHorizontally) {

                        if(PieChartViewModel.pieChartState.alphaText.value != 1F){
                        Canvas(modifier = Modifier.size(250.dp)) {
                            // Угол начала первого сектора
                            var startAngle = 0f
                            listOf(PieChartViewModel.pieChartState.percentIncome.value/100,
                                PieChartViewModel.pieChartState.percentExpense.value/100).forEachIndexed { index, proportion ->
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

                        Column(modifier = Modifier.height(120.dp)
                        , verticalArrangement = Arrangement.SpaceBetween) {
                            Row(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(modifier = Modifier.size(40.dp).background(Color(0xFF027B5B)))
                                Text("Income ${(PieChartViewModel.pieChartState.percentIncome.value).toInt()}%", color = Color.Black, fontSize = 20.sp)
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(modifier = Modifier.size(40.dp).background(Color(0xFFF8DB1C)))
                                Text("Expense ${(PieChartViewModel.pieChartState.percentExpense.value).toInt()}%", color = Color.Black, fontSize = 20.sp)
                            }
                        }
}
                        else{
                        Text("There is no data for calculation", color = Color.Black,
                            fontSize = 25.sp)
                        }
                        Image(
                            painter = painterResource(Res.drawable.ok_button),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(PieChartIntents.Ok)}
                        )
                    }
                }
            }
        }
    }
}
