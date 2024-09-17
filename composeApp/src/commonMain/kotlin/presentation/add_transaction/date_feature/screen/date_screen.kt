package org.example.project.presentation.add_transaction.date_feature.screen

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryIntents
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryViewModel
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateIntents
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.gray_arrow
import room_cmp.composeapp.generated.resources.green_arrow_back
import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button

object DateScreen: Screen {
    val vm = DateViewModel(StaticDate)
    @Composable
    override fun Content() {
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
                            { vm.processIntent(DateIntents.Back)}
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
                            Text("Date", fontSize = 15.sp, color = Color.DarkGray)
                            Row(modifier = Modifier.padding(top = 40.dp)
                                .fillMaxWidth(0.9f)
                                .height(160.dp)
                            , horizontalArrangement = Arrangement.SpaceBetween) {
                                Box() {
                                    Row(modifier = Modifier.padding(top = 20.dp)) {
                                        Text(
                                            "${DateViewModel.dateState.textMonth.value}  ", color = Color.Black,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold
                                            , modifier = Modifier.alpha(DateViewModel.dateState.alphaTextMonth.value)
                                        )
                                        Image(
                                            painter = painterResource(Res.drawable.green_arrow_back),
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp)
                                                .graphicsLayer(rotationZ = DateViewModel.dateState.rotateMonth.value)
                                                .clickable(
                                                    indication = null, // Отключение эффекта затемнения
                                                    interactionSource = remember { MutableInteractionSource() })
                                                { vm.processIntent(DateIntents.OpenMonth) }
                                        )
                                    }
                                    LazyColumn(modifier = Modifier
                                        .alpha(DateViewModel.dateState.alphaMonth.value)) {
                                        itemsIndexed(
                                            listOf(
                                                "September", "October",
                                                "November", "December",
                                                "January", "February",
                                                "March", "April", "May",
                                                "June", "July", "August"
                                            )
                                        ) { indexes, item ->

                                            Text(
                                                "${item}",
                                                color = Color.Black,
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(top = 20.dp)
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() })
                                                    { vm.processIntent(DateIntents.ChoosingMonth(item)) }
                                            )
                                        }
                                    }
                                }
                                Box() {
                                    Row(modifier = Modifier.padding(top = 20.dp)) {
                                        Text(
                                            "${DateViewModel.dateState.textDay.value}  ", color = Color.Black,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold
                                            , modifier = Modifier.alpha(DateViewModel.dateState.alphaTextDay.value)
                                        )
                                        Image(
                                            painter = painterResource(Res.drawable.green_arrow_back),
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp)
                                                .graphicsLayer(rotationZ = DateViewModel.dateState.rotateDay.value)
                                                .clickable(
                                                    indication = null, // Отключение эффекта затемнения
                                                    interactionSource = remember { MutableInteractionSource() })
                                                { vm.processIntent(DateIntents.OpenDay) }
                                        )
                                    }
                                    LazyColumn(modifier = Modifier
                                        .alpha(DateViewModel.dateState.alphaDay.value)) {
                                        itemsIndexed(
                                            listOf(
                                                "1", "2", "3", "4", "5", "6",
                                                "7", "8", "9", "10", "11", "12",
                                                "13", "14", "15", "16", "17", "18", "19",
                                                "20", "21", "22", "23", "24", "25", "26", "27",
                                                "28", "29", "30", "31"
                                            )
                                        ) { indexes, item ->

                                            Text(
                                                "${item}",
                                                color = Color.Black,
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(top = 20.dp)
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() })
                                                    { vm.processIntent(DateIntents.ChoosingDay(item)) }
                                            )
                                        }
                                    }
                                }
                                Box() {
                                    Row(modifier = Modifier.padding(top = 20.dp)) {
                                        Text(
                                            "${DateViewModel.dateState.textYear.value}  ", color = Color.Black,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold
                                            , modifier = Modifier.alpha(DateViewModel.dateState.alphaTextYear.value)
                                        )
                                    }
                                    LazyColumn(modifier = Modifier
                                        .alpha(DateViewModel.dateState.alphaYear.value)) {
                                        itemsIndexed(
                                            listOf("2024")
                                        ) { indexes, item ->

                                            Text(
                                                "${item}",
                                                color = Color.Black,
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(top = 20.dp)
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() })
                                                    { vm.processIntent(DateIntents.ChoosingYear(item)) }
                                            )
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
                                { vm.processIntent(DateIntents.Next) })
                    }
                }
            }
        }
    }
}