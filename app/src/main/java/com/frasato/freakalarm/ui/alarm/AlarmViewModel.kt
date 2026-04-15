package com.frasato.freakalarm.ui.alarm

import android.app.AlarmManager
import android.content.Context
import androidx.lifecycle.ViewModel
import com.frasato.freakalarm.domain.model.Alarm
import com.frasato.freakalarm.domain.usecase.ScheduleAlarmUseCase

class AlarmViewModel(
    private val scheduleAlarmUseCase: ScheduleAlarmUseCase
): ViewModel() {

    fun scheduleTestAlarm(): Boolean{
        val alarm = Alarm(
            id=1,
            timeInMillis = System.currentTimeMillis() + 60_00,
            isEnabled = true
        )

        return scheduleAlarmUseCase(alarm)
    }

    fun canScheduleExactAlarms(context: Context): Boolean {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        return alarmManager.canScheduleExactAlarms()
    }
}