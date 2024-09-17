package org.example.project.presentation.statistic_feature.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.utils.getTodayDay
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.bank_of_money

@Composable
fun MoneyBox(){
    Column(modifier = Modifier.fillMaxSize()
      , horizontalAlignment = Alignment.CenterHorizontally
      , verticalArrangement = Arrangement.Top) {

      LazyColumn {
        itemsIndexed(StatisticViewModel(StaticDate).date.listGoals) { index, item ->
        Row(modifier = Modifier.padding(top = 20.dp)
          .fillMaxWidth(0.95f)
          ,horizontalArrangement = Arrangement.SpaceBetween
        , verticalAlignment = Alignment.CenterVertically){
          Column (horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(Res.drawable.bank_of_money), contentDescription = null,
              modifier = Modifier.size(40.dp))
            Text(item.target, color = Color(0xFF027B5B), fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Days:", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("${(getTodayDay()+1) - item.date}", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          Box(modifier = Modifier.height(40.dp).width(3.dp).background(Color(0xFFF0F2F6)))
          Column (horizontalAlignment = Alignment.CenterHorizontally){
            Text("Sum:", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("${item.sum}", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          Box(modifier = Modifier.height(40.dp).width(3.dp).background(Color(0xFFF0F2F6)))
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Transactions:", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text("${item.transactions}", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          Box(modifier = Modifier.height(40.dp).width(3.dp).background(Color(0xFFF0F2F6)))
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Accumulated:", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text("${item.already}", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
          Box(modifier = Modifier.height(40.dp).width(3.dp).background(Color(0xFFF0F2F6)))

          if(item.already >= item.sum) {
            Text(
              "Repaid",
              color = Color(0xFF3ACC8A),
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold
            )
          }
          else if(item.already < item.sum){
            Text(
              "Current",
              color = Color(0xFFF8DB1C),
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }
        }
      }
    }
}