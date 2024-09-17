package org.example.project.presentation.registerAndStart.gender_feature.viewmodel

sealed class GenderIntents {
    object ChoosingWoman:GenderIntents()
    object ChoosingMan:GenderIntents()
    object Next:GenderIntents()
}