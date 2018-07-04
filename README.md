# ZomatoRestaurantTracker

#### Specifications :

Make a list of restaurants based upon the coordinates entered by the user using the Zomato public api (endpoint = /geocode ) with the following minimum requirements:
- Generate a new api-key from developers.zomato.com and use it for all your API calls
- App should show a list of restaurants from the api
- Each list item should have a preview (scaled down) image and its title.
- Clicking on any preview image item should open a new detail screen. 
- Detail screen should contain a large version on that image, title, User reviews (endpoint = /reviews ) and the following 3 buttons:
	1. “Photos url” : shares/opens the url .
	2. “Menu Url” : shares/opens the url.
	3. "Events Url": shares/opens the url
- Swiping right or left should display next or previous restaurant respectively.
- The data from API responses should be stored locally on device. In case of no network connectivity
the user should still be able to view and share the various urls that they have loaded previously. You are
expected to implement this using a database system of your choice.

#### Setup Instructions :

The project is based on Android Studio and is written in Kotlin.
Please make sure to obtain an development key from developers.zomato.com. You need to add it to your gradle.propoerties file.
```
ZomatoAPIKEY="YOUR_ZOMATE_API_KEY_GOES_HERE"
```

#### Proposed Soultion :

- The app follows MVVM architecture.
- Data is cached using Room Library.
- The app uses several other technologies such as Android Data Binding, Dependency Injection, Reactive Programming.

#### Libraries Used :

- **Dagger Core and Android** (Dependency Injection)
- **Android Architecture Components and Room** (Database)
- **rxjava2** (Java and Android)
- **OkHttp, Retrofit and GSON** (Networking Parsing and Caching)
- **Timber and Android Debug Database** (Debugging)
- **Glide** (Image Loading and Caching)

#### The app has following packages:
- **data**: It contains all the data accessing and manipulating components.
- **di**: Dependency providing classes using Dagger2.
- **ui**: View classes along with their corresponding ViewModel.
- **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Contributing to ZomatoRestaurantTracker
Just make pull request. You are in!
