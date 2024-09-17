package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.ChoosingCategoryViewModel

object ChoosingCategoryIntent {
   fun execute(index:Int,category:String){
      val newList = mutableListOf(
         Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
         Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
         Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8),
         Color(0xFFD8D8D8),Color(0xFFD8D8D8),Color(0xFFD8D8D8))

      newList[index] = Color(0xFF027B5B)

      ChoosingCategoryViewModel.choosingCategoryState = ChoosingCategoryViewModel.choosingCategoryState.copy(
         listColors = newList
      )
      DataTransaction.category.value = category
   }
}