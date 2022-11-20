package com.github.sukieva.bcmhelper.notification

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project


private val notificationGroup = NotificationGroupManager.getInstance()
    .getNotificationGroup("BCM.NotificationGroup")

fun notify(project: Project, message: String, notificationType: NotificationType) {
    notificationGroup.createNotification(message, notificationType).notify(project)
}

fun notifyInfo(project: Project, message: String) {
    notify(project, message, NotificationType.INFORMATION)
}

fun notifyWarn(project: Project, message: String) {
    notify(project, message, NotificationType.WARNING)
}

fun notifyError(project: Project, message: String) {
    notify(project, message, NotificationType.ERROR)
}