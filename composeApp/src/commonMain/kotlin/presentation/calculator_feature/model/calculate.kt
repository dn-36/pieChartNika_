package org.example.project.presentation.calculator_feature.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import androidx.compose.material.Text
import androidx.compose.ui.text.style.TextAlign
import kotlin.math.round


object Calculator{
    @Composable
    fun Calculate(){
    var input by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

// Helper function to evaluate the expression
fun eval(expr: String): Double {
    return object : Any() {
        var pos = -1
        var ch = 0

        fun nextChar() {
            ch = if (++pos < expr.length) expr[pos].toInt() else -1
        }

        fun eat(charToEat: Int): Boolean {
            while (ch == ' '.toInt()) nextChar()
            if (ch == charToEat) {
                nextChar()
                return true
            }
            return false
        }

        fun parse(): Double {
            nextChar()
            val x = parseExpression()
            if (pos < expr.length) throw RuntimeException("Unexpected: " + ch.toChar())
            return x
        }

        fun parseExpression(): Double {
            var x = parseTerm()
            while (true) {
                if (eat('+'.toInt())) x += parseTerm() // addition
                else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                else return x
            }
        }

        fun parseTerm(): Double {
            var x = parseFactor()
            while (true) {
                if (eat('*'.toInt())) x *= parseFactor() // multiplication
                else if (eat('/'.toInt())) x /= parseFactor() // division
                else return x
            }
        }

        fun parseFactor(): Double {
            if (eat('+'.toInt())) return parseFactor() // unary plus
            if (eat('-'.toInt())) return -parseFactor() // unary minus

            var x: Double
            val startPos = pos
            if (eat('('.toInt())) { // parentheses
                x = parseExpression()
                eat(')'.toInt())
            } else if (ch in '0'.toInt()..'9'.toInt() || ch == '.'.toInt()) { // numbers
                while (ch in '0'.toInt()..'9'.toInt() || ch == '.'.toInt()) nextChar()
                x = expr.substring(startPos, pos).toDouble()
            } else {
                throw RuntimeException("Unexpected: " + ch.toChar())
            }
            return x
        }
    }.parse()
}

// Helper function to perform the calculation
fun calculate() {
    try {
        val expression = input.replace(",", ".")
        val finalResult =
            round(eval(expression) * 100000) / 100000 // округляем до 5 знаков после запятой
        input = finalResult.toString().replace(".", ",")
    } catch (e: Exception) {
        input = "Error"
    }
}

Column(modifier = Modifier
.fillMaxWidth()
.fillMaxHeight(0.9f),
verticalArrangement = Arrangement.SpaceBetween,
horizontalAlignment = Alignment.CenterHorizontally
) {
    // Display input and result
    Box(modifier = Modifier.fillMaxWidth(0.9f).fillMaxHeight(0.2f)
        , contentAlignment = Alignment.Center) {
        Text(
            text = input,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF027B5B),
            modifier = Modifier
                .padding(top = 50.dp)
        )
    }


    // Row for AC, C, , and division
    Column(verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        , modifier = Modifier
            .fillMaxHeight(0.8f)
            .padding( start = 16.dp,end = 16.dp)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input = "0"; result = "" },
                contentAlignment = Alignment.Center
            ) {
                Text("AC", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /* Button(onClick = { input = "0"; result = "" }, modifier = Modifier.weight(1f)) {
             Text("AC")
         }*/
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { if (input.isNotEmpty()) input = input.dropLast(1) },
                contentAlignment = Alignment.Center
            ) {
                Text("C", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /* Button(
             onClick = { if (input.isNotEmpty()) input = input.dropLast(1) },
             modifier = Modifier.weight(1f)
         ) {
             Text("C")
         }*/
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { if (!input.contains(",")) input += "," },
                contentAlignment = Alignment.Center
            ) {
                Text(",", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /*Button(
            onClick = { if (!input.contains(",")) input += "," },
            modifier = Modifier.weight(1f)
        ) {
            Text(",")
        }*/
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input += "/" }, contentAlignment = Alignment.Center
            ) {
                Text("/", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /* Button(onClick = { input += "/" }, modifier = Modifier.weight(1f)) {
             Text("/")
         }*/
        }

        // Rows for numbers and operations
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NumberButton("7", { input += "7" })
            NumberButton("8", { input += "8" })
            NumberButton("9", { input += "9" })

            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input += "*" }, contentAlignment = Alignment.Center
            ) {
                Text("x", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /*Button(onClick = { input += "*" }, modifier = Modifier.weight(1f)) {
            Text("x")
        }*/
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NumberButton("4", { input += "4" })
            NumberButton("5", { input += "5" })
            NumberButton("6", { input += "6" })

            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input += "-" }, contentAlignment = Alignment.Center
            ) {
                Text("-", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /*Button(onClick = { input += "-" }, modifier = Modifier.weight(1f)) {
            Text("-")
        }*/
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NumberButton("1", { input += "1" })
            NumberButton("2", { input += "2" })
            NumberButton("3", { input += "3" })

            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input += "+" }, contentAlignment = Alignment.Center
            ) {
                Text("+", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /*Button(onClick = { input += "+" }, modifier = Modifier.weight(1f)) {
            Text("+")
        }*/
        }

        Row( horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.size(80.dp)

            ) {
                Text("", fontSize = 35.sp, color = Color.Transparent)
            }
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { input += "0" }, contentAlignment = Alignment.Center
            ) {
                Text("0", fontSize = 35.sp, color = Color(0xFFF8DB1C))
            }
            /*Button(onClick = { input += "0" }, modifier = Modifier.weight(2f)) {
            Text("0")
        }*/
            Box(modifier = Modifier.size(80.dp)

            ) {
                Text("", fontSize = 35.sp, color = Color.Transparent)
            }
            Box(modifier = Modifier.size(80.dp)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { calculate() }, contentAlignment = Alignment.Center
            ) {
                Text("=", fontSize = 35.sp, color = Color(0xFF027B5B))
            }
            /*Button(onClick = { calculate() }, modifier = Modifier.weight(1f)) {
            Text("=")
        }*/
        }
    }
}
    }

}