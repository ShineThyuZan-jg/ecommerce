package com.po.ecommerce.ui.theme.screen.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.po.ecommerce.R
import com.po.ecommerce.ui.theme.common.VerticalSpacerBase

@Composable
fun SearchBar() {
    // State for the text input
    val searchText = remember { mutableStateOf("") }

    // Search bar content
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        // TextField for the search bar
        TextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            placeholder = {
                Text(text = "Search", fontSize = 16.sp, color = Color.Gray)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, // Background color
                focusedIndicatorColor = Color.Transparent, // Removes the indicator
                unfocusedIndicatorColor = Color.Transparent, // Removes the indicator
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp), // Rounded shape for the text field
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                ) // Background shape and color
                .height(50.dp) // Set the height of the search bar
        )
    }
}

@Composable
@Preview
private fun CardItemForAdsPreview() {
    Surface {
        SearchBar()
    }
}