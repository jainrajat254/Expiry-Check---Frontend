package com.example.expirycheck.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expirycheck.barcode.BarcodeViewModel
import com.example.expirycheck.screens.AddItemsScreen
import com.example.expirycheck.screens.HomeScreen
import com.example.expirycheck.screens.ItemListScreen
import com.example.expirycheck.screens.LoginScreen
import com.example.expirycheck.screens.PasswordSettings
import com.example.expirycheck.screens.RegisterScreen
import com.example.expirycheck.screens.SettingsScreen
import com.example.expirycheck.viewmodel.PreferencesViewModel
import com.example.expirycheck.viewmodel.UserViewModel

@Composable
fun App() {
    val navController = rememberNavController()
    val vm = hiltViewModel<UserViewModel>()
    val pvm: PreferencesViewModel = hiltViewModel()
    val bvm: BarcodeViewModel = hiltViewModel()

        NavHost(navController = navController, startDestination = Routes.Login.routes) {
            composable(Routes.Login.routes) {
                LoginScreen(navController = navController, vm = vm)
            }
            composable(Routes.Register.routes) {
                RegisterScreen(navController = navController, vm = vm)
            }
            composable(Routes.Home.routes) {
                HomeScreen(navController = navController)
            }
            composable(Routes.List.routes) {
                ItemListScreen(navController = navController, vm = vm)
            }
            composable(Routes.AddItems.routes) {
                AddItemsScreen(navController = navController, vm = vm, bvm)
            }
            composable(Routes.Settings.routes) {
                SettingsScreen(navController = navController, pvm = pvm)
            }
            composable(Routes.Password.routes) {
                PasswordSettings()
            }

        }
}

