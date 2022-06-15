package com.dzakyhdr.unsplash.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dzakyhdr.unsplash.R
import com.dzakyhdr.unsplash.Screen
import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem

@Composable
fun UnsplashListItem(item: UnsplashResponseItem, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxHeight(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(modifier = Modifier
            .padding(5.dp)
            .fillMaxHeight()
            .clickable {
                navController.navigate(route = Screen.Detail.passId(item.id))
            }
        ) {
            ShowImages(item = item)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.user.name ?: "Not Found",
                modifier = Modifier.padding(end = 4.dp),
                style = MaterialTheme.typography.h5,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(R.string.likes, "${item.likes}"),
                    modifier = Modifier.padding(end = 4.dp),
                    style = MaterialTheme.typography.h6
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_likes),
                    contentDescription = null,
                )

            }
        }

    }
}