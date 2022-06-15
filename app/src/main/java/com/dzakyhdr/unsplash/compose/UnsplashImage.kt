package com.dzakyhdr.unsplash.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun ShowImages(item: UnsplashResponseItem) {
    Image(
        painter = rememberAsyncImagePainter(item.urls?.small),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(4.dp)
            .width(300.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}
