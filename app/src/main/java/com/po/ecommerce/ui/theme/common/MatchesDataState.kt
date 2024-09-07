package com.po.ecommerce.ui.theme.common

sealed class MatchesDataState {
    class Success(val data: MutableList<EcommerceItemVo>) : MatchesDataState()
    class Failure(val message: String) : MatchesDataState()
    object Loading : MatchesDataState()
    object Empty : MatchesDataState()
}

