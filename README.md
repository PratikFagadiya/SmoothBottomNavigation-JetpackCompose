# SmoothBottomNavigation-JetpackCompose
A beautiful and simple bottom navigation with custom smooth slide animation library built in jetpack compose ❤️
 <br />
 <br />

 <p align="center">  
  <img alt="API" src="https://img.shields.io/badge/Api%2023+-50f270?logo=android&logoColor=black&style=for-the-badge"/></a>  
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-a503fc?logo=kotlin&logoColor=white&style=for-the-badge"/></a>  
  <img alt="Jetpack Compose" src="https://img.shields.io/static/v1?style=for-the-badge&message=Jetpack+Compose&color=4285F4&logo=Jetpack+Compose&logoColor=FFFFFF&label="/></a>  
    <a href="https://github.com/PratikFagadiya/SmoothBottomNavigation-JetpackCompose"><img src="https://img.shields.io/github/stars/PratikFagadiya/SmoothBottomNavigation-JetpackCompose?color=ffff00&style=for-the-badge"/>  
  <a href="https://hits.sh/github.com/PratikFagadiya/SmoothBottomNavigation-JetpackCompose/"><img alt="Hits" src="https://hits.sh/github.com/PratikFagadiya/SmoothBottomNavigation-JetpackCompose.svg?style=for-the-badge&label=Views&extraCount=10&color=54856b"/></a>  
  <a href="https://github.com/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose/releases/latest"><img src="https://img.shields.io/github/v/release/PratikFagadiya/SmoothBottomNavigation-JetpackCompose?color=purple&include_prereleases&logo=github&style=for-the-badge"/>  
</p>  

## Introduction

Welcome to the Jetpack Compose Animated Smooth Bottom Navigation library! 🚀. This library provides you with a beautiful and straightforward solution for creating smooth slide animations in for your Jetpack Compose Android applications. With this library, you can easily implement a stunning bottom navigation bar with eye-catching slide animations that will enhance the overall user experience of your app. ⭐

