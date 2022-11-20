package com.github.sukieva.bcmhelper.action

import com.github.sukieva.bcmhelper.BcmBundle
import com.github.sukieva.bcmhelper.notification.notifyError
import com.github.sukieva.bcmhelper.notification.notifyInfo
import com.github.sukieva.bcmhelper.util.PsiUtil
import com.github.sukieva.bcmhelper.util.transform.SpringTransform
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.DumbService

/**
 * Restful 接口分析
 *
 * @author SukiEva
 * @date 2022/11/20
 */
class ApiDocAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        // 获取当前编辑文件
        val psiFile = e.getData(CommonDataKeys.PSI_FILE)
        val editor = e.getData(CommonDataKeys.EDITOR)
        if (project == null || DumbService.isDumb(project) || psiFile == null || editor == null) {
            return
        }

        val psiClass = PsiUtil.getClass(editor, psiFile)
        if (psiClass == null || psiClass.isAnnotationType || psiClass.isEnum) {
            notifyError(project, BcmBundle.message("notify.error.classNotSatisfied"))
            return
        }
        val apiClass = SpringTransform.toApiClass(psiClass)
        println(apiClass)
        notifyInfo(project, "点击成功")
    }
}