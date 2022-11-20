package com.github.sukieva.bcmhelper.services

import com.github.sukieva.bcmhelper.BcmBundle

class MyApplicationService {

    init {
        println(BcmBundle.message("applicationService"))

        System.getenv("CI")
            ?: TODO("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }
}
