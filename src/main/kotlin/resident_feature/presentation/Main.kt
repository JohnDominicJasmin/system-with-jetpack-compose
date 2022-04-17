package resident_feature.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import resident_feature.presentation.components.ResidentScreen
import java.awt.Dimension


fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Barangay System",
        resizable = true,
        state = rememberWindowState(placement = WindowPlacement.Maximized)
    ) {

        this.window.minimumSize = Dimension(1200,700)
        MaterialTheme {
            ResidentScreen()


        }

    }
}
