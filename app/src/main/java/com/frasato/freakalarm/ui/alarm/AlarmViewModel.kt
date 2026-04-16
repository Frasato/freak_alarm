package com.frasato.freakalarm.ui.alarm

import android.app.AlarmManager
import android.content.Context
import androidx.lifecycle.ViewModel
import com.frasato.freakalarm.domain.model.Alarm
import com.frasato.freakalarm.domain.usecase.ScheduleAlarmUseCase
import java.util.Calendar

class AlarmViewModel(
    private val scheduleAlarmUseCase: ScheduleAlarmUseCase
): ViewModel() {

    fun scheduleAlarm(hour: Int, minutes: Int): Boolean{

        val calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minutes)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        if(calendar.timeInMillis <= System.currentTimeMillis()){
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }

        val time = calendar.timeInMillis

        val alarm = Alarm(
            id=1,
            timeInMillis = time,
            isEnabled = true
        )

        return scheduleAlarmUseCase(alarm)
    }

    fun canScheduleExactAlarms(context: Context): Boolean {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        return alarmManager.canScheduleExactAlarms()
    }
}