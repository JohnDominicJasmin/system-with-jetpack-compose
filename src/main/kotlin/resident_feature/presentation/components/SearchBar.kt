package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Black700
import resident_feature.presentation.theme.Blue700
import resident_feature.presentation.theme.ErrorColor
import resident_feature.presentation.theme.Gray300

@Composable
fun SearchBar(value: TextFieldValue, onChangeValue: (TextFieldValue) -> Unit, searchButtonOnClick: () -> Unit) {


    Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.wrapContentSize()){

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Search",
            color = Gray300,
            fontSize = MaterialTheme.typography.button.fontSize,
            textAlign = TextAlign.Center
        )

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(50.dp)) {

        TextField(
            modifier = Modifier.fillMaxHeight().width(350.dp),
            value = value,
            shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp),
            onValueChange = onChangeValue,
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                backgroundColor = Black700,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                cursorColor = Color.White,
                errorIndicatorColor = ErrorColor,
                errorCursorColor = ErrorColor,
                errorLabelColor = ErrorColor,
                errorLeadingIconColor = ErrorColor,
                errorTrailingIconColor = ErrorColor

            )
        )

        Button(
            onClick = searchButtonOnClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue700, contentColor = Color.White),
            modifier = Modifier.fillMaxHeight().width(50.dp),
            shape = RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp, topEnd = 12.dp, bottomEnd = 12.dp),
            contentPadding = PaddingValues(all = 2.dp)
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Button Icon")
        }

    }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    val searchValue = remember { mutableStateOf(TextFieldValue()) }
    SearchBar(value = searchValue.value, onChangeValue = {
        searchValue.value = it
    }, searchButtonOnClick = {

    })
}
