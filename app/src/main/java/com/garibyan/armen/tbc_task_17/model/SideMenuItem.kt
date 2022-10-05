package com.garibyan.armen.tbc_task_17.model

import android.graphics.Color
import com.garibyan.armen.tbc_task_17.R

data class SideMenuItem(
    val icon: Int,
    val title: String,
    val notificationColor: Int? = null,
    val counter: Int? = null

)

val itemList = listOf<SideMenuItem>(
    SideMenuItem(R.drawable.ic_dashboard, "Dashboard"),
    SideMenuItem(R.drawable.ic_mail, "Mail", Color.RED, 15),
    SideMenuItem(R.drawable.ic_notifications, "Notifications", Color.GREEN, 20),
    SideMenuItem(R.drawable.ic_calendar, "Calendar"),
    SideMenuItem(R.drawable.ic_statistic, "Statistic"),
    SideMenuItem(R.drawable.ic_settings, "Settings"),
)
