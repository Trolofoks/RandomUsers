package com.honey.randomusers.navigation

import com.honey.randomusers.R

sealed class Screen (val screenName:String, val titleResourceId: Int){
    object Main: Screen("main", R.string.title_main)
    object Full: Screen("full", R.string.title_full)
}