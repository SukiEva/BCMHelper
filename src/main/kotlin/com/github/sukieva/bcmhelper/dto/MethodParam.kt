package com.github.sukieva.bcmhelper.dto

/**
 * 方法参数
 *
 * @author SukiEva
 * @date 2022/11/20
 */
data class MethodParam(
    var type: String, // 类型
    var name: String, // 名称
    var modifier: String? // 注解
)