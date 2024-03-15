package br.com.thuler.vagalivre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.thuler.vagalivre.models.LoginViewModel
import br.com.thuler.vagalivre.models.ProfileViewModel
import br.com.thuler.vagalivre.screens.HomeScreen
import br.com.thuler.vagalivre.screens.LoginScreen
import br.com.thuler.vagalivre.screens.ParkingScreen
import br.com.thuler.vagalivre.screens.ProfileScreen
import br.com.thuler.vagalivre.screens.SettingsScreen
import br.com.thuler.vagalivre.ui.theme.VagaLivreTheme

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
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login"){ LoginScreen(viewModel = LoginViewModel(), navController = navController) }
                        composable(route = "home") { HomeScreen(navController) }
                        composable(route = "profile") { ProfileScreen(viewModel = ProfileViewModel(), navController = navController) }
                        composable(route = "settings") { SettingsScreen(navController) }
                        composable(route = "parking") { ParkingScreen(navController) }
                    }
                }
            }
        }
    }
}