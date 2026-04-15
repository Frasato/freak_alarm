package com.frasato.freakalarm.domain.repository

import com.frasato.freakalarm.domain.model.Alarm

interface AlarmRepository {
    fun schedule(alarm: Alarm): Boolean
}