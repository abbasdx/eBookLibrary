package com.example.e_book.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.SubcomposeAsyncImage
import com.example.e_book.presentation.nav.Routes
import com.example.e_book.viewModel.MyViewModel
<<<<<<< HEAD
=======
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast
>>>>>>> 3a51f5c (Initial Update)

@Composable
fun AllBookScreen(viewModels: MyViewModel = hiltViewModel(), navController: NavController) {

    val state = viewModels.GetAllBookState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModels.getAllBooks()
    }

    when {
        state.value.isLoading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }

        }

        !state.value.error.isNullOrEmpty() -> {
            Text(text = state.value.error!!)
        }

        !state.value.data.isNullOrEmpty() -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items(state.value.data) {
                        Card(
                            modifier = Modifier
                                .clickable(
                                    onClick = {
                                        navController.navigate(
                                            Routes.PdfViewScreen(
                                                Bookurl = it.bookUrl ?: ""
                                            )
                                        )
                                    }
                                )
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                                .height(160.dp),
                            elevation = CardDefaults.cardElevation(5.dp)
                        ) {
                            Row {
                                SubcomposeAsyncImage(
                                    model = it.bookImageUrl,
                                    loading = {

                                        CircularProgressIndicator()
                                    },
                                    contentDescription = "",
                                    error = { Text(text = "error to load") },
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(135.dp)
                                        .align(alignment = Alignment.CenterVertically)

                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = it.bookName ?: "Unknown Book",
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Author: ${it.bookAuthor ?: "Unknown Author"}",
                                        fontWeight = FontWeight.W400
                                    )
                                    Text(
                                        text = "Description: ${it.bookDescription ?: "Unknown Description"}",
                                        fontWeight = FontWeight.W200
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
