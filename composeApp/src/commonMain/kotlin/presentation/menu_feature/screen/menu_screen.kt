package org.example.project.presentation.menu_feature.screen

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.menu_feature.viewmodel.MenuIntents
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.menu_feature.utils.setTransaction
import org.example.project.presentation.menu_feature.utils.setTransactionList
import org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.AddWalletViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.add_goals_button
import room_cmp.composeapp.generated.resources.balance
import room_cmp.composeapp.generated.resources.calculator
import room_cmp.composeapp.generated.resources.clicked_home
import room_cmp.composeapp.generated.resources.pie_chart
import room_cmp.composeapp.generated.resources.plus_transaction
import room_cmp.composeapp.generated.resources.profile
import room_cmp.composeapp.generated.resources.statistic
import room_cmp.composeapp.generated.resources.wallet
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.car
import room_cmp.composeapp.generated.resources.card
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.cup
import room_cmp.composeapp.generated.resources.eight_currency
import room_cmp.composeapp.generated.resources.fife_currency
import room_cmp.composeapp.generated.resources.food
import room_cmp.composeapp.generated.resources.four_currency
import room_cmp.composeapp.generated.resources.music
import room_cmp.composeapp.generated.resources.nine_currency
import room_cmp.composeapp.generated.resources.one_currency
import room_cmp.composeapp.generated.resources.people
import room_cmp.composeapp.generated.resources.phone
import room_cmp.composeapp.generated.resources.photoapp
import room_cmp.composeapp.generated.resources.planet
import room_cmp.composeapp.generated.resources.seven_currency
import room_cmp.composeapp.generated.resources.six_currency
import room_cmp.composeapp.generated.resources.three_currency
import room_cmp.composeapp.generated.resources.two_currency
import room_cmp.composeapp.generated.resources.two_yellow_phone
import room_cmp.composeapp.generated.resources.yellow_calendar
import room_cmp.composeapp.generated.resources.yellow_home

object MenuScreen:Screen{
    val vm = MenuViewModel(StaticDate)
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .fillMaxWidth()
                        .background(Color(0xFF027B5B))
                ) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 20.dp, start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if(MenuViewModel(StaticDate).date.photo == null){
                            Image(
                                painter = painterResource(Res.drawable.circle),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )}
                        else{
                            Image(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape),
                                bitmap = MenuViewModel(StaticDate).date.photo!!,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }

                        Column {
                            Text(text = "   Hello", color = Color.White, fontSize = 10.sp)
                            Text(text = "   ${MenuViewModel(StaticDate).date.name}", color = Color.White, fontSize = 12.sp)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.75f)
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.SpaceAround
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
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color.White)
                                        .fillMaxWidth(0.8f)
                                        .fillMaxHeight(0.4f)
                                ) {
                                    Row(modifier = Modifier.align(Alignment.Center)
                                    , verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = MenuViewModel(StaticDate).date.listWallets[MenuViewModel(StaticDate).date.indexWalletNow.value].sum,
                                            color = Color(0xFF027B5B),
                                            fontSize = 35.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        val img = when(MenuViewModel(StaticDate).date.listWallets[MenuViewModel(StaticDate).date.indexWalletNow.value].currency){
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
                                        Image(painter = painterResource(img)
                                        , contentDescription = null, modifier = Modifier.size(25.dp))
                                    }
                                    Image(
                                        painter = painterResource(Res.drawable.add_goals_button),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(end = 5.dp,bottom = 5.dp)
                                            .size(20.dp)
                                            .align(Alignment.BottomEnd).clickable(
                                                indication = null, // Отключение эффекта затемнения
                                                interactionSource = remember { MutableInteractionSource() }){
                                                vm.processIntent(MenuIntents.AddMoney)
                                            }
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.balance),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.WishList)
                                }
                            )
                            Image(
                                painter = painterResource(Res.drawable.pie_chart),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.PieChart) }
                            )
                            Image(
                                painter = painterResource(Res.drawable.calculator),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.Calculator) }
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = "Income", color = Color.White, fontSize = 20.sp)
                                Box(modifier = Modifier.alpha(MenuViewModel.menuState.alphaIncome.value)
                                    .padding(top = 5.dp).width(70.dp).height(2.dp)
                                    .background(Color.White).clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }){
                                        vm.processIntent(MenuIntents.Income)
                                    })
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Expense", color = Color.White, fontSize = 20.sp)
                                Box(modifier = Modifier.alpha(MenuViewModel.menuState.alphaExpense.value)
                                    .padding(top = 5.dp).width(80.dp).height(2.dp)
                                    .background(Color.White).clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }){
                                        vm.processIntent(MenuIntents.Expense)
                                    })
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .fillMaxWidth()
                        .background(Color.White)
                    , contentAlignment = Alignment.BottomCenter
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally
                        , modifier = Modifier.fillMaxHeight(0.95f)) {
                        LazyRow (modifier = Modifier.fillMaxWidth(0.85f)
                            , horizontalArrangement = Arrangement.SpaceBetween) {
                            itemsIndexed(listOf("Day","Week","Month","Year")){ index,item ->
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(15.dp))
                                        .background(MenuViewModel.menuState.colorCalendar[index])
                                        .width(80.dp).height(30.dp)
                                        .clickable(
                                            indication = null, // Отключение эффекта затемнения
                                            interactionSource = remember { MutableInteractionSource() }){
                                            vm.processIntent(MenuIntents.ChoosingCalendar(index))
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = item,
                                        color = Color.Black,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }


                        if(setTransactionList().size != 0) {
                            LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
                                itemsIndexed(setTransaction()) { index, item ->
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 10.dp)
                                            .fillMaxWidth(0.9f),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        val img = when(item.img){
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
                                                painter = painterResource(img),
                                                contentDescription = null,
                                                modifier = Modifier.size(50.dp)
                                            )
                                            Column {
                                                Text(
                                                    text = "   ${item.category}",
                                                    color = Color.Black,
                                                    fontSize = 15.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(
                                                    text = "   ${item.name}",
                                                    color = Color.Black,
                                                    fontSize = 15.sp
                                                )
                                            }
                                        }
                                        Column(horizontalAlignment = Alignment.End) {
                                            val color = when(item.sign){
                                                "-" -> {Color.Red}
                                                else -> {Color(0xFFF8DB1C)}
                                            }
                                            Text(
                                                text = "${item.sign}${item.sum}",
                                                color = color
                                                ,
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = "${item.month} ${item.day}, ${item.year}",
                                                color = Color.Black,
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            Text("There are no transactions here yet", color = Color.Black
                            , fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(top = 30.dp))
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
                                painter = painterResource(Res.drawable.clicked_home),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.Home)
                                }
                            )
                            Image(
                                painter = painterResource(Res.drawable.statistic),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp) .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.Statistic)
                                }
                            )
                            Image(painter = painterResource(Res.drawable.plus_transaction), contentDescription = null,
                                modifier = Modifier.size(40.dp)
                                    .clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() }){
                                        vm.processIntent(MenuIntents.AddTransaction)
                                    })
                            Image(
                                painter = painterResource(Res.drawable.wallet),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.Wallets)
                                }
                            )
                            Image(
                                painter = painterResource(Res.drawable.profile),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp) .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(MenuIntents.Profile)
                                }
                            )
                    }
                }
            }

        }
    }

}