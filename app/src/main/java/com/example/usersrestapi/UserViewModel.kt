package com.example.usersrestapi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersrestapi.dto.UserDtoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import com.example.usersrestapi.dto.toUser

class UserViewModel : ViewModel() {
   private val usersApi = RetrofitInstance.api
   private val _users = MutableStateFlow<List<User>>(emptyList())
   val users: Flow<List<User>> = _users.asStateFlow()

   init {
      viewModelScope.launch {
         fetchUsers()
      }
   }

   private suspend fun fetchUsers() {
      try {
         val response: List<UserDtoItem> = usersApi.getUsers()
         if (response.isNotEmpty()) {
            Log.d("UserViewModel", "Fetched users: $response")
            _users.emit(response.map { it.toUser() })
         }
      } catch (e: IOException) {
         throw Error("Network error. Check your internet connection.")
      } catch (e: Exception) {
         throw Error("An error occurred.", e)
      }
   }
}