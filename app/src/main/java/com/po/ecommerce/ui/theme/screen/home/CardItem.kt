package com.po.ecommerce.ui.theme.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.po.ecommerce.ui.theme.common.EcommerceItemVo
import com.po.ecommerce.ui.theme.resources.dimen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(
    ecommerce: EcommerceItemVo,
    onClickCard: (ecommerceItemVo: EcommerceItemVo) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickCard(ecommerce)
            }
            .height(250.dp)
            .padding(MaterialTheme.dimen.base)

    ) {

        CardItemContent(ecommerce)
    }
}

