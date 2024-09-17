import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import database.getGoalDatabase
import database.getPeopleDatabase

fun MainViewController() = ComposeUIViewController {
     val daoPeople = remember { getPeopleDatabase().peopleDao() }
     val daoGoal = remember { getGoalDatabase().goalDao() }
    //ServiceLocator.peopleDao = dao
    App()
}