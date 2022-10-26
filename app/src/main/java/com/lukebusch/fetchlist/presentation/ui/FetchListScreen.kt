package com.lukebusch.fetchlist.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModel

@Composable
fun FetchListScreen(
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column() {
        Text(
            text = "A List of Things",
            textAlign = TextAlign.Center,
            color = Color.Blue,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

        ){
            Text(textAlign = TextAlign.Center, text = "List Id")
            Text(textAlign = TextAlign.Center, text = "ID")
            Text(textAlign = TextAlign.Center, text = "Name")
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.listItems) { displayItem ->
                    ListItem(item = displayItem)
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}