package org.example.project.core

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.utils.Goal
import org.example.project.utils.Transaction
import org.example.project.utils.Wallets
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.circle


object StaticDate:StaticDateApi {
    lateinit var navigator: Navigator
    override var listWallets:MutableList<Wallets> = mutableListOf()
    override var listGoals:MutableList<Goal> = mutableListOf()
    override var photo: ImageBitmap? =  null
    override var name:String = ""
    override var gender:DrawableResource = Res.drawable.circle
    override var isUsedPieChart:MutableState<Boolean> = mutableStateOf(true)
    override var isUsedFinishWish:MutableState<Boolean> = mutableStateOf(true)
    override var isUsedListWallet:MutableState<Boolean> = mutableStateOf(true)
    override var goalNow: MutableState<Int> = mutableStateOf(0)
    override var isUsedStatistic: MutableState<Boolean> = mutableStateOf(true)
    override var isUsedEditWallet: MutableState<Boolean> = mutableStateOf(true)
    override var isUsedWishList: MutableState<Boolean> = mutableStateOf(true)
    override var isUsedAddSumMenu: MutableState<Boolean> = mutableStateOf(false)
    override var indexWalletNow: MutableState<Int> = mutableStateOf(0)
    override var indexDetailWallet: MutableState<Int> = mutableStateOf(0)
    override var isUsedTransactions: MutableState<Boolean> = mutableStateOf(true)

}