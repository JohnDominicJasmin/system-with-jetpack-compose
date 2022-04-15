package resident_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Black600
import resident_feature.presentation.theme.ErrorColor
import resident_feature.presentation.theme.Gray300

@Composable
fun TextFieldItem(
    modifier : Modifier,
    errorMessage: String = "",
    labelText: String,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    clearIconOnClick: () -> Unit
) {
    val hasError = errorMessage.isNotEmpty()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {


        Text(
            text = labelText,
            color = Gray300,
            fontSize = MaterialTheme.typography.button.fontSize,
            textAlign = TextAlign.Center
        )

        TextField(
            modifier = Modifier.height(50.dp).fillMaxWidth(),
            value = textFieldValue,
            shape = RoundedCornerShape(12.dp),
            onValueChange = onValueChange,
            singleLine = true,
            maxLines = 1,
    isError = hasError,
    colors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        backgroundColor = Black600,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        cursorColor = Color.White,
        errorIndicatorColor = ErrorColor,
        errorCursorColor = ErrorColor,
        errorLabelColor = ErrorColor,
        errorLeadingIconColor = ErrorColor,
        errorTrailingIconColor = ErrorColor

    )
    )
    if (hasError) {
        ErrorMessage(errorMessage)
    }
}
}