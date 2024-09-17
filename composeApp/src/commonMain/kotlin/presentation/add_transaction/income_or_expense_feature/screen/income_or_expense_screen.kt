package org.example.project.presentation.add_transaction.income_or_expense_feature.screen

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
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.IncomeOrExpenseIntents
import org.example.project.presentation.add_transaction.income_or_expense_feature.viewmodel.IncomeOrExpenseViewModel
import org.jetbrains.compose.resources.painterResource

import room_cmp.composeapp.generated.resources.gray_arrow
import room_cmp.composeapp.generated.resources.green_arrow
import room_cmp.composeapp.generated.resources.next_button
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button

object IncomeOrExpenseScreen: Screen {
    val vm = IncomeOrExpenseViewModel(StaticDate)
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
                            { vm.processIntent(IncomeOrExpenseIntents.Back)}
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
                            Text("Category", fontSize = 15.sp, color = Color.DarkGray)
                         Row(modifier = Modifier.padding(top = 30.dp).fillMaxWidth(0.7f),
                             horizontalArrangement = Arrangement.SpaceBetween) {
                             Column {
                                 Box() {
                                     Image(
                                         painter = painterResource(Res.drawable.gray_arrow),
                                         contentDescription = null,
                                         modifier = Modifier.height(160.dp).width(90.dp)
                                             .graphicsLayer(rotationZ = 180f)
                                             .zIndex(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayExpense.value)
                                             .alpha(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayExpense.value)
                                             .clickable(
                                                 indication = null, // Отключение эффекта затемнения
                                                 interactionSource = remember { MutableInteractionSource() })
                                             { vm.processIntent(IncomeOrExpenseIntents.ChoosingExpense) })

                                     Image(
                                         painter = painterResource(Res.drawable.green_arrow),
                                         contentDescription = null,
                                         modifier = Modifier.height(160.dp).width(90.dp)
                                             .zIndex(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenExpense.value)
                                             .alpha(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenExpense.value)
                                             .clickable(
                                                 indication = null, // Отключение эффекта затемнения
                                                 interactionSource = remember { MutableInteractionSource() })
                                             { vm.processIntent(IncomeOrExpenseIntents.ChoosingExpense) }
                                     )
                                 }
                                 Text("Expense", color = Color.Black, fontSize = 20.sp
                                 , modifier = Modifier.padding(top = 10.dp))
                             }
                                 Column {
                                 Box {
                                     Image(painter = painterResource(Res.drawable.gray_arrow),
                                         contentDescription = null,
                                         modifier = Modifier.height(160.dp).width(90.dp)
                                             .zIndex(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayIncome.value)
                                             .alpha(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGrayIncome.value)
                                             .clickable(
                                                 indication = null, // Отключение эффекта затемнения
                                                 interactionSource = remember { MutableInteractionSource() })
                                             { vm.processIntent(IncomeOrExpenseIntents.ChoosingIncome) })
                                     Image(painter = painterResource(Res.drawable.green_arrow),
                                         contentDescription = null,
                                         modifier = Modifier.height(160.dp).width(90.dp)
                                             .graphicsLayer(rotationZ = 180f)
                                             .zIndex(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenIncome.value)
                                             .alpha(IncomeOrExpenseViewModel.incomeOrExpenseState.alphaGreenIncome.value)
                                             .clickable(
                                                 indication = null, // Отключение эффекта затемнения
                                                 interactionSource = remember { MutableInteractionSource() })
                                             { vm.processIntent(IncomeOrExpenseIntents.ChoosingIncome) })
                                 }
                                 Text("Income", color = Color.Black, fontSize = 20.sp
                                     , modifier = Modifier.padding(top = 10.dp))
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
                                { vm.processIntent(IncomeOrExpenseIntents.Next)})
                    }
                }
            }
        }
    }
}