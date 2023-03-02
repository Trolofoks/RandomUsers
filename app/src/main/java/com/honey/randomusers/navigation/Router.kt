package com.honey.randomusers.navigation

import android.os.Bundle
import androidx.core.os.bundleOf

fun createExternalRouter(block: (String, Bundle)-> Unit): Router = object : Router {
    override fun routeTo(screen: String, params: Bundle){
        block.invoke(screen, params)
    }
}

interface Router {
    fun routeTo(screen: String, params: Bundle = bundleOf()){
        throw NotImplementedError(message = "Where $screen with $params?")
    }
}