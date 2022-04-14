package resident_feature.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

data class Shapes(
    val small: RoundedCornerShape= RoundedCornerShape(8.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(14.dp),
    val large: RoundedCornerShape = RoundedCornerShape(22.dp),

)


val LocalShapes = compositionLocalOf { Shapes() }

val MaterialTheme.shape: Shapes
    @Composable
    @ReadOnlyComposable
    get() = LocalShapes.current