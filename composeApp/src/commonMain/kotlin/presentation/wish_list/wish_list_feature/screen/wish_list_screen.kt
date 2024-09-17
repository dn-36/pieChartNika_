package org.example.project.presentation.wish_list.wish_list_feature.screen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartIntents
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartViewModel
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListIntents
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.add_goals_button
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.bank_of_money
import room_cmp.composeapp.generated.resources.goal_arrow
import kotlin.math.round

object WishListScreen: Screen {
     var vm = WishListViewModel(StaticDate)
    @Composable
    override fun Content(){
        vm.processIntent(WishListIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
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
                            {vm.processIntent(WishListIntents.Back) }
                    )
                        Text("WISH LIST",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 20.dp)
                                .align(Alignment.TopCenter))
                        Row(modifier = Modifier.fillMaxWidth(0.7f)
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 10.dp,end = 10.dp)
                        , horizontalArrangement = Arrangement.SpaceBetween
                        , verticalAlignment = Alignment.CenterVertically){
                            Text("Add more goals",
                                color = Color.White,
                                fontSize = 20.sp)
                            Image(painter = painterResource(Res.drawable.goal_arrow), contentDescription = null,
                                modifier = Modifier.size(20.dp))
                            Image(painter = painterResource(Res.drawable.add_goals_button), contentDescription = null,
                                modifier = Modifier.size(30.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(WishListIntents.AddNewGoals)})
                        }
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                        , horizontalAlignment = Alignment.CenterHorizontally) {

                        if(WishListViewModel.wishListState.listGoals.size != 0){
                        LazyColumn {
                            itemsIndexed(WishListViewModel.wishListState.listGoals){index,item ->
                                Column(horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(top = 10.dp).clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() })
                                    { vm.processIntent(WishListIntents.DetailGoal(index))}) {
                                    Image(
                                        painter = painterResource(Res.drawable.bank_of_money),
                                        contentDescription = null,
                                        modifier = Modifier.size(150.dp)
                                    )
                                    Text(text = item.target, fontSize = 23.sp, color = Color(0xFF027B5B)
                                    , fontWeight = FontWeight.Bold)


                                    Text(text = "${item.already}/${item.sum}", fontSize = 25.sp, color = Color(0xFFF8DB1C)
                                        , fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp))

                                }
                            }
                        }
                        }
                        else{
                            Text("You don't have any goals yet", color = Color.Black,
                                fontSize = 25.sp)
                        }
                    }
                }
            }
        }
    }
}