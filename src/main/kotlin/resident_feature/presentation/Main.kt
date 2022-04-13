import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import resident_feature.presentation.components.ResidentScreen


fun main() = application {

    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            ResidentScreen()

        }

    }
}
