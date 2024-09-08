package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.po.ecommerce.R
import com.po.ecommerce.ui.theme.common.EcommerceItemVo
import com.po.ecommerce.ui.theme.resources.dimen

@Composable
fun CardItemContent(
    ecommerceItemVo: EcommerceItemVo,
    ) {
    val context = LocalContext.current


    Box(modifier = Modifier
        .fillMaxSize()
      ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(ecommerceItemVo.product_url)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = ecommerceItemVo.price!!,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(MaterialTheme.dimen.base),
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = ecommerceItemVo.name.toString(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(MaterialTheme.dimen.base),
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )
        when (ecommerceItemVo.favorite) {
            "1" -> {
                Image(
                    painter = painterResource(id = R.drawable.ic_red),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(36.dp)
                        .padding(MaterialTheme.dimen.base)
                        .clip(shape = CircleShape),
                    contentDescription = "logo",
                    contentScale = ContentScale.Inside
                )
            }

            "2" -> {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(36.dp)
                        .padding(MaterialTheme.dimen.base)
                        .clip(shape = CircleShape),
                    contentDescription = "logo",
                    contentScale = ContentScale.Inside
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_cart),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(36.dp)
                .padding(MaterialTheme.dimen.base)
                .clip(shape = CircleShape),
            contentDescription = "logo",
            contentScale = ContentScale.Inside
        )
    }
}
