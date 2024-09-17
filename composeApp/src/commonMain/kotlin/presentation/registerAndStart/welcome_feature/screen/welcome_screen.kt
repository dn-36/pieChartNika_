package org.example.project.presentation.registerAndStart.welcome_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.welcome_feature.viewmodel.WelcomeIntents
import org.example.project.presentation.registerAndStart.welcome_feature.viewmodel.WelcomeViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.start_button
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.welcome_text

object WelcomeScreen: Screen {
    var vm = WelcomeViewModel(StaticDate)
    @Composable
    override fun Content(){
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .background(Color(0xFF027B5B)), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.welcome_text),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.7f)
                    )
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    .background(Color.White), contentAlignment = Alignment.Center) {
                    Image(painter = painterResource(Res.drawable.start_button), contentDescription = null,
                        modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.07f)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(WelcomeIntents.Start) })
                }
            }
        }
    }
}