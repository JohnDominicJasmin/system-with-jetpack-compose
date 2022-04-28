package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import resident_feature.presentation.ResidentEvent
import resident_feature.presentation.ResidentViewModel
import resident_feature.presentation.theme.Black800

@Composable
@Preview
fun ResidentScreen() {
    val viewModel = remember { ResidentViewModel()}
    val scope = rememberCoroutineScope()
    val inputState = viewModel.inputState.value


    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Black800),
        contentAlignment = Alignment.TopCenter) {


        Column(
            modifier = Modifier
                .fillMaxWidth(0.99f)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.99f)) {


                ResetButton(buttonOnClick = {
                    scope.launch {
                        viewModel.onEvent(event = ResidentEvent.ResetResident)
                    }
                })

                Spacer(modifier = Modifier.weight(0.6f))

                SearchBar(value = inputState.searchQuery, onChangeValue = {
                   viewModel.onEvent(event = ResidentEvent.EnteredSearchValue(searchQuery = it))
                },
                    searchButtonOnClick = {

                    })

            }


            Row(
                verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 15.dp)) {

                InputArea(modifier = Modifier.weight(0.83f), residentViewModel = viewModel)

                SelectProfilePictureArea(
                    modifier = Modifier
                        .padding(start = 18.dp, top = 20.dp)
                        .weight(0.17f),
                    errorMessage = inputState.profileImageErrorMessage,
                    imageResource = inputState.imagePath + inputState.imageName,
                    browseButtonOnClick = {
                        viewModel.onEvent(event = ResidentEvent.BrowseImage)
                    },
                    saveButtonOnClick = { viewModel.onEvent(event = ResidentEvent.SaveResident)},
                    updateButtonOnClick = { viewModel.onEvent(event = ResidentEvent.UpdateResident)})


            }

            TableItemsArea(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 25.dp),
                residentTableState = viewModel.tableState.value)


        }

    }

}