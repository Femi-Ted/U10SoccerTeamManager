# U10SoccerTeamManager

This is the implemenation of an under 10 soccer team manager.  An application that allows a user to create a team of players from added list of players and from this list generate a starting lineup.


# An Overview of the problem:
It is sometimes difficult to make a decision on which players in a soccer club should be allowed to play in a team let alone join the starting line up of players for the season.  Decisions like who get's to be the Forward, the Goalie, the Defender etc.; who gets benched, who gets assigned a particular jersey number outside player personal preferrences, who is probably too young to play considering age disparities, provides many constraints for a good decision that would alway guarantee build-up of a strong team towards team success during any playing season.  

Therefore, rather than leave this decision making process to a human who could be influenced by external forces, this application aims to automate the process using a data orientated approach to decide which player gets to make the team and be on the starting lineup using features designed to capture relevant data from the user/coach.

<br />

# Features of U10SoccerTeamManager(Using The View/Dashboard)

The features available on the U10SoccerTeamManager application through it's Dashboard are:

1. **First Name Text Field**: This allows the user to input a player's firstname. It is assumed that user would be responsible for inputing valid player's firstnames. Under the hood, this is a String input.

2. **Last Name Text Field**: This allows the user to input a player's lastname. It is assumed that user would be responsible for inputing valid player's lastname.  Under the hood, this is a String input.

3. **Birthdate Text Field**: This allows the user to input a player's birthdate.  Player's birthdate must be of the right format "yyyy-MM-dd" and must be representative of a player not less than 5 years of age nor of age 10 and above. It is assumed that user would ensure that integer values are used in the provided format to represent the birthdate.  Under the hood, this is a String input that is converted to a LocalDate object.

4. **Preferred Position**: This allows the user to select a player's preferred playing position from a drop down list. In the backend, the selected player's preferred playing position is only approved as their official playing position when the player's skill level is the highest level, a 5, and only when the position is available when being processed. For example, in the case of the GOALIE position, once a GOALIE is assigned to the first Player on the list with the highest skill level, all other player's with the preferred playing position of a GOALIE and who have made the team, are officially reassigned another playing position based on a randomization algorithm.  Any player that makes the team list and does not have a skill level of 5 is refused their preferred playing position and rather gets assigned a random position based on availablity. It is assumed that user would ensure that the appropriate playing position is selected for each player being added. Under the hood, this is an Enumerator Class input that is converted from the user's text input.

5. **Skill Level Text Field**: This allows the user to input a player's skill level between 0 and 5 inclusive.  The skill level player detail is used to sort player in a descending order of skill level so that the best players are always selected first.  It is assumed that user would ensure valid integer skill level input for each player being added.  Under the hood, this is an interger input that is converted from the user's text input.

Below is the section of the dashboard that hosts the above explained features.  These set of features are also the parameters that the user must supply in order to add the required number of players for team formation or generation of starting lineup.

<img width="912" alt="Screenshot 2023-04-21 at 21 26 43" src="https://user-images.githubusercontent.com/46625599/233762430-6d126385-6714-41f7-9019-bc176691e837.png">
   Figure 1: Dashboard's screenshort showing section that takes in player profile details for addition into raw list of players. <br>

<br />


# Other Features of U10SoccerTeamManager (Using The View/Dashboard) <br>

6. **The Add Player Button**: This allows the user to add a player for processing and in so doing build a raw list of players that are available in the club and ready for assignment to a team.

7.  **Error/Notification Text Field**: This text field section notifies the user of the many different change of states happening when player information is being added to the application.  These notifications includes, when a player is above or below the required age, the required number of player that must be added before actual team formation can occur, when players are successfully added, when skill level provided for a player is invalid, etc.  This section is highlighted in figure 2 below.

<br />

<img width="908" alt="Screenshot 2023-04-21 at 21 25 30" src="https://user-images.githubusercontent.com/46625599/233762390-1686aec0-cae7-4e74-86d6-f9e32a150291.png">
Figure 2: Dashboard's screenshort showing notification area. <br>


<br />

