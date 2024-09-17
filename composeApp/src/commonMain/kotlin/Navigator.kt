import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.registerAndStart.start_feature.screen.StartScreen

@Composable
fun navigator(){

    Navigator(screen = StartScreen)
}