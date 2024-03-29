package uk.co.jamiecruwys.showcase.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import timber.log.Timber
import uk.co.jamiecruwys.navigation.Destinations

@Composable
fun homeScreen(navController: NavController) {
    Timber.d("Showing home screen")

    val paddingModifier = Modifier.padding(16.dp)

    Column(modifier = paddingModifier) {
        Text(text = "Hello World!", modifier = paddingModifier)
        Button(
            modifier = paddingModifier,
            onClick = { navController.navigate(Destinations.Dogs.route) }
        ) {
            Text("Dogs")
        }
        Button(
            modifier = paddingModifier,
            onClick = { navController.navigate(Destinations.Cats.route) }
        ) {
            Text("Cats")
        }
    }
}