_Made with love  ❤️ by  [Pratik Fagadiya](https://github.com/pratikfagadiya)_
 <br />
 <br />

## GIF Preview 👀
<img src="https://github.com/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose/blob/master/art/animatedsmoothbarjetpackcompose.gif" width="350" alt="Animated GIF Preview"/>
 <br />
 
## Getting Started 🚀
To get started with the SmoothBottomNavigation-JetpackCompose library.

Add JitPack repository to your project's `settings.gradle` file.
```groovy  
dependencyResolutionManagement {  
 // ...  
 repositories {
    // ...
    maven { url "https://www.jitpack.io" }
 }}  
```

Declare the dependencies in the module-level `build.gradle` file 🍀 [![](https://jitpack.io/v/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose.svg)](https://jitpack.io/#PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose)
```gradle  
 dependencies {
     implementation 'com.github.PratikFagadiya:AnimatedSmoothBottomNavigation-JetpackCompose:<LATEST_VERSION>'
 }
```
<br />

### How to use 🚀

Create list of bottom navigation Item with `SmoothAnimationBottomBarScreens`
```kotlin
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

val navController = rememberNavController()
val currentIndex = rememberSaveable {
    mutableIntStateOf(0)
}

Scaffold(bottomBar = {
    SmoothAnimationBottomBar(navController, 
        bottomNavigationItems,
        initialIndex = currentIndex,
        bottomBarProperties = BottomBarProperties(),
        onSelectItem = {
            Log.i("SELECTED_ITEM", "onCreate: Selected Item ${it.name}")
        })
}) { innerPadding ->
    Modifier.padding(innerPadding)
    ScreenNavigationConfiguration(navController, currentIndex)
}

```
 
You can check [MainActivity.kt](https://github.com/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose/tree/master/app/src/main/java/com/pratikfagadiya/animatedbottomnavigation/MainActivity.kt) directory for demo. ⭐
 <br />
<br />

 ## Customisation 🎨

With our customizable library, you have the power to customizable library based on your requirement
you can see how you can customize various properties of the BottomBarProperties object to fit your UI design preferences.

Feel free to adjust the  `colors`, `sizes`, `font` and other parameters to match your specific requirements.

```kotlin

Scaffold(bottomBar = {
                SmoothAnimationBottomBar(navController,
                    bottomNavigationItems,
                    initialIndex = currentIndex,
                    bottomBarProperties = BottomBarProperties(
                        backgroundColor = Color.Blue,     // Change the background color 
                        indicatorColor = Color.White.copy(alpha = 0.2F),  // Change the indicator color with Alpha
                        iconTintColor = Color.BlueTint, // Change the icon tint color
                        iconTintActiveColor = Color.White, // Change the active icon tint color
                        textActiveColor = Color.White, // Change the active text color
                        cornerRadius = 18.dp,  // Increase the corner radius
                        fontFamily = JostFont,  // Change the font family
                        fontWeight = FontWeight.Medium,  // Change the font weight
                        fontSize = 16.sp // Increase or Decrease the font size
                    ),
                    onSelectItem = {
                        Log.i("SMOOTH_ANIMATION_BAR", "onCreate: Selected Item ${it.name}")
                    })
            }) { innerPadding ->
                Modifier.padding(innerPadding)
                ScreenNavigationConfiguration(navController, currentIndex)
            }

```
<br />

## Acknowledgments

This Jetpack Compose Smooth Animation Bottom Navigation library 🚀 was inspired by the [XML-Based Bottom Navigation Library](https://github.com/ibrahimsn98/SmoothBottomBar) created by [**İbrahim Süren**
](https://github.com/ibrahimsn98). I would like to express our gratitude for their work, which served as the foundation for this Jetpack Compose library adaptation. 👏

- XML Based Library: [XML-Based Bottom Navigation Library](https://github.com/ibrahimsn98/SmoothBottomBar)

Thank you **İbrahim Süren**, for sharing your creative work with the community, which has allowed me to build upon it and create this Jetpack Compose version. 🙌
 <br />
 <br />

## Donate

If you found this library helpful or you learned something from the source code and want to thank  me, 
consider buying me a cup of :coffee:

[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/yellow_img.png)](https://www.buymeacoffee.com/pratikf)  
<br />


## Find this library useful ? ❤️

- Support it by clicking the ⭐️ button on the upper right of this page and share with others. ✌️

  Also, follow me on __[github](https://github.com/PratikFagadiya)__ and _
  _[twitter](https://twitter.com/PFagadiya)__ to stay updated with my creations! 🤩    
  <br />

## Contribution 🤝

- If you would like to contribute you're most welcome! 💛    
  See [Contributing Guidelines](https://github.com/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose/blob/master/CONTRIBUTING.md).    
  <br />

## Connect with me

<div align="left">  
<a href="https://twitter.com/PFagadiya" target="https://twitter.com/PFagadiya">  
<img src=https://img.shields.io/badge/twitter-%2300acee.svg?&style=for-the-badge&logo=twitter&logoColor=white alt=twitter style="margin-bottom: 5px;" />  
</a>  
<a href="https://www.linkedin.com/in/pratik-fagadiya-79b8081b0/" target="https://www.linkedin.com/in/pratik-fagadiya-79b8081b0/">  
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 5px;" />  
</a>  
<a href="https://www.instagram.com/patrik.codes/?next=%2Fpatcoder%2F&hl=en" target="https://www.instagram.com/patrik.codes/?next=%2Fpatcoder%2F&hl=en">  
<img src=https://img.shields.io/badge/instagram-%23000000.svg?&style=for-the-badge&logo=instagram&logoColor=white alt=instagram style="margin-bottom: 5px;" />  
</a>  
</div>  
<br />  

## License 🔖
```
Copyright (c) 2022-2023 Pratik Fagadiya

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
 <br />

We hope you enjoy using the Jetpack Compose Smooth Slide Animation Bottom Navigation library in your projects. If you encounter any issues or have any suggestions for improvement, please feel free to [open an issue](https://github.com/PratikFagadiya/AnimatedSmoothBottomNavigation-JetpackCompose/issues). Happy coding!
