package com.example.interfacegrafica
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfacegrafica.ui.theme.InterfaceGraficaTheme

import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceGraficaTheme {
                // A surface container using the 'background' color from the theme
                MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
            }
        }
    }
}
@Composable
fun MainScreenContent(drawerState: DrawerState){
    val scaffoldSate1 = rememberScaffoldState(drawerState = drawerState)

    Scaffold(
        scaffoldState = scaffoldSate1,
        topBar = {
            TopAppBar(
                title = {Text("TopBar") },
                navigationIcon = {
                    IconButton(onClick = {




                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "menu"
                        )
                    }
                }

            )

        },
        drawerContent = {
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .fillMaxHeight().fillMaxWidth()
            ){
                Column(){
                    Text("Opções")
                    Text("Opção 1")
                    Text("Opção 2")
                    Text("Opção 3")
                }
            }
        }
        ,
        content =
        {
                paddingValues ->  Log.i("padding values: ", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxSize()
            ) {
                MySearchField(modifier = Modifier.fillMaxWidth())
                MyTaskWidget(modificador = Modifier.fillMaxWidth(), taskName ="ola", taskDetails = "oi", deadDateTime = Date())
                MyTaskWidget(modificador = Modifier.fillMaxWidth(), taskName ="ola", taskDetails = "oi", deadDateTime = Date())



            }
        }
        ,
        bottomBar = {
            BottomAppBar(
                content = {
                    Row(){
                    Text(text = "Guilherme Rafael Figueiredo Pereira")
                    Button(onClick= { Log.i("ola", "ola")}, Modifier.) {
                    }
                    }
                }
            )

        }
    )
}
@Composable
fun MySearchField(modifier: Modifier){
    TextField(value = "",
        onValueChange = {},
        modifier = modifier,
        placeholder = {Text("Pesquisar")},
        leadingIcon =  {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Pesquisar")
        }
    )
}

@Composable
fun MyTaskWidget(modificador: Modifier, taskName : String, taskDetails: String, deadDateTime: Date){
    val dateFormatter = SimpleDateFormat("EEE, dd MMM, yyyy", Locale.getDefault())
    Row(modifier = modificador) {
        Column() {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "ola2"
            )
            Text(
                text = dateFormatter.format(deadDateTime),
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier= modificador
                .border(width = 1.dp, color = Color.Black)
                .padding(3.dp),

            ){
            Text(
                text = taskName,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = taskDetails,
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    Spacer(modifier = Modifier.height(16.dp))
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InterfaceGraficaTheme {
        MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
    }
}