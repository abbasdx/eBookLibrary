package com.example.e_book.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import org.tensorflow.lite.support.label.Category

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabScreen(navController: NavHostController) {

    val tabs = listOf(
        TabItem("Category", Icons.Default.Category, Icons.Filled.Category),
        TabItem("Books", Icons.Default.Book, Icons.Filled.Book)
    )
    val pagerState = rememberPagerState(pageCount = {tabs.size})

    val scope = rememberCoroutineScope()


        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage
            ){
                tabs.forEachIndexed{
                        index, tabItem ->
                    Tab(

                        modifier = Modifier.fillMaxWidth(),
                        selected = pagerState.currentPage==index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }

                        },
                        text = {
                            Row {
                                Icon(
                                    if(pagerState.currentPage==index) tabItem.fillIcon else tabItem.icon,
                                    contentDescription = tabItem.title
                                )

                                Text(text = tabItem.title)
                            }

                        },
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            HorizontalPager(state = pagerState) {
                when(it){
                    0-> CategoryScreen(navController= navController)
                    1-> AllBookScreen(navController = navController)
                }
            }
        }
    }



data class TabItem(
    val title: String,
    val icon: ImageVector,
    val fillIcon: ImageVector
)
