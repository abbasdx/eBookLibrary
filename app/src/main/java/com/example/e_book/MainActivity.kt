package com.example.e_book

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.e_book.presentation.nav.AppNavigation
import com.example.e_book.presentation.screens.HomeScreen
import com.example.e_book.presentation.screens.TabScreen
=======
import androidx.compose.material3.Scaffold
import com.example.e_book.presentation.nav.AppNavigation
>>>>>>> 3a51f5c (Initial Update)
import com.example.e_book.ui.theme.EbookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EbookTheme {
                Scaffold { innerPadding ->
                    AppNavigation()
<<<<<<< HEAD
=======

>>>>>>> 3a51f5c (Initial Update)
                }

            }
        }
    }
}
