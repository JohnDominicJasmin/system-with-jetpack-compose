package resident_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import resident_feature.presentation.DrawableResource
import resident_feature.presentation.theme.Black700
import resident_feature.presentation.theme.Gray300

@Composable
fun DropDownList(
    labelText:String,
    modifier: Modifier,
    items: List<String>,
    selectedIndex: Int,
    onSelectedItemIndex: (Int) -> Unit) {

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
                text = items[selectedIndex],
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

            items.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    onSelectedItemIndex(index)
                    expanded = !expanded
                }) {

                    Text(text = item, color = Color.White)
                }
            }
        }
    }

}

