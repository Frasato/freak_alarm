package com.frasato.freakalarm.ui.alarm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    viewModel: AlarmViewModel,
    navController: NavController
){
    val timeState = rememberTimePickerState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimePicker(state = timeState)
        Button(
            onClick = {
                viewModel.scheduleAlarm(timeState.hour, timeState.minute)
            }
        ) { Text("Programar Alarm") }

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) { Text("Voltar") }
    }
}