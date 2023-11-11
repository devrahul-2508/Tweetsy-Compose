package com.example.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.screens.CategoryScreen
import com.example.tweetsy.screens.DetailScreen
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsyTheme {
                // A surface container using the 'background' color from the theme
             App()
            }
        }
    }
}

@Composable
fun App() {
 val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category" ){
        composable(route="category"){
            CategoryScreen{
                navController.navigate("detail/${it}")
            }
        }
        composable(route="detail/{category}", arguments = listOf(
            navArgument("category"){
                type= NavType.StringType
            }
        )
        ){
            DetailScreen()
        }
    }
}

