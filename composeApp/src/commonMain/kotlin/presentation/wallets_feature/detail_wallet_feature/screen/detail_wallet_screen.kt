package org.example.project.presentation.wallets_feature.detail_wallet_feature.screen

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
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.date_feature.screen.DateScreen
import org.example.project.presentation.add_transaction.date_feature.viewmodel.DateIntents
import org.example.project.presentation.calculator_feature.screen.CalculatorScreen
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorIntents
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.wallets_feature.add_new_wallet_feature.viewmodel.AddNewWalletViewModel
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletIntents
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsIntents
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.car
import room_cmp.composeapp.generated.resources.done_button
import room_cmp.composeapp.generated.resources.eight_currency
import room_cmp.composeapp.generated.resources.fife_currency
import room_cmp.composeapp.generated.resources.four_currency
import room_cmp.composeapp.generated.resources.income_arrow_blue
import room_cmp.composeapp.generated.resources.income_arrow_orange
import room_cmp.composeapp.generated.resources.nine_currency
import room_cmp.composeapp.generated.resources.one_currency
import room_cmp.composeapp.generated.resources.seven_currency
import room_cmp.composeapp.generated.resources.six_currency
import room_cmp.composeapp.generated.resources.three_currency
import room_cmp.composeapp.generated.resources.two_currency


