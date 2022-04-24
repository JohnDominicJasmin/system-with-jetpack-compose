package resident_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Gray300


@Composable
fun InputArea(modifier: Modifier) {

    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {


            TextFieldItem(
                modifier = Modifier.weight(3.5f, fill = false),
                labelText = "Full Name",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )

            DropDownList(
                labelText = "Sex",
                modifier = Modifier.weight(3.5f),
                items = listOf("Male", "Female"),
                selectedIndex = 0,
                onSelectedItemIndex = {

                })



            DropDownList(
                labelText = "Suffix",
                modifier = Modifier.weight(3.5f),
                items = listOf("None", "Jr", "Sr", "III", "IV", "V"),
                selectedIndex = 0,
                onSelectedItemIndex = {

                })


        }



        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Address",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )

            TextFieldItem(
                modifier = Modifier.weight(3.0f, fill = false),
                labelText = "Religion",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )

            DropDownList(
                labelText = "Civil Status",
                modifier = Modifier.weight(2.5f),
                items = listOf("Single", "Married", "Widowed","Divorced"),
                selectedIndex = 0,
                onSelectedItemIndex = {

                })
        }


        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Contact Number",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )

            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Purok",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )


            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Occupation",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )
        }


        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            DropDownList(
                labelText = "Voter",
                modifier = Modifier.weight(2.5f),
                items = listOf("No", "Yes"),
                selectedIndex = 0,
                onSelectedItemIndex = {

                })


            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Citizenship",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )

            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Date of birth",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                placeholder = {
                    Text(
                        text = "MM/DD/YY",
                        color = Gray300,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.caption
                    )
                }
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            DropDownList(
                labelText = "Senior Citizen",
                modifier = Modifier.weight(2.5f),
                items = listOf("No", "Yes"),
                selectedIndex = 0,
                onSelectedItemIndex = {

                })


            TextFieldItem(
                modifier = Modifier.weight(4.5f, fill = false),
                labelText = "Educational Attainment",
                textFieldValue = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
            )
            Spacer(modifier = Modifier.weight(4.5f))


        }

    }
}



