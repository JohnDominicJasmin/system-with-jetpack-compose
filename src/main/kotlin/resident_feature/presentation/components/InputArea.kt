package resident_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputArea(modifier: Modifier) {

    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.5.dp)) {



            TextFieldItem(
                modifier = Modifier.weight(3.5f, fill = false),
                labelText = "Full Name",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                clearIconOnClick = {

                })

           DropDownList(
               labelText = "Sex",
               modifier = Modifier.weight(3.5f),
               items = listOf("Male", "Female"),
               onSelectedItem = {

           })



            DropDownList(
                labelText = "Suffix",
                modifier = Modifier.weight(3.5f),
                items = listOf("Sr", "Jr", "III", "IV", "V"),
                onSelectedItem = {

            })

        }




        }
}
