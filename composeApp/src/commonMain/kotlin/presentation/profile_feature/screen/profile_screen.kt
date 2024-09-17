package org.example.project.presentation.profile_feature.screen

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import kotlinx.coroutines.delay
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.menu_feature.viewmodel.MenuIntents
import org.example.project.presentation.profile_feature.viewmodel.ProfileViewModel
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetIntents
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.circle
import room_cmp.composeapp.generated.resources.clicked_profile
import room_cmp.composeapp.generated.resources.plus_transaction
import room_cmp.composeapp.generated.resources.statistic
import room_cmp.composeapp.generated.resources.wallet
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.home_button

object ProfileScreen: Screen {
    var vm = ProfileViewModel(StaticDate)
    @Composable
    override fun Content(){
        var name by remember { mutableStateOf("${ProfileViewModel(StaticDate).date.name}") }

        val scope = rememberCoroutineScope()

        val images = remember { mutableStateListOf<ImageBitmap>(ProfileViewModel(StaticDate).date.photo!!) }


        val multipleImagePicker = rememberImagePickerLauncher(
            scope = scope,
            selectionMode = SelectionMode.Multiple(),
            onResult = { byteArrays ->
                images += byteArrays.map {
                    it.toImageBitmap()
                }
            }
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.13f)
                        .background(Color(0xFF027B5B))
                ) {
                    Text(
                        "Profile",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.86f)
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxHeight(0.9f),
                        verticalArrangement = Arrangement.SpaceBetween
                    , horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Username",color = Color.Black, fontSize = 22.sp)

                            BasicTextField(
                                value = name,
                                onValueChange = { name = it },
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                            )

                        Text("Gender",color = Color.Black, fontSize = 22.sp)

                        Image(painter = painterResource(ProfileViewModel(StaticDate).date.gender), contentDescription = null,
                            modifier = Modifier.size(90.dp))

                        Text("Photo",color = Color.Black, fontSize = 22.sp)

                        if (images != null) {
                            Image(
                                modifier = Modifier.clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    if (images.size == 1) {
                                        images.removeAt(0)
                                    }
                                    multipleImagePicker.launch()
                                }
                                    //.padding(horizontal = 8.dp)
                                    .size(120.dp)
                                    .clip(CircleShape),
                                bitmap = images[0],
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                        else{
                            Image(painter = painterResource(Res.drawable.circle), contentDescription = null,
                                modifier = Modifier.size(120.dp)
                                    .clip(CircleShape),contentScale = ContentScale.Crop)
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
                            modifier = Modifier.size(30.dp)
                        )
                        Image(painter = painterResource(Res.drawable.plus_transaction), contentDescription = null,
                            modifier = Modifier.size(40.dp)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }){
                                    MenuScreen.vm.processIntent(MenuIntents.AddTransaction)
                                })
                        Image(
                            painter = painterResource(Res.drawable.wallet),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                MenuScreen.vm.processIntent(MenuIntents.Wallets)
                            }
                        )
                        Image(
                            painter = painterResource(Res.drawable.clicked_profile),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}