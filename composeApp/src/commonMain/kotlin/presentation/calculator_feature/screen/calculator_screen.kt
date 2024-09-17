package org.example.project.presentation.calculator_feature.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.calculator_feature.model.Calculator.Calculate
import org.example.project.presentation.calculator_feature.model.DetailLoan
import org.example.project.presentation.calculator_feature.model.Loan
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorIntents
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteIntents
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteViewModel
import org.example.project.presentation.wish_list.target_feature.screen.TargetScreen.vm
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetIntents
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button


object CalculatorScreen: Screen {
    var vm = CalculatorViewModel(StaticDate)
    @Composable
    override fun Content(){

        Box(modifier = Modifier.fillMaxSize()) {
            Column() {
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
                            { vm.processIntent(CalculatorIntents.Back)}
                    )
                    Text(
                        "CALCULATOR",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 20.dp).align(Alignment.TopCenter)
                    )
                    Row(modifier = Modifier.fillMaxWidth(0.7f)
                        .padding(bottom = 15.dp).align(Alignment.BottomCenter)
                        , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Simple", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(CalculatorViewModel.calculatorState.simple.value)
                                .padding(top = 5.dp).width(70.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(CalculatorIntents.Simple) })
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Loan", color = Color.White, fontSize = 15.sp)
                            Box(modifier = Modifier.alpha(CalculatorViewModel.calculatorState.loan.value)
                                .padding(top = 5.dp).width(60.dp).height(2.dp)
                                .background(Color.White).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(CalculatorIntents.Loan) })
                        }
                    }
                }
                if(CalculatorViewModel.calculatorState.simple.value == 1f){
                    Calculate()
                }
                else if(CalculatorViewModel.calculatorState.loan.value == 1f){
                    Loan()
                }
                if(CalculatorViewModel.calculatorState.detailLoan.value){
                    DetailLoan()
                }
            }

            }
        }
    }

