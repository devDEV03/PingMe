package com.example.pingme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pingme.ModelView.PingMeClass
import com.example.pingme.data.PingData
import com.example.pingme.data.PingDataState
import com.example.pingme.data.RailIcons
import com.example.pingme.data.Screens
import com.example.pingme.data.iconList
import com.example.pingme.data.itemList
import com.example.pingme.ui.theme.PingDisplay
import com.example.pingme.ui.theme.PingExpandedDisplay


@Composable
fun PingMeExpanded(
    pingUiState : PingMeClass,
    modifier : Modifier,
    navCon : NavHostController = rememberNavController()
){
    val pingState by pingUiState.uistate.collectAsState()
    Row {
        AnimatedVisibility(visible = true) {
            NavigationRailType(railItems = iconList, navCon = navCon)
        }

        LazyColumn{
            items(itemList){
                    it ->   CardTemplate(modifier = modifier, item = it, onClickCard = {pingUiState.selectCard(it)
                })
            }
        }
        PingExpandedDisplay(viewModelPing = pingState)
    }

}
@Composable
fun PingMeNormal(
    pingUiState : PingMeClass,
    modifier : Modifier,
    navCon : NavHostController = rememberNavController()
){
    val pingState by pingUiState.uistate.collectAsState()

    NavHost(navController = navCon, startDestination = Screens.Start.name){
        composable(route = Screens.Start.name){
            Row {
                AnimatedVisibility(visible = true) {
                    NavigationRailType(railItems = iconList, navCon = navCon)
                }

                LazyColumn{
                    items(itemList){
                            it ->   CardTemplate(modifier = modifier, item = it, onClickCard = {pingUiState.selectCard(it)
                            navCon.navigate(Screens.Mid.name)})
                    }
                }

            }
        }
        composable(route = Screens.Mid.name){
        PingDisplay(viewModelPing = pingState,navCon)
        }
    }


}

@Composable
private fun CardTemplate(
    modifier : Modifier,
    item : PingData,
    onClickCard : (PingData) -> Unit
){
    Card (
        modifier = Modifier
            .clickable {
                onClickCard(item)
            }
            .padding(13.dp),
        shape = MaterialTheme.shapes.medium
    ){
        Column {
            Row {
                Box(
                    modifier = Modifier.padding(3.dp)
                ){
                    Image(
                        painter = painterResource(id = item.imageId),
                        contentDescription = stringResource(id = item.heading),
                        modifier = Modifier
                            .size(20.dp, 30.dp)
                            .clip(MaterialTheme.shapes.extraLarge)
                            .padding(top = 4.dp, start = 4.dp)
                    )
                }
                Column {
                    Text(text = stringResource(id = item.heading),modifier = Modifier.padding(2.dp))
                    Text(text = stringResource(id = item.description))
                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp)
            ){
                Text(text = stringResource(id = item.time))
            }

        }

    }
}
@Composable
fun NavigationRailType(
    railItems : List<RailIcons>,
    navCon: NavHostController
){
    var selectedItem by remember{
        mutableStateOf(0)
    }
    NavigationRail (
        header = {
            IconButton(onClick = { navCon.navigate(Screens.Start.name) }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null )
            }
            FloatingActionButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp,Alignment.Bottom)
        ) {
            railItems.forEachIndexed { index, railIcons ->
                NavigationRailItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = { Badging(item = railIcons, selected = selectedItem == index) })
            }
        }

    }
}

@Composable
fun Badging(
    item : RailIcons,
    selected : Boolean
){
    BadgedBox(badge = {
        if(item.bagde != null){
            Badge() {
                Text(text = item.bagde.toString())
            }
        }
        else{
            Badge()
        }
    }) {
     Icon(
         imageVector =
            if(selected){
                item.selectedIcon
            }
            else{
                item.unselectedIcon
            },
         contentDescription = null
     )
    }
}


