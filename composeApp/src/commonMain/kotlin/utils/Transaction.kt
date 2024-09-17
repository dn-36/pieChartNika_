package org.example.project.utils

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class Transaction(val img: String, val category:String, val name:String
                       , val month:String, val day:String, val year:String
                       , val sum:String,val sign:String)