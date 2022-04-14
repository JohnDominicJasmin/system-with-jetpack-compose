package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import resident_feature.presentation.theme.Black800

@Composable
@Preview
fun ResidentScreen() {


    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Black800),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.98f) ,
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            val searchValue = remember { mutableStateOf(TextFieldValue()) }

            Row(verticalAlignment = Alignment.CenterVertically) {


                AddNewButton(buttonOnClick = {

                })

                Spacer(modifier = Modifier.weight(0.6f))

                SearchBar(value = searchValue.value, onChangeValue = {

                },
                searchButtonOnClick = {

                })


            }

        }

    }

}