# U10SoccerTeamManager

This is the implemenation of an under 10 soccer team manager.  An application that allows a user to create a team of players from added list of players and from this list generate a starting lineup.

## **An Overview of the problem:**
It is sometimes difficult to make a decision on which players in a soccer club should be allowed to play in a team let alone join the starting line up of players for the season.  Decisions like who get's to be the Forward, the Goalie, the Defender etc.; who gets benched, who gets assigned a particular jersey number outside player personal preferrences, who is probably too young to play considering age disparities, provides many constraints for a good decision that would alway guarantee build-up of a strong team towards team success during any playing season.  

Therefore, rather than leave this decision making process to a human who could be influenced by external forces, this application aims to automate the process using a data orientated approach to decide which player gets to make the team and be on the starting lineup using features designed to capture relevant data from the user/coach.

## Features of U10SoccerTeamManager <br>
The features available on the U10SoccerTeamManager application through it's Dashboard are:

1. **First Name Text Field**: This allows the user to input a player's firstname.

2. **Last Name Text Field**: This allows the user to input a player's lastname.

3. **Birthdate Text Field**: This allows the user to input a player's birthdate.

4. **Preferred Position**: This allows the user to select a player's preferred playing position from a drop down list. In the backend, the selected player's preferred playing position is only approved as their official playing position when the player's skill level is the highest level, a 5, and only when the position is available when being processed. For example, in the case of the GOALIE position, once a GOALIE is assigned to the first Player on the list with the highest skill level, all other player's with the preferred playing position of a GOALIE and who have made the team, are officially reassigned another playing position based on a randomization algorithm.  Any player that makes the team list and does not have a skill level of 5 is refused their preferred playing position and rather gets assigned a random position based on availablity.

5. **Skill Level Text Field**: This allows the user to input a player's skill level between 0 and 5 inclusive.

6. **The Add Player Button**: This allows the user to add a player for processing and in so doing build a raw list of players that are available in the club and ready for assignment to a team.

Below, the section of the dashboard that hosts the above explained features is shown in figure 1.

<img width="914" alt="Screenshot 2023-04-21 at 20 26 53" src="https://user-images.githubusercontent.com/46625599/233759585-8bdf27a0-cadc-4a81-9d55-934a236a2846.png">
   *Figure 1: Dashboard screenshort showing section that takes in player profile details for addition into raw list of players*
