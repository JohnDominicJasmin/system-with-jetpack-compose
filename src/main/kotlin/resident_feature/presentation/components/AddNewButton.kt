package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Blue700
import resident_feature.presentation.theme.shape

@Composable
fun AddNewButton( buttonOnClick: () -> Unit) {

   Button(
      onClick = buttonOnClick,
      colors = ButtonDefaults.buttonColors(backgroundColor = Blue700, contentColor = Color.White),
      modifier = Modifier
         .size(height = 50.dp, width = 220.dp)
         .shadow(elevation = 12.dp, shape = MaterialTheme.shapes.medium, ),
      shape = MaterialTheme.shape.medium) {

      Text(
         text = "Add New",
         color = Color.White,
         style = MaterialTheme.typography.button,
         fontWeight = FontWeight.SemiBold,
         modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 30.dp, end = 30.dp),

      )


   }
}
@Preview
@Composable
fun Preview(){
   AddNewButton(){

   }
}

