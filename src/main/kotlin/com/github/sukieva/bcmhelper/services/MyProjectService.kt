package com.github.sukieva.bcmhelper.services

import com.intellij.openapi.project.Project
import com.github.sukieva.bcmhelper.BcmBundle

class MyProjectService(project: Project) {

    init {
        println(BcmBundle.message("projectService", project.name))

        System.getenv("CI")
            ?: TODO("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    /**
     * Chosen by fair dice roll, guaranteed to be random.
     */
    fun getRandomNumber() = 4
}
