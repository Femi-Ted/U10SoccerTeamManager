package teammanager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a list of players for test purposes.
 */
public class U10PlayerGenerator {
  private static ArrayList<String> firstName;
  private static ArrayList<String> lastName;
  private static ArrayList<String> birthdate;
  private static ArrayList<U10PlayingPositions> preferredPlayingPosition;
  private static ArrayList<Integer> skillLevel;

  /**
   * Constructs a list of players from lists of attributes.
   *
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *      if player's birthdate is > 10 or < 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  public U10PlayerGenerator()  throws IllegalArgumentException, ParseException,
      IllegalStateException, NullPointerException {

    buildListOfFirstNames();
    buildListOfLastNames();
    buildListOfStringBirthdate();
    buildListOfPreferredPlayingPositions();
    buildListOfSkills();
  }

  /**
   * List of player's firstnames for player object construction.
   */
  private void buildListOfFirstNames() {
    ArrayList<String> setfirstName = new ArrayList<>();
    setfirstName.add("Tracy");
    setfirstName.add("Kemi");
    setfirstName.add("Judy");
    setfirstName.add("Ruth");
    setfirstName.add("Darcy");
    setfirstName.add("Yemisi");
    setfirstName.add("Racheal");
    setfirstName.add("Dianna");
    setfirstName.add("Elizabeth");
    setfirstName.add("Splice");
    setfirstName.add("Adriana");
    setfirstName.add("Emma");
    setfirstName.add("Olivia");
    setfirstName.add("Isabella");
    setfirstName.add("Ava");
    setfirstName.add("Sophia");
    setfirstName.add("Charlotte");
    setfirstName.add("Abigail");
    setfirstName.add("Victoria");
    setfirstName.add("Madison");
    setfirstName.add("Luna");
    setfirstName.add("Zoey");
    setfirstName.add("Chloe");
    setfirstName.add("Lily");
    setfirstName.add("Aria");
    setfirstName.add("Scarlett");
    setfirstName.add("Avery");
    setfirstName.add("Grace");
    setfirstName.add("Bisi");
    setfirstName.add("Shade");
    setfirstName.add("Tobi");
    setfirstName.add("Yetunde");
    setfirstName.add("Mariam");

    this.firstName = setfirstName;
  }

  /**
   * List of player's lastnames for player object construction.
   */
  private void buildListOfLastNames() {
    ArrayList<String> setlastName = new ArrayList<>();
    setlastName.add("Adams");
    setlastName.add("Nicola");
    setlastName.add("Judge");
    setlastName.add("Jobs");
    setlastName.add("Marconni");
    setlastName.add("Tudor");
    setlastName.add("Akindele");
    setlastName.add("Oguns");
    setlastName.add("Odejide");
    setlastName.add("Martins");
    setlastName.add("Figs");
    setlastName.add("Smith");
    setlastName.add("Johnson");
    setlastName.add("Williams");
    setlastName.add("Jones");
    setlastName.add("Brown");
    setlastName.add("Brown");
    setlastName.add("Rodriguez");
    setlastName.add("Torres");
    setlastName.add("Mitchell");
    setlastName.add("Reyes");
    setlastName.add("Cooper");
    setlastName.add("Adebayo");
    setlastName.add("Adeleke");
    setlastName.add("Akingba");
    setlastName.add("Akingba");
    setlastName.add("Marconni");
    setlastName.add("Tudor");
    setlastName.add("Akindele");
    setlastName.add("Oguns");
    setlastName.add("Jibola");
    setlastName.add("Jibola");
    setlastName.add("Figs");

    this.lastName = setlastName;
  }

  /**
   * List of player's correctly formatted string birthdates.
   */
  private void buildListOfStringBirthdate() {
    ArrayList<String> setStringBirthdate = new ArrayList<>();
    setStringBirthdate.add("2015-01-12");
    setStringBirthdate.add("2014-11-11");
    setStringBirthdate.add("2017-03-09");
    setStringBirthdate.add("2013-06-15");
    setStringBirthdate.add("2015-12-31");
    setStringBirthdate.add("2014-09-01");
    setStringBirthdate.add("2016-05-07");
    setStringBirthdate.add("2014-02-05");
    setStringBirthdate.add("2017-04-22");
    setStringBirthdate.add("2013-01-01");
    setStringBirthdate.add("2015-10-18");
    setStringBirthdate.add("2015-07-25");
    setStringBirthdate.add("2015-09-02");
    setStringBirthdate.add("2014-03-09");
    setStringBirthdate.add("2013-06-15");
    setStringBirthdate.add("2015-02-18");
    setStringBirthdate.add("2016-02-14");
    setStringBirthdate.add("2016-05-07");
    setStringBirthdate.add("2014-06-05");
    setStringBirthdate.add("2017-04-22");
    setStringBirthdate.add("2013-05-19");
    setStringBirthdate.add("2016-12-03");
    setStringBirthdate.add("2015-07-29");
    setStringBirthdate.add("2014-01-22");
    setStringBirthdate.add("2013-03-09");
    setStringBirthdate.add("2014-06-15");
    setStringBirthdate.add("2015-12-31");
    setStringBirthdate.add("2014-09-01");
    setStringBirthdate.add("2016-05-07");
    setStringBirthdate.add("2014-09-09");
    setStringBirthdate.add("2017-01-15");
    setStringBirthdate.add("2014-01-01");
    setStringBirthdate.add("2015-04-04");

    this.birthdate = setStringBirthdate;
  }

