package com.frasato.freakalarm.domain.model

data class Alarm(
    val id: Int,
    val timeInMillis: Long,
    val isEnabled: Boolean
)
