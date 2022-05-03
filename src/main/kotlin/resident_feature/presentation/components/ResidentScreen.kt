package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import resident_feature.presentation.ResidentDialogState
import resident_feature.presentation.ResidentEvent
import resident_feature.presentation.ResidentEventResult
import resident_feature.presentation.ResidentViewModel
import resident_feature.presentation.theme.*
import resident_feature.util.DrawableResource

@Composable
@Preview
fun ResidentScreen() {
    val viewModel = remember { ResidentViewModel()}
    val scope = rememberCoroutineScope()
    val inputState = viewModel.inputState.value
    val alertDialogState = remember{mutableStateOf(ResidentDialogState())}


    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { residentEvent ->
            when(residentEvent){
                is ResidentEventResult.SuccessDialog -> {
                    alertDialogState.value = ResidentDialogState(
                        title = residentEvent.title,
                        description = residentEvent.description,
                        imageResource = DrawableResource.SuccessIcon.resource,
                        color = Green1000
                    )

                }
                is ResidentEventResult.ErrorDialog -> {
                    alertDialogState.value = ResidentDialogState(
                        title = residentEvent.title,
                        description = residentEvent.description,
                        imageResource = DrawableResource.ErrorIcon.resource,
                        color = Red300
                    )
                }
                is ResidentEventResult.WarningDialog -> {
                    alertDialogState.value = ResidentDialogState(
                        title = residentEvent.title,
                        description = residentEvent.description,
                        imageResource = DrawableResource.WarningIcon.resource,
                        color = Yellow700
                    )
                }
            }

        }
    }


    with(alertDialogState.value){
        if(title.isNotEmpty()){
            SimpleAlertDialog(
                title = title,
                description = description,
                color = color!!,
                imageResource = imageResource
            )
        }
    }

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
                        viewModel.onEvent(event = ResidentEvent.SearchResident)
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
                    imageResource =  inputState.imageName,
                    isUpdateButtonEnabled = inputState.isUpdateButtonEnable,
                    isSaveButtonEnabled = inputState.isSaveButtonEnable,
                    browseButtonOnClick = { viewModel.onEvent(event = ResidentEvent.BrowseImage) },
                    saveButtonOnClick = { viewModel.onEvent(event = ResidentEvent.SaveResident)},
                    updateButtonOnClick = { viewModel.onEvent(event = ResidentEvent.UpdateResident)})
            }

            if(inputState.isLoading) {
                CircularProgressIndicator(color = Blue700)
            }

            TableItemsArea(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 25.dp),
                residentViewModel = viewModel)


        }

    }

}