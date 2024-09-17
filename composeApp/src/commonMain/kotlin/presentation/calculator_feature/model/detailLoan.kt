package org.example.project.presentation.calculator_feature.model

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.presentation.calculator_feature.screen.CalculatorScreen.vm
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorIntents
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.done_button

@Composable
fun DetailLoan(){
    vm.processIntent(CalculatorIntents.SetDetailLoan)
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 80.dp)
                .align(Alignment.TopCenter).fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Monthly\npayment\namount", color = Color.Black,fontWeight = FontWeight.Bold
                , fontSize = 25.sp)
                Text("${CalculatorViewModel.calculatorState.monthlyPayment.value}", color = Color.Black, fontSize = 25.sp)
            }
            Row(modifier = Modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Overpayment of\ninterest on\nloan:", color = Color.Black,fontWeight = FontWeight.Bold
                    , fontSize = 25.sp)
                Text("${CalculatorViewModel.calculatorState.overpayment.value}", color = Color.Black, fontSize = 25.sp)
            }
            Row(modifier = Modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Total\noverpayment\nfor the entire\nperiod:", color = Color.Black,fontWeight = FontWeight.Bold
                    , fontSize = 25.sp)
                Text("${CalculatorViewModel.calculatorState.totalOverpayment.value}", color = Color.Black, fontSize = 25.sp)
            }
            Row(modifier = Modifier.fillMaxWidth(0.9f), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Total loan cost,\nper annum:", color = Color.Black,fontWeight = FontWeight.Bold
                    , fontSize = 25.sp)
                Text("${CalculatorViewModel.calculatorState.totalRate.value}%", color = Color.Black, fontSize = 25.sp)
            }
        }
        Image(
            painter = painterResource(Res.drawable.done_button),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                {vm.processIntent(CalculatorIntents.Done) }
        )
    }
}