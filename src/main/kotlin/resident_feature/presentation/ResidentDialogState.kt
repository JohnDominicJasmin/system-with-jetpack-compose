package resident_feature.presentation

import androidx.compose.ui.graphics.Color

data class ResidentDialogState(
    val title: String = "",
    val description: String = "",
    val imageResource: String = "",
    val color: Color? = null
)