package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.po.ecommerce.ui.theme.common.EcommerceItemVo

@Composable
fun ShowLazyList(ecommerce : MutableList<EcommerceItemVo>,
                ) {
    LazyColumn {
        items(ecommerce) { ecommerce ->
            CardItem(ecommerce = ecommerce)
        }
    }
}