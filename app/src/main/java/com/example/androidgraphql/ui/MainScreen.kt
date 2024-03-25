package com.example.androidgraphql.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidgraphql.domain.model.CountryModel


@Composable
fun CountryScreen(
    state: CountryUiState,
    onSelectedCountry: (String) -> Unit,
    onDisMissSelectedCountry: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(state.countries) {
                    CountryRow(item = it, onSelectedCountry)
                }
            }
        }
    }

}

@Composable
fun CountryRow(item: CountryModel, onSelectedCountry: (String) -> Unit) {
    Surface(
        modifier = Modifier.padding(6.dp).fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    onSelectedCountry(item.code)
                }) {
            Text(text = item.emoji)
            Column(modifier = Modifier.padding(start = 6.dp)) {
                Text(item.name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(item.capital)
            }
        }
    }

}