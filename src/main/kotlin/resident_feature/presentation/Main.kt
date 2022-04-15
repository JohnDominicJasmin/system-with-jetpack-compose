package resident_feature.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import resident_feature.presentation.components.ResidentScreen


fun main() = application {

    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(onCloseRequest = ::exitApplication, state = windowState, title = "Barangay System", resizable = true) {
        MaterialTheme {
            ResidentScreen()


        }

    }
}
