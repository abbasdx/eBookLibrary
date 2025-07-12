package com.example.e_book.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
<<<<<<< HEAD
=======
import androidx.lifecycle.viewmodel.compose.viewModel
>>>>>>> 3a51f5c (Initial Update)
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.e_book.presentation.screens.BookByCategory
import com.example.e_book.presentation.screens.HomeScreen
import com.example.e_book.presentation.screens.PdfViewScreen
import com.example.e_book.presentation.screens.TabScreen
<<<<<<< HEAD

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
   NavHost(navController= navController, startDestination = Routes.New,
       modifier = Modifier){

       composable<Routes.New> {
           HomeScreen(navController)
=======
import com.example.e_book.presentation.screens.authentication.LoginScreen
import com.example.e_book.presentation.screens.authentication.OnboardingScreen
import com.example.e_book.presentation.screens.authentication.RegisterScreen
import com.example.e_book.viewModel.AuthViewModel

@Composable
fun AppNavigation( ) {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
   NavHost(navController= navController, startDestination = Routes.OnboardingScreen,
       modifier = Modifier){

       composable<Routes.New> {
           HomeScreen(navController, authViewModel)
>>>>>>> 3a51f5c (Initial Update)
       }
       composable<Routes.Home > {
           TabScreen(navController)
       }

       composable<Routes.PdfViewScreen > {
           val data = it.toRoute<Routes.PdfViewScreen>()
<<<<<<< HEAD
           PdfViewScreen(Bookurl = data.Bookurl)
=======
           PdfViewScreen(Bookurl = data.Bookurl, navController)
>>>>>>> 3a51f5c (Initial Update)
       }

       composable<Routes.BookByCategory> {
           val data = it.toRoute<Routes.BookByCategory>()
           BookByCategory(navController = navController, categoryName = data.categoryName)
       }
<<<<<<< HEAD
=======

       composable<Routes.OnboardingScreen>{
          OnboardingScreen(navController, authViewModel)
       }
       composable<Routes.login> {
           LoginScreen(navController, authViewModel)
       }
       composable<Routes.register>{
           RegisterScreen(navController, authViewModel)
       }
>>>>>>> 3a51f5c (Initial Update)
   }

}