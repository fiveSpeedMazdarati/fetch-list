package com.lukebusch.fetchlist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lukebusch.fetchlist.domain.ListDisplayItem

@Composable
fun ListItem(
    item: ListDisplayItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "${item.listId}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            textAlign = TextAlign.Center,
            text = "${item.id}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            textAlign = TextAlign.Center,
            text = "${item.name}",
            style = MaterialTheme.typography.bodyMedium
        )

    }
}