import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.example.project.core.StaticDate
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        LaunchedEffect(Unit) {
                val people = withContext(Dispatchers.IO) {
                    ServiceLocator.peopleDao.getAllPeople()
                }
                if (people.isNotEmpty()) {
                    people.forEach { it ->
                        StaticDate.listWallets.add(it.wallet)
                    }
                    println("Fetched people: $people")
                }
                    val goal = withContext(Dispatchers.IO) {
                        ServiceLocator.goalDao.getAllGoal()
                    }
                    if (goal.isNotEmpty()) {
                        goal.forEach { it ->
                            StaticDate.listGoals.add(it.goal)
                        }
                        println("Fetched people: $people")
                    }

        }
        navigator()


    /*LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(people) { person ->
                Text(
                    text = person.,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch {
                                peopleDao.delete(person)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }*/
    }
}