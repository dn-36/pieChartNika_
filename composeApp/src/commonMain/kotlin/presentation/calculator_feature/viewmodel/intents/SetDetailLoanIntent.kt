package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object SetDetailLoanIntent {
    fun execute(){
        if(CalculatorViewModel.calculatorState.percent.value == "% Year" &&
            CalculatorViewModel.calculatorState.month.value == "Year") {
            val monthlyPaymentNoPercent =
                (CalculatorViewModel.calculatorState.sum.value / CalculatorViewModel.calculatorState.totalTerm.value) / 12
            val monthlyPayment =
                monthlyPaymentNoPercent + ((monthlyPaymentNoPercent / 100) * (CalculatorViewModel.calculatorState.totalRate.value / 12))

            val pereplataYear = monthlyPayment  - monthlyPaymentNoPercent

            val totalPereplata =
                (monthlyPayment * 12 * CalculatorViewModel.calculatorState.totalTerm.value) - (monthlyPaymentNoPercent * 12 * CalculatorViewModel.calculatorState.totalTerm.value)


            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                monthlyPayment = mutableStateOf(monthlyPayment.toInt()),
                totalOverpayment = mutableStateOf(totalPereplata.toInt()),
                overpayment = mutableStateOf(pereplataYear.toInt())

            )
        }
        else if(CalculatorViewModel.calculatorState.percent.value == "% Year" &&
            CalculatorViewModel.calculatorState.month.value == "Month") {
            val monthlyPaymentNoPercent =
                CalculatorViewModel.calculatorState.sum.value / CalculatorViewModel.calculatorState.totalTerm.value
            var monthlyPayment =
                monthlyPaymentNoPercent + ((monthlyPaymentNoPercent / 100) * (CalculatorViewModel.calculatorState.totalRate.value / 12))

            val pereplataMonth = monthlyPayment  - monthlyPaymentNoPercent

            val totalPereplata =
                (monthlyPayment * CalculatorViewModel.calculatorState.totalTerm.value) - (monthlyPaymentNoPercent * CalculatorViewModel.calculatorState.totalTerm.value)


            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                monthlyPayment = mutableStateOf(monthlyPayment.toInt()),
                totalOverpayment = mutableStateOf(totalPereplata.toInt()),
                overpayment = mutableStateOf(pereplataMonth.toInt())

            )
        }
        else if(CalculatorViewModel.calculatorState.percent.value == "% Month" &&
            CalculatorViewModel.calculatorState.month.value == "Month") {
            val monthlyPaymentNoPercent =
                CalculatorViewModel.calculatorState.sum.value / CalculatorViewModel.calculatorState.totalTerm.value
            var monthlyPayment =
                monthlyPaymentNoPercent + ((monthlyPaymentNoPercent / 100) * CalculatorViewModel.calculatorState.totalRate.value )

            val pereplataMonth = monthlyPayment  - monthlyPaymentNoPercent

            val totalPereplata =
                (monthlyPayment * CalculatorViewModel.calculatorState.totalTerm.value) - (monthlyPaymentNoPercent * CalculatorViewModel.calculatorState.totalTerm.value)


            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                monthlyPayment = mutableStateOf(monthlyPayment.toInt()),
                totalOverpayment = mutableStateOf(totalPereplata.toInt()),
                overpayment = mutableStateOf(pereplataMonth.toInt())

            )
        }
        else if(CalculatorViewModel.calculatorState.percent.value == "% Month" &&
            CalculatorViewModel.calculatorState.month.value == "Year") {
            val monthlyPaymentNoPercent =
                (CalculatorViewModel.calculatorState.sum.value / CalculatorViewModel.calculatorState.totalTerm.value) / 12
            var monthlyPayment =
                monthlyPaymentNoPercent + ((monthlyPaymentNoPercent / 100) * CalculatorViewModel.calculatorState.totalRate.value )

            val pereplataYear = monthlyPayment  - monthlyPaymentNoPercent

            val totalPereplata =
                (monthlyPayment * 12 * CalculatorViewModel.calculatorState.totalTerm.value) - (monthlyPaymentNoPercent * 12 * CalculatorViewModel.calculatorState.totalTerm.value)


            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                monthlyPayment = mutableStateOf(monthlyPayment.toInt()),
                totalOverpayment = mutableStateOf(totalPereplata.toInt()),
                overpayment = mutableStateOf(pereplataYear.toInt())

            )
        }
        else if(CalculatorViewModel.calculatorState.percent.value == "% Day" &&
            CalculatorViewModel.calculatorState.month.value == "Year") {
            val monthlyPaymentNoPercent =
                (CalculatorViewModel.calculatorState.sum.value / CalculatorViewModel.calculatorState.totalTerm.value) / 12
            var monthlyPayment =
                monthlyPaymentNoPercent + ((monthlyPaymentNoPercent / 100) * (CalculatorViewModel.calculatorState.totalRate.value * 30) )

            val pereplataYear = monthlyPayment  - monthlyPaymentNoPercent

            val totalPereplata =
                (monthlyPayment * 12 * CalculatorViewModel.calculatorState.totalTerm.value) - (monthlyPaymentNoPercent * 12 * CalculatorViewModel.calculatorState.totalTerm.value)


            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                monthlyPayment = mutableStateOf(monthlyPayment.toInt()),
                totalOverpayment = mutableStateOf(totalPereplata.toInt()),
                overpayment = mutableStateOf(pereplataYear.toInt())

            )
        }
    }

}