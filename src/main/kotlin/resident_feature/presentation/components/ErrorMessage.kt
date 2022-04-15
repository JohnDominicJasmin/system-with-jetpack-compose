package resident_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.ErrorColor

@Composable
fun ErrorMessage(errorMessage: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Default.Warning,
            tint = ErrorColor,
            modifier = Modifier.size(12.dp),
            contentDescription = "Icon error")
        Text(
            text = errorMessage,
            color = ErrorColor,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(1.2.dp)
        )
    }
}