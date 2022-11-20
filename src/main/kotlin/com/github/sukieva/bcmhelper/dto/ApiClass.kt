package com.github.sukieva.bcmhelper.dto

/**
 * 接口类
 *
 * @author SukiEva
 * @date 2022/11/20
 */
data class ApiClass(
    var description: String?, // 接口信息
    var path: String?, // 接口上下文根
    var methods: List<ApiMethod> // 接口方法
)
