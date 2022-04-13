package resident_feature.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import resident_feature.presentation.theme.PrimaryColor

@Composable
fun AddNewButton(modifier: Modifier, buttonOnClick: () -> Unit){
   Button(
      onClick = buttonOnClick,
      colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = Color.White), modifier = Modifier){
      Text(text = "Add New", color = Color.White)



   }
}
