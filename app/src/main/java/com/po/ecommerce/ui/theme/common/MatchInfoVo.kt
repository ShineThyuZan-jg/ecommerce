package com.po.ecommerce.ui.theme.common

//data class MatchInfoVo(
//    val match_name: String? = null,
//    val first_team: String? = null,
//    val first_team_logo: String? = null,
//    val second_team_logo: String? = null,
//    val second_team: String? = null,
//    val link: String? = null,
//    val quality: String? = null,
//    val match_time: String? = null,
//    val prediction: String? = null,
//)

data class EcommerceItemVo(
    val name: String? = null,
    val product_type: String? = null,
    val rating: String? = null,
    val price: String? = null,
    val favorite: String? = null,
    val product_url: String? = null,
    val size: List<Int>? = null,
    val description: String? = null,
    val deli_return: String? = null,
)
