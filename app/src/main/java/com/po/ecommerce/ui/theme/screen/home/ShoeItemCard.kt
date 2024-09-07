package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.po.ecommerce.ui.theme.common.EcommerceItemVo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoeItemCard(ecommerceItemVo: EcommerceItemVo) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp),
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
//            Image(
//                painter = painterResource(id = R.drawable.shoe_image),
//                contentDescription = "Shoe",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(100.dp)
//                    .align(Alignment.CenterVertically)
//            )

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(ecommerceItemVo.product_url)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "$250.00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = "Nike Air Vapormax 2020",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                IconButton(onClick = { /* TODO: Add favorite action */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite", tint = Color.Red)
                }
                IconButton(onClick = { /* TODO: Add cart action */ }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Add to Cart")
                }
            }
        }
    }
}
