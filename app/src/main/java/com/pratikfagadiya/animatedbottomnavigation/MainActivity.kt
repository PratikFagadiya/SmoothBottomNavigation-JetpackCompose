package com.pratikfagadiya.animatedbottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pratikfagadiya.animatedbottomnavigation.navigation.Screens
import com.pratikfagadiya.animatedbottomnavigation.presentation.FeedScreen
import com.pratikfagadiya.animatedbottomnavigation.presentation.HomeScreen
import com.pratikfagadiya.animatedbottomnavigation.presentation.ProfileScreen
import com.pratikfagadiya.animatedbottomnavigation.presentation.TrendingScreen
import com.pratikfagadiya.animatedbottomnavigation.ui.theme.AnimatedBottomNavigationTheme
import com.pratikfagadiya.animatedbottomnavigation.ui.theme.JostFont
import com.PratikFagadiya.smoothanimationbottombar.model.SmoothAnimationBottomBarScreens
import com.PratikFagadiya.smoothanimationbottombar.properties.BottomBarProperties
import com.PratikFagadiya.smoothanimationbottombar.ui.SmoothAnimationBottomBar
import com.PratikFagadiya.smoothanimationbottombar.ui.theme.Blue
import com.PratikFagadiya.smoothanimationbottombar.ui.theme.BlueTint

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AnimatedBottomNavigationTheme {

                val navController = rememberNavController()

                val bottomNavigationItems = listOf(
                    SmoothAnimationBottomBarScreens(
                        Screens.HomeScreen.route,
                        stringResource(id = R.string.home),
                        R.drawable.baseline_home_24
                    ), SmoothAnimationBottomBarScreens(
                        Screens.TrendingScreen.route,
                        stringResource(id = R.string.trending),
                        R.drawable.baseline_trending_up_24
                    ), SmoothAnimationBottomBarScreens(
                        Screens.FeedScreen.route,
                        stringResource(id = R.string.feed),
                        R.drawable.baseline_feed_24
                    )
                )

                val currentIndex = rememberSaveable {
                    mutableIntStateOf(0)
                }

                Scaffold(bottomBar = {
                    SmoothAnimationBottomBar(navController,
                        bottomNavigationItems,
                        initialIndex = currentIndex,
                        bottomBarProperties = BottomBarProperties(
                            backgroundColor = Blue,
                            indicatorColor = Color.White.copy(alpha = 0.2F),
                            iconTintColor = BlueTint,
                            iconTintActiveColor = Color.White,
                            textActiveColor = Color.White,
                            cornerRadius = 18.dp,
                            fontFamily = JostFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        ),
                        onSelectItem = {
                            Log.i("SELECTED_ITEM", "onCreate: Selected Item ${it.name}")
                        })
                }) { innerPadding ->
                    Modifier.padding(innerPadding)
                    ScreenNavigationConfiguration(navController, currentIndex)
                }
            }
        }
    }

}



@Composable
fun ScreenNavigationConfiguration(navController: NavHostController, currentIndex: MutableIntState) {

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {

        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }

        composable(Screens.TrendingScreen.route) {
            TrendingScreen()
        }

        composable(Screens.FeedScreen.route) {
            FeedScreen()
        }

        composable(Screens.ProfileScreen.route) {
            ProfileScreen()
        }

    }

}