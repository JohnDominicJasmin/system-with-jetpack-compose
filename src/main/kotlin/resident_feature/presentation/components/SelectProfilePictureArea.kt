package resident_feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Blue700
import resident_feature.presentation.theme.Blue950
import resident_feature.presentation.theme.Gray200

@Composable
fun SelectProfilePictureArea(
    modifier: Modifier,
    errorMessage: String,
    imageResource: String,
    isUpdateButtonEnabled: Boolean,
    isSaveButtonEnabled: Boolean,
    browseButtonOnClick: () -> Unit,
    saveButtonOnClick: () -> Unit,
    updateButtonOnClick: () -> Unit
) {

    val hasError = errorMessage.isNotEmpty()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {



        Column {
            Surface(modifier = Modifier.fillMaxHeight(0.3f), shape = RoundedCornerShape(15.dp)) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = "Picture Placeholder ",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            if (hasError) {
                ErrorMessage(errorMessage)
            }
        }

        ButtonItem(
            modifier = Modifier.fillMaxWidth(0.9f),
            buttonOnClick = browseButtonOnClick,
            buttonText = "Browse",
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ButtonItem(
                modifier = Modifier.weight(0.5f, fill = true),
                buttonOnClick = updateButtonOnClick,
                buttonText = "Update",
                isEnabled = isUpdateButtonEnabled
            )
            ButtonItem(
                modifier = Modifier.weight(0.5f, fill = true),
                buttonOnClick = saveButtonOnClick,
                buttonText = "Save",
                isEnabled = isSaveButtonEnabled
            )
        }


    }

}

@Composable
private fun ButtonItem(isEnabled: Boolean = true, modifier: Modifier, buttonOnClick: () -> Unit, buttonText: String) {
    Button(
        onClick = buttonOnClick,
        enabled = isEnabled,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Blue700,
            contentColor = Color.White,
            disabledBackgroundColor = Blue950,
            disabledContentColor = Gray200
        )) {

        Text(
            text = buttonText,
            style = MaterialTheme.typography.button,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(all = 6.dp)


        )
    }
}


