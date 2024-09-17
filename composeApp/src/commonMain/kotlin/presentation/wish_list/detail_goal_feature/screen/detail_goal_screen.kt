package org.example.project.presentation.wish_list.detail_goal_feature.screen

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
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.DetailGoalIntents
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.DetailGoalViewModel
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListIntents
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.WishListViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.add_goals_button
import room_cmp.composeapp.generated.resources.back_button
import room_cmp.composeapp.generated.resources.bank_of_money
import room_cmp.composeapp.generated.resources.delete_goal
import room_cmp.composeapp.generated.resources.no
import room_cmp.composeapp.generated.resources.yes

object DetailGoalScreen: Screen {
    var vm = DetailGoalViewModel(StaticDate)
    @Composable
    override fun Content(){
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
                            { vm.processIntent(DetailGoalIntents.Back) }
                    )
                    Text("WISH LIST",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 20.dp)
                            .align(Alignment.TopCenter))

                        Image(painter = painterResource(Res.drawable.add_goals_button), contentDescription = null,
                            modifier = Modifier .align(Alignment.BottomEnd)
                                .padding(bottom = 10.dp,end = 10.dp).size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(DetailGoalIntents.AddOrDeleteSum)})
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(Res.drawable.delete_goal), contentDescription = null,
                        modifier = Modifier .align(Alignment.TopEnd)
                            .padding(top = 10.dp,end = 10.dp).size(40.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(DetailGoalIntents.DeleteGoal)})

                    Column(modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                        , horizontalAlignment = Alignment.CenterHorizontally) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Image(
                                            painter = painterResource(Res.drawable.bank_of_money),
                                            contentDescription = null,
                                            modifier = Modifier.size(200.dp))
                                        Text(text = DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value].target, fontSize = 28.sp, color = Color(0xFF027B5B)
                                            , fontWeight = FontWeight.Bold)
                                        Text(text = "Total", fontSize = 15.sp, color = Color.Black,
                                            modifier = Modifier.padding(top = 15.dp))
                                        Text(text = "${DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value].already}/${DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value].sum}", fontSize = 45.sp, color = Color(0xFF027B5B)
                                            , fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp))
                                         LinearProgressIndicator(progress = (DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value].already.toFloat()/DetailGoalViewModel(StaticDate).date.listGoals[DetailGoalViewModel(StaticDate).date.goalNow.value].sum),
                                        color = Color(0xFF027B5B),
                                        backgroundColor = Color(0xFFD8D8D8),
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .height(20.dp)
                                            .fillMaxWidth(0.8f)
                                            .clip(RoundedCornerShape(25.dp))
                                    )
                            }
                    }
                }
            }
            Box(modifier = Modifier.zIndex(DetailGoalViewModel.detailGoalState.alphaDelete.value)
                .alpha(DetailGoalViewModel.detailGoalState.alphaDelete.value)) {
                Box(
                    modifier = Modifier.alpha(0.3f).fillMaxSize().background(Color.White)
                )
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column {
                        Box(
                            modifier = Modifier.fillMaxWidth(0.8f)
                                .fillMaxHeight(0.15f).background(Color(0xFF027B5B)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Are you sure you want to delete the Goal?",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.yes),
                                contentDescription = null,
                                modifier = Modifier.height(60.dp).width(150.dp).clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() })
                                    { vm.processIntent(DetailGoalIntents.Yes)}
                            )
                            Image(
                                painter = painterResource(Res.drawable.no),
                                contentDescription = null,
                                modifier = Modifier.height(60.dp).width(150.dp).clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(DetailGoalIntents.No)}
                            )
                        }
                    }
                }
            }
        }
    }
}