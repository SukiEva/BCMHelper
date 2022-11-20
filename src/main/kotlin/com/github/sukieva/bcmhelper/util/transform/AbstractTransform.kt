package com.github.sukieva.bcmhelper.util.transform

import com.github.sukieva.bcmhelper.dto.ApiClass
import com.github.sukieva.bcmhelper.dto.ApiMethod
import com.github.sukieva.bcmhelper.dto.MethodParam
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiParameter

/**
 * PsiClass 抽象转换类
 *
 * @author SukiEva
 * @date 2022/11/20
 */
abstract class AbstractTransform {
    /**
     * PsiClass 转换 ApiClass
     *
     * @param psiClass PsiClass
     * @return ApiClass
     */
    fun toApiClass(psiClass: PsiClass): ApiClass = ApiClass(
        psiClass.name,
        psiClass.docComment?.text,
        getApiPath(psiClass),
        getApiMethods(psiClass.methods)
    )

    /**
     * 获取上下文根
     *
     * @param psiClass PsiClass
     * @return String?
     */
    protected abstract fun getApiPath(psiClass: PsiClass): String?

    /**
     * 获取接口方法
     *
     * @param psiMethods Array<PsiMethod>
     * @return List<ApiMethod>
     */
    protected abstract fun getApiMethods(psiMethods: Array<PsiMethod>): List<ApiMethod>

    /**
     * 获取方法参数
     *
     * @param psiParameters Array<PsiParameter>
     * @return List<MethodParam>
     */
    protected fun getMethodParams(psiParameters: Array<PsiParameter>): List<MethodParam> {
        val methodParams = mutableListOf<MethodParam>()
        for (psiParameter in psiParameters) {
            methodParams.add(
                MethodParam(
                    psiParameter.type.presentableText,
                    psiParameter.name,
                    psiParameter.modifierList?.text
                )
            )
        }
        return methodParams
    }
}