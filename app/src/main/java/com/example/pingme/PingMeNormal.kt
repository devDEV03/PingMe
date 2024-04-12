package com.example.pingme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pingme.data.PingData
import com.example.pingme.data.PingDataState


enum class Screens{
    Start,
    Mid,
    End
}

data class RailIcons(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val navRoute : Screens,
    val bagde : Int? = null,
    val route : Screens
)
@Composable
fun PingMeNormal(
    pingUiState : PingDataState,
    itemList : List<PingData>,
    modifier : Modifier,
    navCon : NavHostController = rememberNavController()
){

   NavHost(navController = navCon, startDestination = Screens.Start.name){
       composable(Screens.Start.name){

       }
       composable(Screens.Mid.name){

       }
       composable(Screens.End.name){

       }
   }
    Row {
        AnimatedVisibility(visible = true) {

        }

        LazyColumn{
            items(itemList){
                it ->   CardTemplate(modifier = modifier, item = it)
            }
        }

    }

}

@Composable
private fun CardTemplate(
    modifier : Modifier,
    item : PingData,
){
    Card {
        Column {
            Row {
                Box{
                    Image(painter = painterResource(id = item.imageId), contentDescription = stringResource(
                        id = item.heading

                    ))
                }
                Column {
                    Text(text = stringResource(id = item.heading))
                    Text(text = stringResource(id = item.time))
                }
            }
            Box(modifier = modifier.fillMaxWidth()){
                Text(text = stringResource(id = item.description))
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
        railItems.forEachIndexed { index, railIcons ->
            IconButton(onClick = { selectedItem = index }) {
                    Badging(item = railIcons, selected = selectedItem == index)
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