8.  **Create Team Button**: This button allows the user to create a list of players that would be considered to be members of the team. The "Create Team Button" is deactivated until at least 10 players have been added to the raw list. This means that the raw list of players is controlled to be of the size of 10 or greater, but not less.  Once the "Create Team" button is active, it means there are at least 10 players in the raw list.  Clicking this button would finalize the raw list and prevent addition of new players while setting the stage for the sorting of players by skill level ready for team formation.

9.  **Get Team Players Button**: This button becomes active only when the raw list of players have been closed for addition of new players. This way, user can be assured of a proper sorting of players already added. It is assumed that user is aware that once this button is clicked, that the official team list of players would be created and would only comprise of either a minimum of the best 10 players, if only 10 players were added, or a maximum of the best 20 players if more than 20 players are added, all with their jersey numbers randomly assigned. Also, clicking this button would display the list of these players and their assigned jersey numbers.  The expected list of players would be displayed in the format, "Firstname, Lastname, Jersey Number".  The user cannot influence the assignment of jersey numbers.  The list generated is sorted lexicographically by lastname.

10. **Get Starting Lineup**: This button becomes active only when the raw list of players is closed, that is, when the "Create Team" button has been clicked. Under the hood of this application, the list of starting line up comprise the first 7 best players who have been assigned jersey numbers from the list of those enlisted on the team and who now gets assigned official playing positions.  Implementing my Get Starting Lineup this way provides a one-click access to the starting lineup for the user once the raw list of players have been closed by clicking the "Create Team" button.

Below are the screenshots of the dashboard showing the change in state of the three buttons whose operations are described above.  Figure 3 shows a screenshot of the buttons still deactivated when the minimum required number of players for a raw list has not be met versus Figure 4 which shows a screenshot of the buttons now active after the "Create Team" button was clicked when the minimum players that should be on the raw list was met.

<br />

<img width="912" alt="Screenshot 2023-04-21 at 21 42 12" src="https://user-images.githubusercontent.com/46625599/233762958-e4cf9dca-68e0-42d1-9d9a-eb43f1351061.png">
Figure 3: Dashboard's screenshort showing "Create Team", "Get Team Players" and "Get Starting Lineup" buttons deactivated because minimum player requirement to form a raw list has not been met. <br>

<br />


<img width="907" alt="Screenshot 2023-04-21 at 21 46 36" src="https://user-images.githubusercontent.com/46625599/233763095-9de18344-48d3-45dc-85a5-45761dc2fb2b.png">
Figure 4: Dashboard's screenshort showing "Create Team", "Get Team Players" and "Get Starting Lineup" buttons activate because minimum player requirement was met and "Create Team" button was clicked. <br>

<br />


11. **The Information Area**: This is the text area where the information about the players who made the team list and starting lineup list are displayed.  Figure 5 shows the "Players on Starting Lineup" list as an example. 


<br />

<img width="915" alt="Screenshot 2023-04-21 at 21 50 32" src="https://user-images.githubusercontent.com/46625599/233763205-3e33defc-2cea-4b84-adb4-5fa8a8ca72ec.png">
Figure 4: Dashboard's screenshort showing information area for display Team Players and the Starting Lineup. <br>

<br />


