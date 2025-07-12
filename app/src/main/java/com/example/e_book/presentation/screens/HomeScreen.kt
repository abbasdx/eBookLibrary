package com.example.e_book.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContactSupport
import androidx.compose.material.icons.filled.Gite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
<<<<<<< HEAD
=======
import androidx.compose.material.icons.filled.Logout
>>>>>>> 3a51f5c (Initial Update)
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import androidx.compose.ui.graphics.vector.ImageVector
=======
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
>>>>>>> 3a51f5c (Initial Update)
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
<<<<<<< HEAD
=======
import coil3.request.colorSpace
import com.example.e_book.presentation.nav.Routes
import com.example.e_book.viewModel.AuthViewModel
>>>>>>> 3a51f5c (Initial Update)
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
<<<<<<< HEAD
fun HomeScreen(navController: NavHostController) {
    val navItem = listOf(MenuItem("Home", Icons.Default.Home), MenuItem("GitHub", Icons.Default.AccountCircle), MenuItem("About", Icons.Default.Info), MenuItem("Contact", Icons.Default.ContactSupport), MenuItem("Version 1.0", Icons.Default.Android))
=======
fun HomeScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    val navItem = listOf(MenuItem("Home", Icons.Default.Home), MenuItem("GitHub", Icons.Default.AccountCircle), MenuItem("About", Icons.Default.Info), MenuItem("Contact", Icons.Default.ContactSupport), MenuItem("Version 1.0", Icons.Default.Android), MenuItem("Logout", Icons.Default.Logout))
>>>>>>> 3a51f5c (Initial Update)

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val urlHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
<<<<<<< HEAD
                        .padding(16.dp)
=======
                        .padding(16.dp),
>>>>>>> 3a51f5c (Initial Update)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Menu",
                            modifier = Modifier.size(30.dp).clickable {
                                coroutineScope.launch { drawerState.close() }
                            }
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Menu", style = MaterialTheme.typography.titleLarge)
                    }


                    Spacer(modifier = Modifier.height(10.dp))
                    navItem.forEach { item ->
                        Divider()
                        NavigationDrawerItem(
                            label = {
                                Row {
                                    Icon(item.icon, contentDescription = item.item)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = item.item) }
                                },
                            selected = false,
                            onClick = {
                                when (item.item) {
                                    "GitHub" -> urlHandler.openUri("https://github.com/abbasdx")
                                    "Contact" -> urlHandler.openUri("mailto:your-email@gmail.com")
<<<<<<< HEAD
=======
                                    "Logout" -> {authViewModel.logout()
                                        navController.navigate(Routes.login )
                                    }
>>>>>>> 3a51f5c (Initial Update)
                                    else -> {} // Add navigation logic here
                                }
                                coroutineScope.launch { drawerState.close() }
                            }
                        )
                    }
                }
            }
        }
    ) {
        Scaffold(
<<<<<<< HEAD
            topBar = {
                TopAppBar(
                    title = { Text("E-Book Library", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(
                            onClick = { coroutineScope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {
                TabScreen(
                    navController = navController
                )
            }

        }
=======
//            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = { Text("E-Book Library", fontWeight = FontWeight.Bold, color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF007BFF),
                        navigationIconContentColor = Color.White,
                        titleContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )

            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                TabScreen(navController = navController)
            }
        }

>>>>>>> 3a51f5c (Initial Update)
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewHomeScreen() {
//    HomeScreen()
//}
data class MenuItem(
    val item: String,
    val icon: ImageVector,
)