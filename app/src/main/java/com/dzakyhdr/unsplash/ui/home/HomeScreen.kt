package com.dzakyhdr.unsplash.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dzakyhdr.unsplash.ui.home.HomeViewModel
import com.dzakyhdr.unsplash.compose.UnsplashListItem

@Composable
fun HomeScreen(
    viewmodel: HomeViewModel,
    navController: NavHostController
) {
    val listPhoto = viewmodel.listPhotos.collectAsState()
    LazyVerticalGrid(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(
            items = listPhoto.value
        ) {
            UnsplashListItem(item = it, navController = navController)
        }
    }
}