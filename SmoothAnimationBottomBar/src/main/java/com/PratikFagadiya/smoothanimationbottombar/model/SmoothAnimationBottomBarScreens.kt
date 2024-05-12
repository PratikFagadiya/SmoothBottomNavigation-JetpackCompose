package com.PratikFagadiya.smoothanimationbottombar.model

import androidx.compose.ui.graphics.vector.ImageVector

data class SmoothAnimationBottomBarScreens(
    val route: String,
    val name: String,
    val icon: Int,
    val imageVector: ImageVector? = null
) {
    constructor(route: String, name: String, icon: Int) : this(route, name, icon, null)
    constructor(route: String, name: String, imageVector: ImageVector) : this(route, name, 0,imageVector)
}