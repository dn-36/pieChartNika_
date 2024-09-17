package org.example.project.presentation.calculator_feature.model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(number: String, onClick: () -> Unit) {
    Box(modifier = Modifier.size(80.dp)
        .clickable(onClick = onClick), contentAlignment = Alignment.Center){
        Text(number, fontSize = 35.sp, color = Color(0xFFF8DB1C))
    }
}