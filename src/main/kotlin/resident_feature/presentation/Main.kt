package resident_feature.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import resident_feature.presentation.components.ResidentScreen
import java.awt.Dimension
import java.awt.Toolkit


fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Barangay System",
        resizable = true,
        state = rememberWindowState(placement = WindowPlacement.Maximized)) {

        val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize

        with(this.window){
            val  currentHeight =  screenSize.height
            val currentWidth =  screenSize.width
            minimumSize = Dimension(currentWidth,currentHeight)
        }


        MaterialTheme {
            ResidentScreen()


        }

    }
}
