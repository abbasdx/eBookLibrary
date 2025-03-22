package com.example.e_book.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_book.common.ResultState
import com.example.e_book.data.BookCategoryModels
import com.example.e_book.data.BookModels
import com.example.e_book.repo.repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val repo: repo) : ViewModel() {
//    private val _GetAllBooksState: MutableState<GetAllBookState> = mutableStateOf(GetAllBookState())
//    val GetAllBooksState : MutableState<GetAllBookState> = _GetAllBooksState

//    private val _GetAllBooksState: StateFlow<GetAllBookState> = MutableStateFlow(GetAllBookState())
//    val GetAllBookState = _GetAllBooksState.asStateFlow()
//
//    private val _GetAllCategoriesState : StateFLow<GetAllCategoryState> = MutableStateFlow(GetAllCategoryState())
//    val GetAllCategoryState = _GetAllCategoriesState.asStateFlow()

    private val _GetAllBooksState: MutableStateFlow<GetAllBookState> =
        MutableStateFlow(GetAllBookState())
    val GetAllBookState: StateFlow<GetAllBookState> = _GetAllBooksState.asStateFlow()

    private val _GetAllCategoriesState: MutableStateFlow<GetAllCategoryState> =
        MutableStateFlow(GetAllCategoryState())
    val GetAllCategoryState: StateFlow<GetAllCategoryState> = _GetAllCategoriesState.asStateFlow()

    private val _GetAllBookByCategoryState: MutableStateFlow<GetAllBookByCategoryState> = MutableStateFlow(GetAllBookByCategoryState())
    val GetAllBookByCategoryState:StateFlow<GetAllBookByCategoryState> = _GetAllBookByCategoryState.asStateFlow()


    fun getAllBookByCategory(categoryName: String) {
        viewModelScope.launch {
            repo.getAllBookByCategory(categoryName).collect{
                when(it){
                    is ResultState.Success -> {
                        _GetAllBookByCategoryState.value = GetAllBookByCategoryState(data = it.data)
                    }
                    is ResultState.Loading -> {
                        _GetAllBookByCategoryState.value = GetAllBookByCategoryState(isLoading = true)
                    }
                    is ResultState.Error -> {
                        _GetAllBookByCategoryState.value = GetAllBookByCategoryState(error = it.exception)
                    }
                }
            }
        }
    }

    fun getAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllCategories().collect {
                when (it) {
                    is ResultState.Success -> {
                        _GetAllCategoriesState.value = GetAllCategoryState(data = it.data)
                    }

                    is ResultState.Loading -> {
                        _GetAllCategoriesState.value = GetAllCategoryState(isLoading = true)
                    }

                    is ResultState.Error -> {
                        _GetAllCategoriesState.value = GetAllCategoryState(error = it.exception)
                    }
                }
            }
        }
    }

    fun getAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllBooks().collect {
                when (it) {
                    is ResultState.Success -> {
                        _GetAllBooksState.value = GetAllBookState(data = it.data)
                    }

                    is ResultState.Loading -> {
                        _GetAllBooksState.value = GetAllBookState(isLoading = true)
                    }

                    is ResultState.Error -> {
                        _GetAllBooksState.value = GetAllBookState(error = it.exception)
                    }
                }
            }
        }
    }
}

data class GetAllBookState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<BookModels> = emptyList()
)

data class GetAllCategoryState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<BookCategoryModels> = emptyList()
)

data class GetAllBookByCategoryState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<BookModels> = emptyList()
)