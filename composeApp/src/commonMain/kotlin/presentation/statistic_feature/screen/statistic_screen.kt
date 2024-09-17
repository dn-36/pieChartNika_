package org.example.project.presentation.statistic_feature.screen

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
import androidx.compose.foundation.layout.width
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
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.menu_feature.viewmodel.MenuIntents
import org.example.project.presentation.statistic_feature.model.Diagram
import org.example.project.presentation.statistic_feature.model.MoneyBox
import org.example.project.presentation.statistic_feature.model.Transactions
import org.example.project.presentation.statistic_feature.viewmodel.StatisticIntents
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.clicked_statisric
import room_cmp.composeapp.generated.resources.home_button
import room_cmp.composeapp.generated.resources.plus_transaction
import room_cmp.composeapp.generated.resources.profile
import room_cmp.composeapp.generated.resources.wallet
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.green_arrow_back

object StatisticScreen: Screen {
    var vm = StatisticViewModel(StaticDate)
    @Composable
    override fun Content(){
        vm.processIntent(StatisticIntents.SetDiagram)
        vm.processIntent(StatisticIntents.SetTransactions)
        Box(modifier = Modifier.fillMaxSize()) {
            Column() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15f)
                        .background(Color(0xFF027B5B))
                ) {
                    Text(
                        "Statistic",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 20.dp).align(Alignment.TopCenter)
                    )
                    Row(modifier = Modifier.fillMaxWidth(0.9f)
                        .padding(bottom = 15.dp).align(Alignment.BottomCenter)
                        , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Diagram", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(StatisticViewModel.statisticState.diagram.value)
                                .padding(top = 5.dp).width(70.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(StatisticIntents.Diagram) })
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "MoneyBox", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(StatisticViewModel.statisticState.moneyBox.value)
                                .padding(top = 5.dp).width(80.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(StatisticIntents.MoneyBox) })
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Transaction", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(StatisticViewModel.statisticState.transactions.value)
                                .padding(top = 5.dp).width(80.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(StatisticIntents.Transaction) })
                        }
                    }
                }
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.85f)
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally
                        , modifier = Modifier.align(Alignment.Center)
                            .fillMaxHeight(0.9f), verticalArrangement = Arrangement.SpaceBetween) {
                        Row(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.green_arrow_back),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    vm.processIntent(StatisticIntents.MinusIndexMonth)
                                }
                            )
                            Text(
                                StatisticViewModel.statisticState.listMonths[StatisticViewModel.statisticState.index.value],
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(Res.drawable.green_arrow_back),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp).graphicsLayer(rotationZ = 180f)
                                    .clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }) {
                                        vm.processIntent(StatisticIntents.PlusIndexMonth)
                                    }
                            )
                        }
                        if (StatisticViewModel.statisticState.diagram.value == 1F) {
                            Diagram()
                        } else if (StatisticViewModel.statisticState.moneyBox.value == 1F) {
                            MoneyBox()
                        } else if (StatisticViewModel.statisticState.transactions.value == 1F) {
                            Transactions()
                        }
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFF027B5B))
                    , contentAlignment = Alignment.Center){
                    Row (modifier = Modifier.fillMaxWidth(0.9f)
                        , horizontalArrangement = Arrangement.SpaceBetween){
                        Image(
                            painter = painterResource(Res.drawable.home_button),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                MenuScreen.vm.processIntent(MenuIntents.Home)
                            }
                        )
                        Image(
                            painter = painterResource(Res.drawable.clicked_statisric),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Image(painter = painterResource(Res.drawable.plus_transaction), contentDescription = null,
                            modifier = Modifier.size(40.dp)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    MenuScreen.vm.processIntent(MenuIntents.AddTransaction)
                                })
                        Image(
                            painter = painterResource(Res.drawable.wallet),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                MenuScreen.vm.processIntent(MenuIntents.Wallets)
                            }
                        )
                        Image(
                            painter = painterResource(Res.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                MenuScreen.vm.processIntent(MenuIntents.Profile)
                            }
                        )
                    }
                }

            }

        }
    }
}

