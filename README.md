# ucsb-cs56-u-to-do
# Fall 2018

Group members: 
Sam 
Erez
Siqi
Sergei
Marco
Sihua

Mentor: 
Diego

This project is a to-do list web-app that allows the user to create a list of things they need to accomplish giving them a way to organize their schedule

URL to main webapp: https://ucsb-cs56-u-to-do.herokuapp.com

-------------------------Test Instructions-----------------------
 - In order to run the application locally, perform the following steps:
1. Clone the repo
2. Extract the zip of the repo you cloned into your local file path
3. From the folder in your file path, execute the command: "mvn spring-boot:run"
4. Go to localhost:8080 in your browser.

 - In order to run the application on Heroku:
1. Go to the following url: https://ucsb-cs56-u-to-do.herokuapp.com

 - Once you are on the main page of the webapp do the following to test its features:
1. Enter an email address in the field labeled "Username." (if you already have an account, you should be able to login with your own username and password by select the button "Sign In")
2. Enter a password in the field labeled "Password."
3. Select the "Sign Up." button. You have now created an account. 
4. To create to-do enter a date in the "Date" field, type some text in the "To-Do" field(indicating the name of your to-do), and select one of the three options from the drop down list labeled "Urgency" to indicate how urgent the to-do is. Press "Submit" in order to create the to-do. The newly created to-do will appear in a list below the the "Urgency" drop down menu. 
5. Repeat step 4 to add some more to-dos. 
6. By default the list is sorted by urgency. To switch back and forth from sorting by urgeny to sorting by due date simply click on the "Sort By Dates" button or the "Sort By Urgency" button located at the top of the list.
7. To remove an entry from the list click on the "x" located to the right of the to-do you want to delete. 
8. To log out of the webapp click the "Sign out"
9. If you login using the same username and password later, you should still be able to see your created to-dos.

<br/>

Link to Running Version of Side Project #1 (Firebase login issue): https://utodo2.herokuapp.com/index.html -- Link to Repo:  https://github.com/ucsb-cs56-f18/sk-u-to-do-issue4. To test the side project enter an email (doesn't have to be a valid email just the proper email format) as the user name, enter a password, and select "sign up". A "sign out" button will appear indicating that you are signed in and have access to the database.


Line to repo for Side Project #2 (Create a to-do list using a java data structure): https://github.com/ucsb-cs56-f18/ucsb-cs56-f18-u-to-do-side-issue-2. To test this code fork the repo and from the top of the directory type the following lines into the console window: "javac ToDoListTest.java" and "java ToDoList".


# f18 final remarks

Before starting adding anything to this project, you should probably go and set up your firebase by setting up the firebase account. Then hit the add-project button, and set up your firebase for this webapp. 


Copy this:

~~~
{
  "notUrgent" : true,
  "urgent" : true,
  "veryUrgent" : true
}
~~~

to /urgencyCategory in firebase database

Copy this:

~~~
{
  /* Visit https://firebase.google.com/docs/database/security to learn more about security rules. */
  "rules": {
    "$uid": {
      ".read": "auth.uid == $uid",
      ".write": true,
      "$events": {
        ".validate": "newData.hasChildren(['date','message','urgency'])",
        "date": {
          ".validate": "newData.val().matches(/^(0[1-9]|1[012])[\/](0[1-9]|[12][0-9]|3[01])[\/]((19|20)[0-9][0-9])$/)"
        },
        "message": {
          ".validate": "newData.isString() && newData.val().length<100"
        },
        "urgency": {
          ".validate": "newData.isString() && root.child('urgencyCategory/'+newData.val()).exists()"
        },
        "$others": {
          ".validate": false
        }
      }
    }
  }
}
~~~

to rules in firebase database.

Once you have your database,

go to settings/general/

then click "Add Firebase to your webapp"
and copy the information anywhere in head_common.ftl

The database should be working.

For more firebase guidance, this has information you need: https://firebase.google.com/docs/web/setup?authuser=0

