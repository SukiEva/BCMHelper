package com.github.sukieva.bcmhelper.util

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiFile
import com.intellij.psi.SyntheticElement
import com.intellij.psi.util.PsiTreeUtil


/**
 * Psi 工具类
 *
 * @author SukiEva
 * @date 2022/11/20
 */
object PsiUtil {
    /**
     * 获取 PsiClass
     *
     * @param psiFile PsiFile
     * @return PsiClass
     */
    fun getClass(psiFile: PsiFile): PsiClass? {
        for (child in psiFile.children) {
            if (child is PsiClass) {
                return child;
            }
        }
        return null
    }

    /**
     * 获取 PsiClass
     *
     * @param editor Editor
     * @param psiFile PsiFile
     * @return PsiClass
     */
    fun getClass(editor: Editor, psiFile: PsiFile): PsiClass? {
        val element = psiFile.findElementAt(editor.caretModel.offset) ?: return null
        val target = PsiTreeUtil.getParentOfType(element, PsiClass::class.java)
        return if (target is SyntheticElement) null else target
    }
}