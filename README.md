# Fetch a List of Things
A simple app to retrieve a list of names from an API and display them in a (relatively) nice looking list.

It's quite basic in its implementation but generally follows clean code principles, even though it could be considered overkill for an app this size.

There are no special instructions to use the app. Build the app and deploy to a simulator or device and it automatically loads the data from the API on startup. There is a basic swipe to refresh feature, but the app doesn't have any means to delete or add items - so nothing changes on refresh other than you get a glimpse of the loading spinner.

If there is some sort of data loading problem, an error message shows on the screen instead of the list of items.

The next thing I'd do is to implement a sticky headers feature in the scrolling list to make it look a bit nicer, and I'd try to align the headers with the data columns more precisely.

### Tech used in this app

Retrofit2
Dagger - Hilt
Jetpack Compose  
JUnit  
Mockito  
[SwipeRefresh](https://google.github.io/accompanist/swiperefresh/)
