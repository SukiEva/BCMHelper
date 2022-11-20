package com.github.sukieva.bcmhelper.dto

/**
 * 接口方法
 *
 * @author SukiEva
 * @date 2022/11/20
 */
data class ApiMethod(
    var description: String?, // 描述
    var path: String, // 路径
    var method: String, // 请求方法
    var authority: String?, // 权限点
    var params: List<MethodParam>, // 参数
    var returnType: String // 返回值类型
)