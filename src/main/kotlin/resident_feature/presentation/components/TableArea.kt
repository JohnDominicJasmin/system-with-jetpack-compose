package resident_feature.presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import resident_feature.common.Constants.ADDRESS_ROW_WEIGHT
import resident_feature.common.Constants.AGE_ROW_WEIGHT
import resident_feature.common.Constants.FULL_NAME_ROW_WEIGHT
import resident_feature.common.Constants.ICONS_ROW_WEIGHT
import resident_feature.common.Constants.OCCUPATION_ROW_WEIGHT
import resident_feature.common.Constants.PUROK_ROW_WEIGHT
import resident_feature.common.Constants.SEX_ROW_WEIGHT
import resident_feature.common.Constants.VOTER_ROW_WEIGHT
import resident_feature.domain.model.Resident
import resident_feature.domain.util.OrderType
import resident_feature.domain.util.OrderTypes
import resident_feature.presentation.ResidentEvent
import resident_feature.presentation.ResidentViewModel
import resident_feature.presentation.theme.Black800
import resident_feature.presentation.theme.Blue400
import resident_feature.presentation.theme.Gray200
import resident_feature.presentation.theme.Gray600
import resident_feature.util.DrawableResource


@Composable
fun TableItemsArea(modifier: Modifier, residentViewModel: ResidentViewModel) {

    val inputState = residentViewModel.inputState.value
    val residentTableState = residentViewModel.tableState.value
    val backgroundColorState = remember { mutableStateOf(Blue400) }

    Card(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        backgroundColor = Color.Unspecified,
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            TitleArea(residentViewModel = residentViewModel)

            if (residentTableState.residents.isEmpty()) {
                NoDataDisplayText()
            }

            LazyColumn {
                itemsIndexed(residentTableState.residents.filter {
                    it.fullName.contains(inputState.searchQuery.text, ignoreCase = true)
                }) { index, item ->
                    backgroundColorState.value = if (index % 2 == 0) {
                        Blue400
                    } else {
                        Gray600
                    }
                    TableItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 5.dp),
                        resident = item,
                        backgroundColor = backgroundColorState.value,
                        residentViewModel = residentViewModel
                    )


                }
            }


        }
    }
}


@Composable
private fun NoDataDisplayText() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "No data to display",
            color = Gray200,

            )
    }
}

@Composable
private fun TableItem(
    modifier: Modifier,
    resident: Resident,
    backgroundColor: Color,
    residentViewModel: ResidentViewModel
) {

    val confirmationDialogState = remember { mutableStateOf(false) }

    Row(modifier = Modifier.background(backgroundColor).clickable {
        residentViewModel.onEvent(event = ResidentEvent.SelectResidentRow(resident))
    }) {
        Row(
            modifier = modifier.horizontalScroll(state = rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = resident.fullName,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(FULL_NAME_ROW_WEIGHT),

                )


            Text(
                text = resident.sex,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(SEX_ROW_WEIGHT)
            )

            Text(
                text = resident.age,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(AGE_ROW_WEIGHT)
            )

            Text(
                text = resident.purok,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(PUROK_ROW_WEIGHT)
            )
            Text(
                text = resident.occupation,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(OCCUPATION_ROW_WEIGHT)
            )

            Text(
                text = resident.voter,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(VOTER_ROW_WEIGHT)
            )

            Text(
                text = resident.address,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(ADDRESS_ROW_WEIGHT)
            )


            Row(
                modifier = Modifier
                    .weight(ICONS_ROW_WEIGHT),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(13.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(DrawableResource.EditIcon.resource),
                    contentDescription = "Edit Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        residentViewModel.onEvent(event = ResidentEvent.EditResident(resident))
                    }
                )
                Icon(
                    painter = painterResource(DrawableResource.DeleteIcon.resource),
                    contentDescription = "Delete Icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
//                        residentViewModel.onEvent(event = ResidentEvent.DeleteResident(resident.id))
                        confirmationDialogState.value = true
                    }
                )

                if (confirmationDialogState.value) {
                    ConfirmationDialog(
                        title = "Are you sure?",
                        description = "Do you really want to delete these records? This process cannot be undone.",
                        onConfirm = {
                            residentViewModel.onEvent(event = ResidentEvent.DeleteResident(resident.id))
                            confirmationDialogState.value = false
                        },
                        onCancel = {
                            confirmationDialogState.value = false
                        }
                    )
                }


            }

        }
    }


}

