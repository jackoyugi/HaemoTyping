
# HaemoTyping

## About
App for blood group typing and detection. This app can help in emergecy identification of blood donors blood groups and clinical history, saving life of accident victims and those in dier need of blood.

## Project Structure
Folk the project from `https://github.com/jackoyugi/HaemoTyping` git repo<li/>
Clone the project in any folder on your local machine using command `git clone https://github.com/jackoyugi/HaemoTyping `<li/>
Open the project in android studio or intelliJ IDE editors <li/>
Finally Run the app in android studio emulator</li>


The project main files are located under *app/src/main/* and are divided in three main folders:
* assets/ <br/>
This folder contains
* res/ <br/>
The resources folder stores the files for every UI component of the app.
    * This folder contains the XML files for animations within the app.
  * drawable/ (for various resolutions)
    * This folder has contains images used in the layouts.
  * layout/
    * The layout folder contains XML files for every UI in the app, for every Activity and Fragment.
  * menu/
    * This folder contains only a couple of UI files for the Action Bar menu of some activities.
  * raw/
    * This folder......
  * values/
    * This folder contains XML files for values used in the app, such as color Hex codes, strings and dimensions.

* java/main/haemotype/app/ <br/>
This is folder contains all the source code for the app. The code is divided in several packages, as shown below.
  * activity
    * This package contains all the Activities of the app, each one with a corresponding XML file in the resources folder.
  * adapter
    * This package contains the Adapters used in Activities and Fragments.
  * api
    * This package basically contains...............
  * data
    * This package is very important for the database configuration.
  * fragment
    * The fragment package contains all the Fragments of the app.
  * model
    * This package contains the model classes for each table in the database.
  * util
    * Finally, this package some random utility files, used to store the user information.


Some useful tools used during development:

*   Java - Java SDK is the primary language used in the development of this mobile app
*   Gradle -
* Android Studio - Download android studio latest version and run the project in the studio editor

## Behavior Driven Development
 | Behavior :                                | Input:                                                                     | Output:
 | :---------------------------------------- | :--------------------------------------------------------------------------| :-------------
 |  Users Authentication                     | Users login in or create users accounts                                    | Access received or denied
 | Users Submit form of Blood group          | Inputted Location and Blood group                                          | Location and blood group displayed
 |                                           |                                                                            |
 |                                           |                                                                            |

## Repo Link
https://github.com/jackoyugi/HaemoTyping


## Support and contact details
contact   info@biofit.co.ke.

<br/>
Jack Oyugi<br/>
jack.oyugi@uonbi.ac.ke<br/>
Moringa School 2020 Student<br/>
&The University of Nairobi<br/>




