package br.com.vagalivre.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.vagalivre.app.models.LoginViewModel
import br.com.vagalivre.app.models.ProfileViewModel
import br.com.vagalivre.app.models.SharedViewModel
import br.com.vagalivre.app.screens.HomeScreen
import br.com.vagalivre.app.screens.LoginScreen
import br.com.vagalivre.app.screens.ParkingScreen
import br.com.vagalivre.app.screens.ProfileScreen
import br.com.vagalivre.app.screens.SettingsScreen
import br.com.vagalivre.app.ui.theme.VagaLivreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VagaLivreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    val sharedViewModel: SharedViewModel by viewModels()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login"){ LoginScreen(viewModel = LoginViewModel(), navController = navController) }
                        composable(
                            route = "home/{username}/{email}",
                            arguments = listOf(
                                navArgument("username") {type = NavType.StringType},
                                navArgument("email") {type = NavType.StringType}
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            val email = it.arguments?.getString("email")
                            HomeScreen(navController, username!!, email!!, sharedViewModel)
                        }
                        composable(
                            route = "profile/{username}/{email}",
                            arguments = listOf(
                                navArgument("username") {type = NavType.StringType},
                                navArgument("email") {type = NavType.StringType}
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            val email = it.arguments?.getString("email")
                            ProfileScreen(viewModel = ProfileViewModel(), navController = navController, username = username!!, email = email!!)
                        }
                        composable(
                            route = "settings/{username}/{email}",
                            arguments = listOf(
                                navArgument("username") {type = NavType.StringType},
                                navArgument("email") {type = NavType.StringType}
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            val email = it.arguments?.getString("email")
                            SettingsScreen(navController, username!!, email!!)
                        }
                        composable(
                            route = "parking/{username}/{email}",
                            arguments = listOf(
                                navArgument("username") {type = NavType.StringType},
                                navArgument("email") {type = NavType.StringType},
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            val email = it.arguments?.getString("email")
                            ParkingScreen(navController, username!!, email!!, sharedViewModel)
                        }

                    }
                }
            }
        }
    }
}