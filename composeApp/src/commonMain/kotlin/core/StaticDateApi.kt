package org.example.project.core

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.ImageBitmap
import org.example.project.utils.Goal
import org.example.project.utils.Transaction
import org.example.project.utils.Wallets
import org.jetbrains.compose.resources.DrawableResource

interface StaticDateApi {
    var listWallets:MutableList<Wallets>
    var listGoals:MutableList<Goal>
    var gender:DrawableResource
    var name:String
    var photo:ImageBitmap?
    var isUsedPieChart:MutableState<Boolean>
    var isUsedFinishWish:MutableState<Boolean>
    var isUsedAddSumMenu:MutableState<Boolean>
    var isUsedStatistic:MutableState<Boolean>
    var isUsedListWallet:MutableState<Boolean>
    var indexWalletNow:MutableState<Int>
    var isUsedTransactions:MutableState<Boolean>
    var isUsedEditWallet:MutableState<Boolean>
    var isUsedWishList:MutableState<Boolean>
    var goalNow:MutableState<Int>
    var indexDetailWallet:MutableState<Int>
}

