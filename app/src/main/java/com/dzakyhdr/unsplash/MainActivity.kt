package com.dzakyhdr.unsplash

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dzakyhdr.unsplash.ui.detail.DetailScreen
import com.dzakyhdr.unsplash.ui.detail.DetailViewModel
import com.dzakyhdr.unsplash.ui.home.HomeScreen
import com.dzakyhdr.unsplash.ui.home.HomeViewModel
import com.dzakyhdr.unsplash.ui.theme.UnsplashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val homeViewModel: HomeViewModel by viewModels()

    private val detailViewModel: DetailViewModel by viewModels()

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashTheme {
                // A surface container using the 'background' color from the theme

                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(
                        route = Screen.Home.route
                    ) {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            HomeScreen(homeViewModel, navController)
                        }

                    }

                    composable(
                        route = Screen.Detail.route,
                        arguments = listOf(navArgument(DETAIL_ID) {
                            type = NavType.StringType
                        })
                    ) { idFromHome ->
                        val id = idFromHome.arguments?.getString(DETAIL_ID)!!
                        Log.d("showId", id)
                        detailViewModel.getDetail(id)
                        val data = detailViewModel.detailPhoto.value
                        Log.d("showDetail", data.toString())
                        DetailScreen(detailViewModel)

                    }
                }

            }
        }
    }
}


