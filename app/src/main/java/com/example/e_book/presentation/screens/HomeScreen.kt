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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val navItem = listOf(MenuItem("Home", Icons.Default.Home), MenuItem("GitHub", Icons.Default.AccountCircle), MenuItem("About", Icons.Default.Info), MenuItem("Contact", Icons.Default.ContactSupport), MenuItem("Version 1.0", Icons.Default.Android))

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
                        .padding(16.dp)
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