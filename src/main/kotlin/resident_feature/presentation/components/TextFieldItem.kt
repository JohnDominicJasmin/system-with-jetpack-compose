package resident_feature.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Black700
import resident_feature.presentation.theme.ErrorColor
import resident_feature.presentation.theme.Gray300

@Composable
fun TextFieldItem(
    modifier : Modifier,
    errorMessage: String = "",
    labelText: String,
    placeholder: @Composable (() -> Unit)? = null,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,


) {
    val hasError = errorMessage.isNotEmpty()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {


        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = labelText,
            color = Gray300,
            fontSize = MaterialTheme.typography.button.fontSize,
            textAlign = TextAlign.Center
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFieldValue,
            shape = RoundedCornerShape(12.dp),
            onValueChange = onValueChange,
            singleLine = true,
            maxLines = 1,
            placeholder = placeholder,
    isError = hasError,
    colors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        backgroundColor = Black700,
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
@Composable
fun ErrorMessage(errorMessage: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Warning,
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