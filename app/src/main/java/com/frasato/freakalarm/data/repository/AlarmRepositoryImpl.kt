package com.frasato.freakalarm.data.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.frasato.freakalarm.data.receiver.AlarmReceiver
import com.frasato.freakalarm.domain.model.Alarm
import com.frasato.freakalarm.domain.repository.AlarmRepository

class AlarmRepositoryImpl(
    private val context: Context
): AlarmRepository {
    override fun schedule(alarm: Alarm){
        val intent = Intent(context, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarm.id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarm.timeInMillis,
            pendingIntent
        )
    }
}