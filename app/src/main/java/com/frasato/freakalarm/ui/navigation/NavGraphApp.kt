package com.frasato.freakalarm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.frasato.freakalarm.data.repository.AlarmRepositoryImpl
import com.frasato.freakalarm.domain.usecase.ScheduleAlarmUseCase
import com.frasato.freakalarm.ui.alarm.AlarmScreen
import com.frasato.freakalarm.ui.alarm.AlarmViewModel
import com.frasato.freakalarm.ui.home.HomeScreen

@Composable
fun NavGraphApp(){
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME
    ){
        composable(NavRoutes.HOME){ HomeScreen(navController) }

        composable(NavRoutes.ALARM){
            val repository = AlarmRepositoryImpl(context)
            val usecase = ScheduleAlarmUseCase(repository)
            val viewModel = AlarmViewModel(usecase)
            
            AlarmScreen(
                viewModel = viewModel,
                navController = navController
            ) 
        }
    }
}