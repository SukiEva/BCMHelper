package com.github.sukieva.bcmhelper.dto

/**
 * 接口方法
 *
 * @author SukiEva
 * @date 2022/11/20
 */
data class ApiMethod(
    var methodName: String?, // 方法名
    var docComment: String?, // 注释
    var methodParams: List<MethodParam>, // 参数
    var returnType: String?, // 返回值类型
    var requestPath: String?, // 路径
    var requestMethod: String?, // 请求方法
    var authority: String? // 权限点
)