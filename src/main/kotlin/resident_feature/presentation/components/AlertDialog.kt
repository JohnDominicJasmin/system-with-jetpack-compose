package resident_feature.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.rememberDialogState
import resident_feature.presentation.theme.Black500
import resident_feature.presentation.theme.Black800
import resident_feature.presentation.theme.Black850
import resident_feature.presentation.theme.Blue550
import resident_feature.util.DrawableResource

@Composable
fun SimpleAlertDialog(
    title: String,
    description: String,
    color: Color,
    imageResource: String,
) {

    val dialogState = remember { mutableStateOf(true) }

    if (dialogState.value) {
        Dialog(
            onCloseRequest = {
                dialogState.value = false
            },
            state = rememberDialogState(width = 500.dp, height = 327.dp),
            title = "",
            undecorated = false,
            resizable = false,
            transparent = false
        ) {

            Card(
                modifier = Modifier.fillMaxSize(),
                backgroundColor = Black850,
                elevation = 4.dp,
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.background(color = color).weight(0.35f).fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(resourcePath = imageResource),
                            contentDescription = "Icon Dialog",
                            tint = Color.Unspecified,
                            modifier = Modifier.wrapContentSize()
                        )

                    }
                    Column(
                        modifier = Modifier.background(color = Black850).weight(0.75f),
                        verticalArrangement = Arrangement.spacedBy(18.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Text(
                            text = description,
                            style = MaterialTheme.typography.body2,
                            color = Black500,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                        )

                        OutlinedButton(
                            onClick = { dialogState.value = false},
                            modifier = Modifier.width(140.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(width = 2.dp, color = color),
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Black800)
                        ) {

                            Text(
                                text = "Ok",
                                style = MaterialTheme.typography.body2,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(all = 2.dp)
                            )
                        }


                    }
                }
            }
        }
    }
}


@Composable
fun tea(){

}
@Composable
fun ConfirmationDialog(title: String,
                       description: String,
                       onConfirm: () -> Unit,
                       onCancel: () -> Unit) {

            Dialog(
                onCloseRequest = onCancel,
                state = rememberDialogState(width = 500.dp, height = 340.dp),
                title = "",
                undecorated = false,
                resizable = false,
                transparent = false,) {

                Card(
                    modifier = Modifier.fillMaxSize().shadow(1.dp, RoundedCornerShape(0.dp)),
                    backgroundColor = Black850,
                    elevation = 1.dp,
                    shape = RoundedCornerShape(0.dp),

                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Spacer(modifier = Modifier.height(10.dp))

                        Icon(
                            painter = painterResource(DrawableResource.QuestionIcon.resource),
                            contentDescription = "Question Icon",
                            tint = Color.Unspecified,
                            modifier = Modifier.wrapContentSize()
                        )


                        Text(
                            text = title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Text(
                            text = description,
                            style = MaterialTheme.typography.body2,
                            color = Black500,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 35.dp, end = 35.dp)
                        )

                        Row(modifier = Modifier.padding(top = 7.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)){
                            OutlinedButton(
                                onClick = onCancel,
                                modifier = Modifier.width(140.dp),
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(width = 2.dp, color = Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Black800)
                            ) {

                                Text(
                                    text = "Cancel",
                                    style = MaterialTheme.typography.body2,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(all = 2.dp)
                                )
                            }


                            Button(
                                onClick = onConfirm,
                                modifier = Modifier.width(140.dp),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Blue550)){
                                Text(
                                    text = "Delete",
                                    style = MaterialTheme.typography.body2,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(all = 2.dp)
                                )
                            }

                        }

                    }

                }
    }
}

