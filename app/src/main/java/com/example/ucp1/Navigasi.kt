package com.example.ucp1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.view.FormLogin
import com.example.ucp1.view.FormulirPage
import com.example.ucp1.view.ProfilPage

enum class Navigasi {
    Login,
    Profilku,
    FormPren
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Login.name,

            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Navigasi.Login.name){
                FormLogin(
                    OnLoginBtnClick = {
                        navController.navigate(route = Navigasi.Profilku.name)
                    }
                )
            }

            composable(route = Navigasi.Profilku.name){
                ProfilPage(
                    OnKembaliBtnClick = {
                        cancelAndBackToHome(navController)
                    },
                    OnTambahBtnClick = {
                        navController.navigate(route = Navigasi.FormPren.name)
                    }
                )
            }

            composable(route = Navigasi.FormPren.name) {
                FormulirPage(
                    OnBackBtnClick = {
                        cancelAndBackToList(navController)
                    },
                    OnIyaBtnClick = {
                        navController.navigate(route = Navigasi.Profilku.name)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToHome(
    navController: NavHostController
){
    navController.popBackStack(route = Navigasi.Login.name, inclusive = false)
}

private fun cancelAndBackToList(
    navController: NavHostController
){
    navController.popBackStack(route = Navigasi.Profilku.name, inclusive = false)
}