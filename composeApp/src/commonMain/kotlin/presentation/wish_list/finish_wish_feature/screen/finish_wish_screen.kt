package org.example.project.presentation.wish_list.finish_wish_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.AmountSavingsIntents
import org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.AmountSavingsViewModel
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishIntents
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.done_button

object FinishWishScreen: Screen {
    var vm = FinishWishViewModel(StaticDate)

    @Composable
    override fun Content() {
        vm.processIntent(FinishWishIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.15f)
                        .background(Color(0xFF027B5B))
                ) {
                    Text(
                        "WISH LIST",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 20.dp).align(Alignment.TopCenter)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text("Total", fontSize = 15.sp, color = Color.Black)

                         Text("${FinishWishViewModel.finishWishState.newGoal.value.target} costs ${FinishWishViewModel.finishWishState.newGoal.value.sum} left to save ${FinishWishViewModel.finishWishState.newGoal.value.already} \n We advise you to save money every week"
                             , fontSize = 20.sp, color = Color.Black, modifier = Modifier.fillMaxWidth(0.9f))

                        Image(
                            painter = painterResource(Res.drawable.done_button),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.17f)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() })
                                { vm.processIntent(FinishWishIntents.Done)}
                        )
                    }

                }
            }
        }
    }
}