import database.goals_base.GoalDao
import database.profile_base.ProfileDao
import database.wallets_base.PeopleDao

object ServiceLocator {
    lateinit var peopleDao: PeopleDao
    lateinit var goalDao: GoalDao
    lateinit var profileDao: ProfileDao
}