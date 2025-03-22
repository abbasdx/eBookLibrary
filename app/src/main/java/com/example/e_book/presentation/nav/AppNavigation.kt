package com.example.e_book.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
   NavHost(navController= navController, startDestination = Routes.New,
       modifier = Modifier){

       composable<Routes.New> {
           HomeScreen(navController)
       }
       composable<Routes.Home > {
           TabScreen(navController)
       }

       composable<Routes.PdfViewScreen > {
           val data = it.toRoute<Routes.PdfViewScreen>()
           PdfViewScreen(Bookurl = data.Bookurl)
       }

       composable<Routes.BookByCategory> {
           val data = it.toRoute<Routes.BookByCategory>()
           BookByCategory(navController = navController, categoryName = data.categoryName)
       }
   }

}