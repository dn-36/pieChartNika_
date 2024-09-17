package org.example.project.utils

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class Goal(val target:String,
    val sum:Int,var already:Int,var transactions:Int,val date:Int)
