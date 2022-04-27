package resident_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Black700
import resident_feature.presentation.theme.ErrorColor
import resident_feature.presentation.theme.Gray300
import resident_feature.util.DrawableResource


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
                selectedValue = "",
                onSelectedItem = {
                    //
                })



            DropDownList(
                labelText = "Suffix",
                modifier = Modifier.weight(3.5f),
                items = listOf("None", "Jr", "Sr", "III", "IV", "V"),
                selectedValue = "",
                onSelectedItem = {

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
                selectedValue = "",
                onSelectedItem = {

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
                selectedValue = "",
                onSelectedItem = {

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
                selectedValue = "",
                onSelectedItem = {

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



@Composable
fun DropDownList(
    labelText:String,
    modifier: Modifier,
    items: List<String>,
    selectedValue: String,
    onSelectedItem: (String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)) {

        val icon = if (expanded)
            DrawableResource.TrailingIconUp.resource
        else
            DrawableResource.TrailingIconDown.resource

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = labelText,
            color = Gray300,
            fontSize = MaterialTheme.typography.button.fontSize,
            textAlign = TextAlign.Center
        )


        Button(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(bottom = 3.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Black700, contentColor = Gray300),
            onClick = { expanded = !expanded }) {
            Text(
                text = selectedValue,
                modifier = Modifier.weight(0.9f)
            )
            Icon(painter = painterResource(icon), contentDescription = "Expand Icon Indicator")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Black700)
                .wrapContentSize()
                .padding(all = 4.dp)
        ) {

            items.forEachIndexed { _, item ->
                DropdownMenuItem(onClick = {
                    onSelectedItem(item)
                    expanded = !expanded
                }) {

                    Text(text = item, color = Color.White)
                }
            }
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