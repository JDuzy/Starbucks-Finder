package com.example.starbucksfinder.presentation.ui.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val resId: Int
    ) : UiText()

    @Composable
    fun asString(): String {
        return when(this){
            is DynamicString -> value
            is StringResource -> stringResource(id = resId)
        }
    }
}