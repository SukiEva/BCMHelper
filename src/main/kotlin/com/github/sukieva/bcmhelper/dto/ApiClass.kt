package com.github.sukieva.bcmhelper.dto

/**
 * 接口类
 *
 * @author SukiEva
 * @date 2022/11/20
 */
data class ApiClass(
    var className: String?, // 类名
    var docComment: String?, // 注释
    var apiPath: String?, // 接口上下文根
    var apiMethods: List<ApiMethod> // 接口方法
)
