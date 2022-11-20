package com.github.sukieva.bcmhelper.util.transform

import com.github.sukieva.bcmhelper.constant.SpringConstant
import com.github.sukieva.bcmhelper.dto.ApiMethod
import com.intellij.psi.*

/**
 * Spring PsiClass 转换
 *
 * @author SukiEva
 * @date 2022/11/20
 */
object SpringTransform : AbstractTransform() {
    override fun getApiPath(psiClass: PsiClass): String? =
        getRequestPath(psiClass.getAnnotation(SpringConstant.REQUEST_MAPPING))

    override fun getApiMethods(psiMethods: Array<PsiMethod>): List<ApiMethod> {
        val apiMethods = mutableListOf<ApiMethod>()
        for (psiMethod in psiMethods) {
            val requestMapping = psiMethod.getAnnotation(SpringConstant.REQUEST_MAPPING) ?: continue
            apiMethods.add(
                ApiMethod(
                    psiMethod.name,
                    psiMethod.docComment?.text,
                    getMethodParams(psiMethod.parameterList.parameters),
                    psiMethod.returnType?.presentableText,
                    getRequestPath(requestMapping),
                    requestMapping.findAttributeValue("method")?.text,
                    null
                )
            )
        }
        return apiMethods
    }

    private fun getRequestPath(psiAnnotation: PsiAnnotation?): String? {
        if (psiAnnotation == null) return null
        val value = psiAnnotation.findAttributeValue("value") ?: return null
        return value.text.replace("\"", "")
    }
}