# Running the Jar File
To run the Jar file or the U10SoccerTeamManager application, user should double click on the file to load the dashboard and follow these steps:

   1. Input player details while ensuring they are accurate and valid input types as described in [#Features of U10SoccerTeamManager(Using The View/Dashboard)
](#features-of-u10soccerteammanagerusing-the-viewdashboard) section.  User details required are:
         -  player's firstname.
         -  player's lastname.
         -  player's birthdate.
         -  player's preferred playing position.
         -  player's skill level.
         
   2. On supplying all the above player details into their appropriate text fields, click the "Add Player" button.
   
   3. Ensure that on a minimum, 10 players are added successfully.  More players can be added without restrictions once this minimum is attained. 
   
   4. Click on the "Create Team" button to finalize the list of players and halt further addition of players to the raw list.
   
   5. Click on "Get Team Players" to view the list of players who made the team.  You will only see from 10 (minimum) or 20 (maximum) players displayed with their firstname, lastname and assigned jersey number, all arranged lexicographically by their lastname.
   
   6. Click on "Get Starting Lineup" to view the list of players who made the starting lineup.  Here player information is would be displayed in the order of firstname, lastname, assigned jersey number and officially assigned/approved playing positions.

   7. User can close the program once done.

<br />


# Arguments Required To Run The Application.
User should follow the detailed description at [#Features of U10SoccerTeamManager(Using The View/Dashboard)
](#features-of-u10soccerteammanagerusing-the-viewdashboard) section.  The first five described features represents the parameters the user must provide to the application, and must be provided to meet the minimum requirement of the program which requests that at least 10 players must be added before a team can be formed.

<br />


# Program Development Assumptions.
It should be noted that some assumptions had to be made within the constraint of the time required to build this application and provide a README.md file to explain U10SoccerTeamManager functionalities: The assumptions are:

1. That this README.md is targeted at a user and not a programmer.

2. That distinct player profiles are added to the application.

3. That no player below the age of 5 or exactly 10 years old and above should be able to join this team.

4. That all player profile information are provided before the “Add Player” button would be clicked.

5. That valid inputs are taken and no attempt is made by user to break the application by passing extraneous data types into each text field.

6. That all fields are not expected to pass null or empty values through.

7. That a Preferred Playing position is always selected for a player

8. That the user is aware that clicking on the Create Team list would finalize the raw list, that is, prevent any addition of new players to the raw list.

9. That all actions are performed by mouse clicks.

10. That user carries the obligation to ensure that same player information is not entered twice. Hence the reason why the text fields are cleared in readiness for new inputs.

11. That after create team button is pressed, it is not expected that user would add more players, but only proceed to get the team players or get the starting lineup.

12. That basic functionalities to extract a Team list and Starting lineup are required.


<br />

# Limitations of this program.
Going by the time constraints for building this application, the following limitations are evident:
1. Clicking on "Add Player" button when all text fields are empty would break the program.  This should not be so but should cause the appropriate errors for rejecting null inputs and invalid types to be raised.  However, this could not be fixed before submission, hence the assumption that user would be responsible for ensuring valid inputs.

2. When one of either firstname or lastname is missing, the program still permits the addition of players.  This behaviour needs to be fixed.

3. When selecting a preferred playing position and user mistakenly chooses the prompt to select a position, clicking on the Add Player button should have notified the user to select a preferred position.

4. Non-integer values can be used as skill level inputs.  This should be prevented.

5. The error/notification area is not catching all exceptions being thrown.

6. The outputs of the Team Players and Starting Lineup to the information area should have been formatted for easier readability.

7. Currently, program can keep adding same player with same profile indefinitely.  This should be addressed.

8. Program cannot uniquely identify if duplicate players or siblings are being enlisted.  This should be checked and user notified to make verifications.

9. Null as a value and empty fields can be successfully enlisted with the Add Player button provided the preferred position is assigned, the skill level provided and the birthdate format adhered to.  This is a major flaw on the part of the program.

10. The UML diagram is not updated to the current state of the entire implementation and so is not reliable for replicating the implementation of this program.


<br />

# Changes Made To The Program After Second Submission.
1. The Model's Constructor was updated so that while it previously took in a player list, now it takes in no parameter.  This was required to ensure that the model can in coupling with the Controller allow players to be added individually through the view and controller for the formation of a raw list. This necesitated the removal of the team list parameter and the introduction of the isTeamFinalized instance attribute which is used to control the minimum player number requirement for a raw player list formation.  It would be noticed in the new code too that some of the check functionalities for the team list previously at the Constructor have now been relocated for management to the isFinalPlayerList() method.

2. The addPlayerToList() method was added to the Model to provide the required coupling to the Controller so that appropriate user inputs converts to the relevant parameters for player addition to the raw list required for team formation.

3. The isFinalPlayerList() method was added to provide all the checks to the raw ArrayList of players being built using the instance attribute "teamPlayers".  In this method, we confirm that the list being built is not empty, is above the required minimum, generated and appended the jersey numbers to the first 20 players, and close the raw list so that no additional players can be added once jersey numbers have been assigned.

4. The countPlayersOnRawList() method was used to provide a hook to the Controller so that with it, the Model can inform the user if they have met the requirements of the number of players needed enlisted before a team can be formed.

5. Aside above newly added methods, minor updates had to be made to dependent methods to ensure that required functionality carried through to the Controller and View.


<br />

# Conclusion.
U10SoccerTeamManager still requires developmental work and aside fixing the bugs highlighted above it would be help serve its true purpose if additional metrics were introduces to ensure that not only Skill level is used to identify the best players.  Other metrics that can be used include, player height, player's metric for advancing team cohesion, tracking player infractions as a function to benching them, etc.

I will in future look to this.


# Bibliography


   -  University of Texas. "Explanation of Deep and Shallow Copying", (n.d.). Retrieved March 27, 2023 from https://www.cs.utexas.edu/~scottm/cs307/handouts/deepCopying.htm

   -  Oracle, "Class LocalDate", (n.d.). Retrieved March 29, 2023, from https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html 

   -  L. Gupta, - HowToDoInJava - "Convert String to LocalDate in Java", February 7, 2023. Retrieved March 29, 2023, from https://howtodoinjava.com/java/date-time/localdate-parse-string/ Last Updated: 

   -  Oracle Java Documentation "Class Collections", (n.d.). Retrieved March 29, 2023, from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html


   -  Stackoverflow "Collections.sort with multiple fields", (n.d.). Retrieved April 10, 2023, from https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields

   -  JavaTPoint. “Java Swing Tutorial - javatpoint,” (n.d.). www.javatpoint.com. Retrieved April 16, 2023, from https://www.javatpoint.com/java-swing.

   -  Stackoverflow. "How to return the string equivalent of an enum value", (n.d.). Retrieved April 16, 2023, from https://stackoverflow.com/questions/66210201/how-to-return-the-string-equivalent-of-an-enum-value

   -  Baeldung. "Attaching Values to Java Enum", February 12, 2023, Retrieved April 16, 2023, from https://www.baeldung.com/java-enum-values

   -  JavaTPoint, "Java GridBagLayout", (n.d.). Retrieved April 16, 2023, from https://www.javatpoint.com/java-gridbaglayout, 

  -  Oracle Java Documentation, "How to use GridBagLayout", (n.d.).  Retrieved April 15, 2023, From https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 
  -  TutorialsPoint, "SWING - GridBagLayout Class", (n.d.). Retrieved April 16, 2023, from https://www.tutorialspoint.com/swing/swing_gridbaglayout.htm

  -  FAQs, "clearJTextArea", (n.d.). Retrieved April 18, 2023, from https://coderanch.com/t/339140/java/clear-JTextArea 
  
   -  Java Swing , "Enable or disable buttons in Swing" - 2016. Retrieved April 18, 2023. from http://www.java2s.com/example/java/swing/enable-or-disable-buttons-in-swing.html


   -  Oracle, Java Documentation, The Java Tutorials "How to Use Text Fields", (n.d.). Retrieved April 18, 2023, from https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html

   -  Oracle, "Class Component", (n.d.).  Retrieved April 18, 2023, from     https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Component.html#disableEvents(long)

   -  Cambria Heights School Descrict, "Lesson 7 Part 2 Flags", (n.d.). Retrieved April 19, 2023, from   https://www.chsd1.org/cms/lib/PA01001446/Centricity/Domain/189/Lesson7%20Part%202%20Notes.pdf

   -  Educative. "Ternary operator in Java." (n.d.). Retrieved April 20, 2023, from https://www.educative.io/answers/ternary-operator-in-java?utm_campaign=brand_educative&utm_source=google&utm_medium=ppc&utm_content=performance_max&eid=5082902844932096&utm_term=&utm_campaign=%5BNew%5D+Performance+Max&utm_source=adwords&utm_medium=ppc&hsa_acc=5451446008&hsa_cam=18511913007&hsa_grp=&hsa_ad=&hsa_src=x&hsa_tgt=&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjw6IiiBhAOEiwALNqncSrU5yloTIpv8RvgtJ9z6qO92y3gTSs2T3w3kbUVqjr78CVGZjfOThoCuUMQAvD_BwE


   -  GitHub Docs "Basic writing and formatting syntax", (n.d.). Retrieved April 21, 2023 from https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
