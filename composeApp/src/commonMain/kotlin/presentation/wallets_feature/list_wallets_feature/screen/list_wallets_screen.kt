package org.example.project.presentation.wallets_feature.list_wallets_feature.screen

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.menu_feature.viewmodel.MenuIntents
import org.example.project.presentation.wallets_feature.detail_wallet_feature.viewmodel.DetailWalletViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsIntents
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.ListWalletsViewModel
import org.example.project.presentation.wallets_feature.list_wallets_feature.viewmodel.intents.SetListWalletIntent
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.add_goals_button
import room_cmp.composeapp.generated.resources.clicked_wallet
import room_cmp.composeapp.generated.resources.eight_currency
import room_cmp.composeapp.generated.resources.fife_currency
import room_cmp.composeapp.generated.resources.four_currency
import room_cmp.composeapp.generated.resources.home_button
import room_cmp.composeapp.generated.resources.mini_trash
import room_cmp.composeapp.generated.resources.nine_currency
import room_cmp.composeapp.generated.resources.one_currency
import room_cmp.composeapp.generated.resources.plus_transaction
import room_cmp.composeapp.generated.resources.profile
import room_cmp.composeapp.generated.resources.seven_currency
import room_cmp.composeapp.generated.resources.six_currency
import room_cmp.composeapp.generated.resources.statistic
import room_cmp.composeapp.generated.resources.three_currency
import room_cmp.composeapp.generated.resources.two_currency

object ListWalletsScreen: Screen {
    var vm = ListWalletsViewModel(StaticDate)
    @Composable
    override fun Content(){

        val isVisible by remember { mutableStateOf(Animatable(0f)) }

        vm.processIntent(ListWalletsIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.13f)
                        .background(Color(0xFF027B5B))
                ) {
                    Text(
                        "Wallets",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                    Image(painter = painterResource(Res.drawable.add_goals_button), contentDescription = null,
                        modifier = Modifier.padding(end = 20.dp).size(30.dp).align(Alignment.CenterEnd)
                            .clickable(indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                vm.processIntent(ListWalletsIntents.AddNewWallet)
                            })
                }
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.85f)
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.align(Alignment.Center)
                        .fillMaxHeight(0.9f).fillMaxWidth()
                    , contentAlignment = Alignment.TopCenter) {

                        LazyColumn {itemsIndexed(ListWalletsViewModel.listWalletsState.listWallets) { index, item ->
                            Box(modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(0.9f)
                                .height(90.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .border(1.dp,Color(0xFF027B5B), RoundedCornerShape(15.dp))){
                                Row( modifier = Modifier.align(Alignment.Center) .clickable(indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(ListWalletsIntents.DetailWallet(index))
                                }, verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        "${item.sum}", fontSize = 40.sp, color = Color(0xFF027B5B),
                                        fontWeight = FontWeight.Bold)
                                    val img = when(item.currency){
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
                                    Image(painter = painterResource(img), contentDescription = null,
                                        modifier = Modifier.size(30.dp))
                                }
                                Image(painter = painterResource(Res.drawable.mini_trash), contentDescription = null,
                                    modifier = Modifier.align(Alignment.TopEnd).padding(top = 5.dp,end = 5.dp)
                                        .size(10.dp).clickable(indication = null, // Отключение эффекта затемнения
                                            interactionSource = remember { MutableInteractionSource() }){
                                            vm.processIntent(ListWalletsIntents.DeleteWallet(index))
                                        })
                                Text(item.name, fontSize = 15.sp, color = Color(0xFF027B5B)
                                    , modifier = Modifier.align(Alignment.BottomStart)
                                        .padding(bottom = 10.dp,start = 10.dp))
                                Box(modifier = Modifier.clickable(indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    vm.processIntent(ListWalletsIntents.ChoosingMainWallet(index))
                                }.align(Alignment.BottomEnd)
                                    .padding(bottom = 5.dp,end = 5.dp).width(80.dp).height(30.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .border(1.dp,//Color(0xFF027B5B)
                                            ListWalletsViewModel.listWalletsState.listColor[index]
                                        , RoundedCornerShape(10.dp))){
                                    Text("Main", fontSize = 15.sp, color = //Color(0xFF027B5B)
                                    ListWalletsViewModel.listWalletsState.listColor[index]
                                        , fontWeight = FontWeight.Bold
                                        , modifier = Modifier.align(Alignment.Center))
                                }
                            }
                        }
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
                            painter = painterResource(Res.drawable.statistic),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                MenuScreen.vm.processIntent(MenuIntents.Statistic)
                            }
                        )
                        Image(painter = painterResource(Res.drawable.plus_transaction), contentDescription = null,
                            modifier = Modifier.size(40.dp)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    MenuScreen.vm.processIntent(MenuIntents.AddTransaction)
                                })
                        Image(
                            painter = painterResource(Res.drawable.clicked_wallet),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
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
            if (ListWalletsViewModel.listWalletsState.toast.value) {
                LaunchedEffect(key1 = true) {
                    delay(0)
                    isVisible.animateTo(
                        targetValue = 1f
                    )

                    delay(800) // видимость на 1 секунду
                    isVisible.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = LinearEasing
                        ) // плавное исчезновение

                    )
                    ListWalletsViewModel.listWalletsState.toast.value = false
                }

            }
            Box(
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .alpha(isVisible.value)
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .width(250.dp).height(50.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF027B5B),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "You cannot delete the last wallet", fontSize = 15.sp,
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
    }
}