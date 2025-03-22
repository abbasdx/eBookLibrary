package com.example.e_book.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.SubcomposeAsyncImage
import com.example.e_book.presentation.nav.Routes
import com.example.e_book.viewModel.MyViewModel

@Composable
fun CategoryScreen(
    viewModels: MyViewModel = hiltViewModel(), navController: NavController
) {
    val state = viewModels.GetAllCategoryState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModels.getAllCategories()
    }

    val context = LocalContext.current
    when {
        state.value.isLoading -> {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                CircularProgressIndicator()
            }
        }

        state.value.error.isNotEmpty() -> {
            Text(text = state.value.error.toString())
        }

        state.value.data.isNotEmpty() -> {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.value.data) {
                        EachCategoryItem(
                            imageUrl = it.categoryImageUrl ?: "",
                            categoryName = it.categoryName ?: "Unknown",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun EachCategoryItem(
    imageUrl: String,
    categoryName: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .size(220.dp).clickable {
                navController.navigate(Routes.BookByCategory(categoryName=categoryName))
            }
    ) {
        Box (contentAlignment = Alignment.Center){
            SubcomposeAsyncImage(
                model = imageUrl,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = "",
                error = { Text(text = "Error loading image") },
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = categoryName,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(8.dp)
                    .fillMaxWidth(),
            )
        }
    }
}