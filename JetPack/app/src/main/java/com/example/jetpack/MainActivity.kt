package com.example.jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.magnifier
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ViewContainer(){

    Scaffold(
        //topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = { BottomBar() }
    )
}



@Composable
fun FAB(){

    val context = LocalContext.current

    FloatingActionButton(onClick = { Toast.makeText(context, "FAB", Toast.LENGTH_SHORT).show() }){
        Image(
            painter = painterResource(id = R.drawable.icon_favorite),
            contentDescription = "Like",
            modifier = Modifier
                .padding(8.dp)

        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){


    TopAppBar(
        title = {Text(text = "JetPack")},
        Modifier
            .background(color = colorResource(id = R.color.purple_200))
        ,


    )

}

@Composable
fun BottomBar(){

    val context = LocalContext.current

        BottomAppBar() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_look_for),
                    contentDescription = "1",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Like", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "2",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Like", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_look_for),
                    contentDescription = "3",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Like", Toast.LENGTH_SHORT)
                                .show()
                        }
                )

            }
        }

}



@Composable
fun Content(
) {

    var counter by rememberSaveable() { mutableStateOf(0) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)

    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.star_wars),
                contentDescription = "Star Wars 3"
            )
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "Like",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            counter++
                        }
                )
                Text(
                    text = counter.toString(),
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp)
                )
            }


        }

    }

}
