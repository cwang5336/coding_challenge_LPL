package com.example.code

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SummarizedEmailCardCompose(model: List<SummarizedEmailCard>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(model) {
            Card(it)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@Composable
fun Card(model: SummarizedEmailCard) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray),
    ) {
        Column(modifier = Modifier.weight(.2f).padding(top = 8.dp)) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                if (model.imageUri?.isNotEmpty() == true) {
                    AsyncImage(
                        model = model.imageUri,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(.8f)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ToggleShowText(model.name, model.email)
            }
            Text(text = "${model.id}", style = MaterialTheme.typography.bodySmall)
            Text(text = model.body, style = MaterialTheme.typography.bodySmall)
        }
    }
}


@Composable
fun ToggleShowText(showText: String, toggleText: String, autoResetMillis: Long = 3000L) {
    var show by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Text(
        text = if (show) toggleText else showText,
        modifier = Modifier
            .clickable {
                show = true
                scope.launch {
                    delay(autoResetMillis)
                    show = false
                }
            }
            .padding(vertical = 4.dp),
        style = MaterialTheme.typography.bodyMedium
    )
}