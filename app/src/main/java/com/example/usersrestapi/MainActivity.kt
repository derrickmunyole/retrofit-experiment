package com.example.usersrestapi

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usersrestapi.ui.theme.UsersRestapiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UsersRestapiTheme {
                Scaffold { innerPadding ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    ) {
                        UsersList(viewModel = UserViewModel())
                    }
                }
            }
        }
    }


    @Composable
    fun UsersList(viewModel: UserViewModel) {
        val users by viewModel.users.collectAsState(initial = emptyList())
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(users.size) { index ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardColors(Color.Blue, Color.White,Color.LightGray,Color.Gray),
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                        .padding(top=12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = users[index].name);
                        Text(text = users[index].email);
                        Text(text = users[index].zipcode);
                    }
                }
            }
        }
    }



    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun UserCardPreview() {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            onClick = { /*TODO*/ }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Name");
                Text(text = "Email");
                Text(text = "Zip code");
            }
        }
    }
}