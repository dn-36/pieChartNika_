package org.example.project.utils

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class SumWallet(var type:String
,var date:String,var sum:String)
