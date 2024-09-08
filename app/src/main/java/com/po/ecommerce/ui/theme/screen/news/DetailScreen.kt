package com.po.ecommerce.ui.theme.screen.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.po.ecommerce.R
import com.po.ecommerce.ui.theme.resources.dimen
import com.po.ecommerce.ui.theme.viewmodel.EcommerceInfoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: EcommerceInfoViewModel = hiltViewModel()
) {
    val ecommerce by viewModel.selectedEcommerce.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            SmallTopAppBar(
                title = {},
                actions = {
                    when (ecommerce?.favorite) {
                        "1" -> {
                            Image(
                                painter = painterResource(id = R.drawable.ic_red),
                                modifier = Modifier
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
                                    .size(36.dp)
                                    .padding(MaterialTheme.dimen.base)
                                    .clip(shape = CircleShape),
                                contentDescription = "logo",
                                contentScale = ContentScale.Inside
                            )
                        }
                    }

                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(MaterialTheme.dimen.base_4x)
                            .clickable {
                                navController.popBackStack()
                            },
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back",
                    )
                }
            )
        },
        snackbarHost = {},
        containerColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            Column(modifier = Modifier.padding(all = 8.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(ecommerce?.product_url ?: "")
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = ecommerce?.product_type ?: "0",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = ecommerce?.rating ?: "0",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = ecommerce?.name ?: "0",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = ecommerce?.price ?: "0",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Size:",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "US  UK  EU",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

            }
        }
    }
}