  /**
   * List of player's preferred playing positions.
   */
  private void buildListOfPreferredPlayingPositions() {
    ArrayList<U10PlayingPositions> setStringPlayingPosition = new ArrayList<>();
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.GOALIE);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.MIDFIELDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);
    setStringPlayingPosition.add(U10PlayingPositions.DEFENDER);
    setStringPlayingPosition.add(U10PlayingPositions.FORWARD);

    this.preferredPlayingPosition = setStringPlayingPosition;
  }

  /**
   * List of player's skill levels.
   */
  private void buildListOfSkills() {
    ArrayList<Integer> setSkillLevels = new ArrayList<>();
    setSkillLevels.add(1);
    setSkillLevels.add(2);
    setSkillLevels.add(4);
    setSkillLevels.add(3);
    setSkillLevels.add(5);
    setSkillLevels.add(3);
    setSkillLevels.add(5);
    setSkillLevels.add(5);
    setSkillLevels.add(1);
    setSkillLevels.add(4);
    setSkillLevels.add(2);
    setSkillLevels.add(5);
    setSkillLevels.add(2);
    setSkillLevels.add(4);
    setSkillLevels.add(5);
    setSkillLevels.add(5);
    setSkillLevels.add(3);
    setSkillLevels.add(5);
    setSkillLevels.add(5);
    setSkillLevels.add(5);
    setSkillLevels.add(4);
    setSkillLevels.add(2);
    setSkillLevels.add(5);
    setSkillLevels.add(2);
    setSkillLevels.add(5);
    setSkillLevels.add(3);
    setSkillLevels.add(4);
    setSkillLevels.add(3);
    setSkillLevels.add(2);
    setSkillLevels.add(5);
    setSkillLevels.add(5);
    setSkillLevels.add(4);
    setSkillLevels.add(2);

    this.skillLevel = setSkillLevels;
  }

  /**
   * Builds a single list of U10Player objects with thirty-three players.
   *
   * @return  a single list of a 33 players.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  public ArrayList<U10Player> getThirtyThreePlayersOnList() throws ParseException {
    int i;

    ArrayList<U10Player> newPlayerList = new ArrayList<>();

    for (i = 0; i < firstName.size(); i++) {
      newPlayerList.add(
        new U10PlayerImpl(firstName.get(i), lastName.get(i), birthdate.get(i),
            preferredPlayingPosition.get(i), skillLevel.get(i)));
    }
    return newPlayerList;
  }

  /**
   * Builds a single list of U10Player objects with eleven players.
   *
   * @return  a single list of a 9 players.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  public ArrayList<U10Player> getElevenPlayersOnList() throws ParseException {
    int i;
    int invalidTeamSize = 11;

    ArrayList<U10Player> newPlayerList = new ArrayList<>();

    for (i = 0; i < invalidTeamSize; i++) {
      newPlayerList.add(
          new U10PlayerImpl(firstName.get(i), lastName.get(i), birthdate.get(i),
              preferredPlayingPosition.get(i), skillLevel.get(i)));
    }
    return newPlayerList;
  }
  /**
   * Builds a single list of U10Player objects with nine players.
   *
   * @return  a single list of a 9 players.
   * @throws ParseException if the string birthdate is of invalid format.
   */

  public ArrayList<U10Player> getNinePlayersOnList() throws ParseException {
    int i;
    int invalidTeamSize = 9;

    ArrayList<U10Player> newPlayerList = new ArrayList<>();

    for (i = 0; i < invalidTeamSize; i++) {
      newPlayerList.add(
          new U10PlayerImpl(firstName.get(i), lastName.get(i), birthdate.get(i),
              preferredPlayingPosition.get(i), skillLevel.get(i)));
    }
    return newPlayerList;
  }

  /**
   * Builds a single list of U10Player objects with one players.
   *
   * @return  a single list of a 9 players.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  public ArrayList<U10Player> getOnePlayerOnList() throws ParseException {
    int i;
    int invalidTeamSize = 1;

    ArrayList<U10Player> newPlayerList = new ArrayList<>();

    for (i = 0; i < invalidTeamSize; i++) {
      newPlayerList.add(
          new U10PlayerImpl(firstName.get(i), lastName.get(i), birthdate.get(i),
              preferredPlayingPosition.get(i), skillLevel.get(i)));
    }
    return newPlayerList;
  }
}