object DetailWalletsScreen: Screen {
    var vm = DetailWalletViewModel(StaticDate)
    @Composable
    override fun Content(){
        vm.processIntent(DetailWalletIntents.SetScreen)
        var sum by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.13f)
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
                            { vm.processIntent(DetailWalletIntents.Back)}
                    )
                    Text(
                        DetailWalletViewModel.detailWalletState.nameWallet.value,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.align(Alignment.Center)
                        .fillMaxHeight(0.9f).fillMaxWidth()
                        , contentAlignment = Alignment.TopCenter) {

                        Column(modifier = Modifier.fillMaxSize(), verticalArrangement =
                        Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .height(90.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .border(1.dp, Color(0xFF027B5B), RoundedCornerShape(15.dp))
                            ) {
                                Row(
                                    modifier = Modifier.align(Alignment.Center),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        DetailWalletViewModel(StaticDate).date.listWallets
                                            [DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].sum, fontSize = 40.sp, color = Color(0xFF027B5B),
                                        fontWeight = FontWeight.Bold
                                    )
                                    val img = when(DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].currency){
                                        "0" -> {Res.drawable.one_currency}
                                        "1" -> {Res.drawable.two_currency}
                                        "2" -> {Res.drawable.three_currency}
                                        "3" -> {Res.drawable.four_currency}
                                        "4" -> {Res.drawable.fife_currency}
                                        "5" -> {Res.drawable.six_currency}
                                        "6" -> {Res.drawable.seven_currency}
                                        "7" -> {Res.drawable.eight_currency}
                                        else -> {Res.drawable.nine_currency}
                                    }
                                    Image(
                                        painter = painterResource(img),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }
                            Row(modifier = Modifier.padding(top = 10.dp)
                                .fillMaxWidth(0.9f)
                            , horizontalArrangement = Arrangement.SpaceBetween) {
                                Box(modifier = Modifier.clickable(indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(DetailWalletIntents.Edit)
                                }.width(90.dp).height(20.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .border(1.dp,Color(0xFF027B5B), RoundedCornerShape(2.dp))){
                                    Text("Edit", fontSize = 15.sp, color = Color(0xFF027B5B)
                                        , fontWeight = FontWeight.Bold
                                        , modifier = Modifier.align(Alignment.Center))
                                }
                                Box(modifier = Modifier.clickable(indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                 vm.processIntent(DetailWalletIntents.Add) }
                                        .width(90.dp).height(20.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .border(1.dp,Color(0xFF027B5B), RoundedCornerShape(2.dp))){
                                    Text("Add", fontSize = 15.sp, color = Color(0xFF027B5B)
                                        , fontWeight = FontWeight.Bold
                                        , modifier = Modifier.align(Alignment.Center))
                                }
                                Box(modifier = Modifier.clickable(indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(DetailWalletIntents.Subtract)
                                }.width(90.dp).height(20.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .border(1.dp,Color(0xFF027B5B), RoundedCornerShape(2.dp))){
                                    Text("Subtract", fontSize = 15.sp, color = Color(0xFF027B5B)
                                        , fontWeight = FontWeight.Bold
                                        , modifier = Modifier.align(Alignment.Center))
                                }
                            }
                            Text("Transactions", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
                            , modifier = Modifier.padding(top = 10.dp))

                            LazyColumn(modifier = Modifier.padding(top = 5.dp)) {
                                itemsIndexed(DetailWalletViewModel.detailWalletState.listTransactions) { index, item ->
                                    Row(modifier = Modifier.padding(top = 10.dp).fillMaxWidth(0.9f)
                                        , horizontalArrangement = Arrangement.SpaceBetween
                                    , verticalAlignment = Alignment.CenterVertically) {
                                        val img = when(item.type){
                                            "Add" -> {Res.drawable.income_arrow_blue}
                                            else -> {Res.drawable.income_arrow_orange}
                                        }
                                        Image(painter = painterResource(img
                                        ), contentDescription = null,
                                            modifier = Modifier.size(30.dp))
                                        Text(item.type, fontSize = 15.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                                        Text(item.date, fontSize = 13.sp, color = Color.Black,)

                                        if(item.type == "Add") {
                                            Text(item.sum, fontSize = 17.sp, color = Color(0xFFF8DB1C))
                                        }
                                        else{
                                            Text(item.sum, fontSize = 17.sp, color = Color(0xFFF81C1C))
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.zIndex(DetailWalletViewModel.detailWalletState.alpha.value)
            .alpha(DetailWalletViewModel.detailWalletState.alpha.value)
            .fillMaxSize()){
            Box(modifier = Modifier.fillMaxSize().alpha(0.8f).background(Color.Black))
            Box(modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.fillMaxHeight(0.3f).align(Alignment.Center)
                , verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(90.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .border(2.dp, Color(0xFF027B5B), RoundedCornerShape(15.dp))
                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.Center),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                DetailWalletViewModel(StaticDate).date.listWallets
                                    [DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].sum,
                                fontSize = 45.sp,
                                color = Color(0xFF027B5B),
                                fontWeight = FontWeight.ExtraBold
                            )
                            val img = when(DetailWalletViewModel(StaticDate).date.listWallets[DetailWalletViewModel(StaticDate).date.indexDetailWallet.value].currency){
                                "0" -> {Res.drawable.one_currency}
                                "1" -> {Res.drawable.two_currency}
                                "2" -> {Res.drawable.three_currency}
                                "3" -> {Res.drawable.four_currency}
                                "4" -> {Res.drawable.fife_currency}
                                "5" -> {Res.drawable.six_currency}
                                "6" -> {Res.drawable.seven_currency}
                                "7" -> {Res.drawable.eight_currency}
                                else -> {Res.drawable.nine_currency}
                            }
                            Image(
                                painter = painterResource(img),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                    Text(DetailWalletViewModel.detailWalletState.textAddOrSubtract.value, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)

                    Box(modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(70.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.White)){
                        Row(modifier = Modifier.fillMaxWidth(0.85f).align(Alignment.Center)
                        , horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically){
                            if(DetailWalletViewModel.detailWalletState.textAddOrSubtract.value == "Top up your balance") {
                                Text(
                                    "+",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                            }
                            else{
                                Text(
                                    "-",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                            }
                            Box(
                                modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                    .fillMaxWidth(0.7f).height(80.dp)
                                    .background(Color.White), contentAlignment = Alignment.Center
                            ) {
                                BasicTextField(
                                    value = sum,
                                    onValueChange = { sum = it },
                                    textStyle = TextStyle(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    ))
                            }
                        }
                    }
                }
                Image(painter = painterResource(Res.drawable.done_button), contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(50.dp)
                        .fillMaxWidth(0.7f)
                        .height(80.dp)
                        .clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        { vm.processIntent(DetailWalletIntents.Done(sum)) })
            }
        }
    }
}