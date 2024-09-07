package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.po.ecommerce.R
import com.po.ecommerce.ui.theme.resources.dimen


@Composable
fun BrandLogosView() {
    // Sample list of brand logos; replace these IDs with your actual drawable resources
    val brandLogos = listOf(
        R.drawable.ic_nike, // Replace with actual drawable resources
        R.drawable.ic_adidas,
        R.drawable.ic_puma,
        R.drawable.ic_ua,
        R.drawable.ic_new_balance,
        R.drawable.icon_3,
        R.drawable.icon_4,
        R.drawable.icon_5
    )

    // LazyRow for horizontal scrolling of brand logo cards
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .padding(end = 16.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between cards
    ) {
        items(brandLogos) { logo ->
            BrandLogoCard(logo)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrandLogoCard(logoResId: Int) {
    // Card with rounded corners displaying the logo
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(60.dp) // Set the size of each logo card
            .background(Color.White) // Set background color of each card
            .clickable { /* Handle click action */ }
    ) {
        // Image composable to display the logo
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = "Brand Logo",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp) // Adjust padding around the logo image
        )
    }
}

@Composable
fun PopularHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Image(
            modifier = Modifier.size(MaterialTheme.dimen.base_3x),
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "Brand Logo",
            // Adjust padding around the logo image
        )
    }
}

