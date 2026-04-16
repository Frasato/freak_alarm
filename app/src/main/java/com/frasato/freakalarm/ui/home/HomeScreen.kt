package com.frasato.freakalarm.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.frasato.freakalarm.ui.navigation.NavRoutes

@Composable
fun HomeScreen(
    navController: NavController
){
    Column() {
        Text("HOME SCREEN")
        Button(
            onClick = {
                navController.navigate(NavRoutes.ALARM)
            }
        ) { Text("+") }
    }
}