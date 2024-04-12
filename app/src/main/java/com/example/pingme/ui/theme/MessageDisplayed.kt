package com.example.pingme.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingme.ModelView.PingMeClass
import com.example.pingme.data.PingDataState


@Composable
fun PingExpandedDisplay(
    viewModelPing : PingDataState
){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Card(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                viewModelPing.itemSelected?.let {
                    Text(text = viewModelPing.itemSelected.message.toString())
                }
            }
        }

}

@Composable
fun PingDisplay(
    viewModelPing : PingDataState,
    navCon : NavHostController
){
    Scaffold(
        topBar = {
            TopAppBar(navCon = navCon)
        }
    ) {
        innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Card(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                viewModelPing.itemSelected?.let {
                    Text(text = viewModelPing.itemSelected.message.toString())
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navCon : NavHostController
){
    CenterAlignedTopAppBar(
        title = { Text(text = "The message")},
        navigationIcon = {
            IconButton(onClick = { navCon.navigateUp() }) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Yellow
        )
    )
}
