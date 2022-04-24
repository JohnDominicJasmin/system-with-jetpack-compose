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
import androidx.compose.ui.unit.dp
import resident_feature.presentation.theme.Black800

@Composable
@Preview
fun ResidentScreen() {


    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Black800),
        contentAlignment = Alignment.TopCenter) {


        Column(
            modifier = Modifier
                .fillMaxWidth(0.99f)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            val searchValue = remember { mutableStateOf(TextFieldValue()) }

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.99f)) {


                ResetButton(buttonOnClick = {

                })

                Spacer(modifier = Modifier.weight(0.6f))

                SearchBar(value = searchValue.value, onChangeValue = {
                    searchValue.value = it
                },
                    searchButtonOnClick = {

                    })

            }


            Row(
                verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 15.dp)
            ) {

                InputArea(modifier = Modifier.weight(0.83f))
                SelectProfilePictureArea(
                    modifier = Modifier.padding(start = 18.dp, top = 20.dp).weight(0.17f),
                    browseButtonOnClick = {},
                    saveButtonOnClick = {},
                    updateButtonOnClick = {})


            }

            TableItemsArea(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 25.dp))


        }

    }

}