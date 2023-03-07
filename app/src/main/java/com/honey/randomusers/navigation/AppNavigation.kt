package com.honey.randomusers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.honey.randomusers.navigation.Navigation.Args.SPEAKER_ID

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.SPEAKERS
    ) {
        composable(
            route = Navigation.Routes.SPEAKERS
        ){
            MainScreenDestination(navController)
        }
        
        composable(
            route = Navigation.Routes.FULL_VIEW,
            arguments = listOf(navArgument(name = SPEAKER_ID){
                type = NavType.StringType
            })
        ) {backStackEntry ->
            //TODO("continue")
            val speakerId = requireNotNull(backStackEntry.arguments?.getString(SPEAKER_ID)) { "User id is required as an argument" }
            FullInfoScreenDestination(userId = , navController = )
            
        }
    }
}

object Navigation {
    object Args{
        const val SPEAKER_ID = "speaker_id"
    }

    object Routes{
        const val SPEAKERS = "speakers"
        const val FULL_VIEW = "$SPEAKERS/{$SPEAKER_ID}"
    }
}

fun NavController.navigateToFullView(speakerId: Int){
    navigate(route = "${Navigation.Routes.SPEAKERS}/$speakerId")
}