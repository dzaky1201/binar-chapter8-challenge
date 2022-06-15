package com.dzakyhdr.unsplash.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem


@Composable
fun UnsplashDetail(item: UnsplashResponseItem){
        Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Log.d("ShowData", item.toString())
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberAsyncImagePainter(item),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            )
        }
    }
}