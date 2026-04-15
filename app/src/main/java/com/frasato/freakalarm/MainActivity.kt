package com.frasato.freakalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.frasato.freakalarm.data.repository.AlarmRepositoryImpl
import com.frasato.freakalarm.domain.usecase.ScheduleAlarmUseCase
import com.frasato.freakalarm.ui.alarm.AlarmScreen
import com.frasato.freakalarm.ui.alarm.AlarmViewModel
import com.frasato.freakalarm.ui.theme.FreakalarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository = AlarmRepositoryImpl(applicationContext)
            val useCase = ScheduleAlarmUseCase(repository)
            val viewModel = AlarmViewModel(useCase)

            AlarmScreen(viewModel)
        }
    }
}