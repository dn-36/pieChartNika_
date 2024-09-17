package org.example.project.presentation.add_transaction.finish_fetaure.viewmodel

sealed class FinishIntents {
    object Finish:FinishIntents()
    object SetScreen:FinishIntents()
}