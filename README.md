# ![Popular Movies](https://raw.githubusercontent.com/fjoglar/popular-movies-app/master/app/src/main/res/mipmap-mdpi/ic_launcher_round.png) Popular Movies App

![License Apache 2.0](https://img.shields.io/badge/license-Apache%202.0-green.svg)
[![fjoglar twitter](https://img.shields.io/badge/twitter-@Mahmod_Elebiary-blue.svg)](https://twitter.com/Mahmod_Elebiary)
[![Platform Android](https://img.shields.io/badge/platform-Android-blue.svg)](https://www.android.com)



## Features

Main navigation with most popular and top rated movies plus detailed view | Launch Youtube app to watch the movie videos directly from the app | Add and remove a movie from your favorite list
------------ | ------------- | -------------
<img src="https://raw.githubusercontent.com/fjoglar/popular-movies-app/master/assets/main-navigation.gif" width="250px" alt="Main Navigation"/> | <img src="https://raw.githubusercontent.com/fjoglar/popular-movies-app/master/assets/youtube-videos.gif" width="250px" alt="Youtube Videos"/> | <img src="https://raw.githubusercontent.com/fjoglar/popular-movies-app/master/assets/favorites.gif" width="250px" alt="Favorites Functionality"/>


## How to build the app

1. Clone this repository in your local machine:

```
git clone https://github.com/abora97/popular-movies-app.git
```

2. Open Android Studio and open the project from `File > Open...`

3. Get a developer API key from [The Movie Database](https://www.themoviedb.org/) website (it's free!!).

4. Then inside the `gradle.properties` file substitute `your_tmdb_api_key_here` with your actual API key. Remember to not push your key to any public repository.

```
# The Movie Database Api Key
tmdbApiKey = "your_tmdb_api_key_here"
```


## Languages, libraries and tools used

* [Java](https://docs.oracle.com/javase/8/)
* Android Support Libraries
* [RxJava3](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0)
* [Retrofit](https://github.com/square/retrofit)
* [Gson](https://github.com/google/gson)
* [Picasso](https://github.com/square/picasso)
* [Butterknife](https://github.com/JakeWharton/butterknife)


## Requirements

* JDK 1.8
* [Android SDK](https://developer.android.com/studio/index.html)
* Android O ([API 27](https://developer.android.com/preview/api-overview.html))
* Latest Android SDK Tools and build tools.


## License

```
Copyright 2018 Felipe Joglar Santos

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

>##### **NOTE:** This project was submitted by Felipe Joglar as part of the Android Developer Nanodegree At Udacity.
>##### As part of Udacity Honor code, your submissions must be your own work, hence submitting this project as yours will cause you to break the Udacity Honor Code and the suspension of your account.
>##### Me, the author of the project, allow you to check the code as a reference, but if you submit it, it's your own responsibility if you get expelled.
>##### Besides this notice, the above license applies and this license notice must be included in all works derived from this project.

>##### **NOTE 2:** The images from the logo and empty view used within this app were created by [Graphicrepublic - Freepik.com](https://www.freepik.es/fotos-vectores-gratis/fondo)</a>.
