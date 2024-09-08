package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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


@Composable
fun SizeView(size : List<Int>) {
    // LazyRow for horizontal scrolling of brand logo cards
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .padding(end = 16.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between cards
    ) {
        items(size) { logo ->
            SizeCard(logo.toString())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SizeCard(logoResId: String) {
    // Create a state to hold the background color
    var backgroundColor by remember { mutableStateOf(Color.LightGray) }

    // Card with rounded corners displaying the logo
    Card(
        shape = RoundedCornerShape(10.dp),

        ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .size(60.dp)
                .background(backgroundColor) // Apply the dynamic background color
                .clickable {
                    // Change background color on click
                    backgroundColor =
                        if (backgroundColor == Color.LightGray) Color(0xFFFF9800) else Color.LightGray
                }, // Fills the entire Card
            contentAlignment = Alignment.Center // Centers content both vertically and horizontally
        ) {
            Text(
                text = logoResId,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ColorSelector() {
    // List of colors to display
    val colors = listOf(Color.White, Color.Black, Color(0xFF8BC34A), Color(0xFF7E57C2))

    // Mutable state to hold selected color index
    var selectedColorIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        colors.forEachIndexed { index, color ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color)
                    .clickable { selectedColorIndex = index },
                contentAlignment = Alignment.Center
            ) {
                // Show checkmark only for the selected color
                if (index == selectedColorIndex) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color(0xFFFF9800) // Orange color for the checkmark
                    )
                }
            }
        }
    }
}


@Composable
fun CounterView() {
    var count by remember { mutableStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(
            onClick = { if (count > 0) count-- },
            modifier = Modifier
                .size(MaterialTheme.dimen.base_3x)
                .background(Color.LightGray, CircleShape)
        ) {
            Icon(
                modifier = Modifier
                    .size(MaterialTheme.dimen.base_3x),
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = "back",
            )
        }

        Text(text = count.toString(), fontSize = 18.sp)

        IconButton(
            onClick = { count++ },
            modifier = Modifier
                .size(MaterialTheme.dimen.base_3x)
                .background(Color.LightGray, CircleShape)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
        }
    }
}



