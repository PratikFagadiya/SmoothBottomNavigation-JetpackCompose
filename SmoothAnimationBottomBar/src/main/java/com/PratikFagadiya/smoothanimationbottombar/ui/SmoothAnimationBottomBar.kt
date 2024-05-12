package com.PratikFagadiya.smoothanimationbottombar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.PratikFagadiya.smoothanimationbottombar.model.SmoothAnimationBottomBarScreens
import com.PratikFagadiya.smoothanimationbottombar.properties.BottomBarProperties

@Composable
fun SmoothAnimationBottomBar(
    navController: NavHostController,
    bottomNavigationItems: List<SmoothAnimationBottomBarScreens>,
    initialIndex: MutableState<Int>,
    bottomBarProperties: BottomBarProperties = BottomBarProperties(),
    onSelectItem : (SmoothAnimationBottomBarScreens) -> Unit
) {

    var width by remember {
        mutableFloatStateOf(0F)
    }

    var itemWidth by remember {
        mutableFloatStateOf(0F)
    }

    val offsetAnim by animateFloatAsState(
        targetValue = when (initialIndex.value) {
            0 -> 0f
            else -> initialIndex.value * itemWidth
        }, label = ""
    )

    var offsetAnimInDp by remember {
        mutableStateOf(0.dp)
    }

    var itemInDp by remember {
        mutableStateOf(30.dp)
    }

    val density = LocalDensity.current

    LaunchedEffect(key1 = itemWidth, block = {
        itemInDp = with(density) { itemWidth.toDp() }
    })

    LaunchedEffect(key1 = offsetAnim, block = {
        offsetAnimInDp = with(density) { offsetAnim.toDp() }
    })

    Surface(
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(bottomBarProperties.backgroundColor)
                .height(70.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Box(
                modifier = Modifier
                    .background(bottomBarProperties.backgroundColor)
                    .fillMaxWidth(0.95f)
                    .fillMaxHeight(), contentAlignment = Alignment.CenterStart
            ) {

                BottomNavigation(
                    backgroundColor = bottomBarProperties.backgroundColor,
                    modifier = Modifier
                        .fillMaxWidth(1F)
                        .fillMaxHeight()
                        .onGloballyPositioned {
                            width = it.size.width.toFloat()
                            itemWidth = width / bottomNavigationItems.size
                        },
                    elevation = 0.dp
                ) {
                    bottomNavigationItems.forEachIndexed { index, smoothAnimationBottomBarScreens ->
                        Row(modifier = Modifier
                            .weight(1F)
                            .fillMaxSize()
                            .clickable(indication = null,
                                interactionSource = remember { MutableInteractionSource() }) {
                                initialIndex.value = index
                                onSelectItem(smoothAnimationBottomBarScreens)

                                navController.navigate(smoothAnimationBottomBarScreens.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                            .padding(5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {

                            val tint = if (index == initialIndex.value) bottomBarProperties.iconTintActiveColor else bottomBarProperties.iconTintColor
                            if (smoothAnimationBottomBarScreens.imageVector != null) {
                                Icon(
                                    imageVector = smoothAnimationBottomBarScreens.imageVector,
                                    contentDescription = smoothAnimationBottomBarScreens.name,
                                    tint = tint
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = smoothAnimationBottomBarScreens.icon),
                                    contentDescription = smoothAnimationBottomBarScreens.name,
                                    tint = tint
                                )
                            }

                            AnimatedVisibility(visible = index == initialIndex.value) {

                                Text(
                                    text = smoothAnimationBottomBarScreens.name,
                                    color = bottomBarProperties.textActiveColor,
                                    maxLines = 1,
                                    softWrap = true,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(start = 5.dp),
                                    fontFamily = bottomBarProperties.fontFamily,
                                    fontWeight = bottomBarProperties.fontWeight,
                                    fontSize = bottomBarProperties.fontSize
                                )
                            }

                        }
                    }

                }

                Box(
                    modifier = Modifier
                        .width(itemInDp)
                        .height(50.dp)
                        .offset(offsetAnimInDp)
                        .clip(RoundedCornerShape(bottomBarProperties.cornerRadius))
                        .background(bottomBarProperties.indicatorColor)
                )
            }

        }
    }

}