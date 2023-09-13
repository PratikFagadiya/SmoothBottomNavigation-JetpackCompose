package com.pratikfagadiya.animatedbottomnavigation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pratikfagadiya.animatedbottomnavigation.ui.theme.JostFont

@Composable
fun TrendingScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Trending Screen",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            fontFamily = JostFont
        )
    }

}

@Preview
@Composable
fun PreviewTrendingScreen() {
    TrendingScreen()
}