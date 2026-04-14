package com.frasato.freakalarm.domain.usecase

import com.frasato.freakalarm.domain.model.Alarm
import com.frasato.freakalarm.domain.repository.AlarmRepository

class ScheduleAlarmUseCase(
    private val repository: AlarmRepository
) {
    operator fun invoke(alarm: Alarm){
        repository.schedule(alarm)
    }
}