@Composable
private fun TitleArea(residentViewModel: ResidentViewModel) {

    val state = residentViewModel.tableState.value

    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {


        val firstNameSortIcon = remember { mutableStateOf(DrawableResource.SortIconAscending.resource) }
        TitleItem(
            modifier = Modifier.weight(FULL_NAME_ROW_WEIGHT),
            title = "First name",
            iconResource = firstNameSortIcon.value,
            onClick = {
                state.columnOrder?.let { currentOrder ->
                    if (currentOrder == OrderTypes.FullNameColumnOrder(orderType = OrderType.Ascending)) {
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortFullName(
                                orderTypes = OrderTypes.FullNameColumnOrder(
                                    orderType = OrderType.Descending
                                )
                            )
                        )
                        firstNameSortIcon.value = DrawableResource.SortIconAscending.resource


                    } else {
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortFullName(
                                orderTypes = OrderTypes.FullNameColumnOrder(
                                    orderType = OrderType.Ascending
                                )
                            )
                        )
                        firstNameSortIcon.value = DrawableResource.SortIconDescending.resource


                    }
                }
            })


        val sexToggleIcon = remember { mutableStateOf(DrawableResource.NotToggledIcon.resource) }
        TitleItem(
            modifier = Modifier.weight(SEX_ROW_WEIGHT),
            title = "Sex",
            iconResource = sexToggleIcon.value,
            onClick = {
                state.columnOrder?.let { currentOrder ->
                    if (currentOrder == OrderTypes.SexColumnOrder(orderType = OrderType.Ascending)) {
                        sexToggleIcon.value = DrawableResource.NotToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.ToggleSex(
                                orderTypes = OrderTypes.SexColumnOrder(
                                    orderType = OrderType.Descending
                                )
                            )
                        )
                    } else {
                        sexToggleIcon.value = DrawableResource.ToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.ToggleSex(
                                orderTypes = OrderTypes.SexColumnOrder(
                                    orderType = OrderType.Ascending
                                )
                            )
                        )
                    }
                }

            })

        val ageToggleIcon = remember { mutableStateOf(DrawableResource.NotToggledIcon.resource) }
        TitleItem(
            modifier = Modifier.weight(AGE_ROW_WEIGHT),
            title = "Age",
            iconResource = ageToggleIcon.value,
            onClick = {
                state.columnOrder?.let { currentOrder ->
                    if (currentOrder == OrderTypes.AgeColumnOrder(orderType = OrderType.Ascending)) {
                        ageToggleIcon.value = DrawableResource.NotToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortAge(
                                orderTypes = OrderTypes.AgeColumnOrder(
                                    orderType = OrderType.Descending
                                )
                            )
                        )
                    } else {
                        ageToggleIcon.value = DrawableResource.ToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortAge(
                                orderTypes = OrderTypes.AgeColumnOrder(
                                    orderType = OrderType.Ascending
                                )
                            )
                        )

                    }
                }
            })

        val purokSortIcon = remember { mutableStateOf(DrawableResource.SortIconAscending.resource) }
        TitleItem(
            modifier = Modifier.weight(PUROK_ROW_WEIGHT),
            title = "Purok",
            iconResource = purokSortIcon.value,
            onClick = {
                state.columnOrder?.let { currentOrder ->
                    if (currentOrder == OrderTypes.PurokColumnOrder(orderType = OrderType.Ascending)) {
                        purokSortIcon.value = DrawableResource.SortIconAscending.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortPurok(
                                orderTypes = OrderTypes.PurokColumnOrder(
                                    orderType = OrderType.Descending
                                )
                            )
                        )
                    } else {
                        purokSortIcon.value = DrawableResource.SortIconDescending.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.SortPurok(
                                orderTypes = OrderTypes.PurokColumnOrder(
                                    orderType = OrderType.Ascending
                                )
                            )
                        )
                    }
                }
            })

        TitleItem(
            modifier = Modifier.weight(OCCUPATION_ROW_WEIGHT),
            title = "Occupation",
            onClick = {

            })


        val voterToggleIcon = remember { mutableStateOf(DrawableResource.NotToggledIcon.resource) }
        TitleItem(
            modifier = Modifier.weight(VOTER_ROW_WEIGHT),
            title = "Voter",
            iconResource = voterToggleIcon.value,
            onClick = {
                state.columnOrder?.let { currentOrder ->
                    if (currentOrder == OrderTypes.VoterColumnOrder(orderType = OrderType.Ascending)) {
                        voterToggleIcon.value = DrawableResource.NotToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.ToggleVoter(
                                orderTypes = OrderTypes.VoterColumnOrder(
                                    orderType = OrderType.Descending
                                )
                            )
                        )
                    } else {
                        voterToggleIcon.value = DrawableResource.ToggledIcon.resource
                        residentViewModel.onEvent(
                            event = ResidentEvent.ToggleVoter(
                                orderTypes = OrderTypes.VoterColumnOrder(
                                    orderType = OrderType.Ascending
                                )
                            )
                        )
                    }
                }
            })

        TitleItem(
            modifier = Modifier.weight(ADDRESS_ROW_WEIGHT),
            title = "Address",
            onClick = {

            })

        TitleItem(
            modifier = Modifier.weight(ICONS_ROW_WEIGHT),
            title = "",
            onClick = {

            })

    }
}

@Composable
private fun TitleItem(modifier: Modifier, title: String, iconResource: String? = null, onClick: () -> Unit) {

    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Black800, contentColor = Color.White),
        border = BorderStroke(0.9.dp, color = Gray200)
    ) {


        Text(
            text = title, modifier = Modifier
                .weight(0.85f)
                .padding(all = 8.dp), textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        iconResource?.let { resource ->
            Icon(painter = painterResource(resource), contentDescription = "Icon", tint = Color.Unspecified)
        }
    }
}


@Preview
@Composable
private fun PreviewTitle() {
    TitleItem(
        modifier = Modifier.wrapContentSize(),
        title = "First name",
        iconResource = DrawableResource.SortIconDescending.resource,
        onClick = {

        })
}