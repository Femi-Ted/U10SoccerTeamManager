package teammanager;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Interface for Model defines operations to manage Team for an U10 soccer Team.
 */
public interface U10Team {

  /**
   * Get the list of players that made the team.
   * Team must have at least 10 and at most 20 of the most skilled players.
   * To be on this list, players must have an assigned Jersey Numbers.
   *
   * @return an ArrayList of U10 players with no more than 20 members.
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *      if player's birthdate is > 10 or < 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  ArrayList<U10Player> getTeam()
        throws IllegalArgumentException, ParseException, NullPointerException;

  /**
   * Get the list of players who are on the starting lineup.
   * The starting lineup comprise seven of the most skilled players.
   * They have jersey numbers and official playing positions assigned.
   *
   * @return the starting lineup.
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *       if player's birthdate is > 10 or < 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  ArrayList<U10Player> getStartingLineup() throws ParseException;

  /**
   * Get the least skilled players - benchers.
   * These players don't have a jersey number nor official playing position.
   *
   * @return the list of benchers.
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *      if player's birthdate is > 10 or < 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  ArrayList<U10Player> getBenchers() throws IllegalArgumentException,
      ParseException, NullPointerException;

  /**
   * Get the count of the players on the raw team list being built.
   * @return the count of players on the raw list being built before team formation.
   */
  int countPlayersOnRawList();

  /**
   * Get the count of players on the team list.
   *
   * @return number of players on the team list.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  int countPlayersOnTeam() throws ParseException;

  /**
   * Get the count of players on the starting lineup list.
   *
   * @return number of players on the starting lineup list.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  int countPlayersOnStartingLineup() throws ParseException;

  /**
   * Get the count of players who are benchers.
   *
   * @return number of players who are benchers.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  int countBenchers() throws ParseException;

  /**
   * toString() variant to help output list of players who made the team.
   *
   * @return string list of team players.
   * @throws ParseException when string birthdate is of invalid format.
   */
  String printPlayersOnTeam() throws ParseException;

  /**
   * toString() variant to help output list of players on the Starting lineup.
   *
   * @return string list of starting lineup players.
   * @throws ParseException when string birthdate is of invalid format.
   */
  String printPlayersOnStartingLineup() throws ParseException;

  /**
   * toString() variant to help output list of players on the bench.
   *
   * @return string list of benchers.
   * @throws ParseException when string birthdate is of invalid format.
   */
  String printBenchers() throws ParseException;

  /**
   * Closes a valid player list so that team list can be generated.
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *                if player's birthdate is > 10 or < 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  void isfinalPlayerList() throws IllegalArgumentException, ParseException,
      NullPointerException;

  /**
   * Adds players to the raw list of players who would be evaluated for team formation.
   *
   * @param firstName the first name of the player to be added.
   * @param lastName the last name of the player to be added.
   * @param birthdate the birthdate of the player to be added.
   * @param newPosition the preferred playing position of the player to be added.
   * @param skillLevel the skill level of the player to be added.
   * @throws IllegalArgumentException if skill level is negative, above 5 and/or
   *                if player's birthdate is > 10 or < 5.
   * @throws ParseException when string birthdate is of invalid format.
   * @throws NullPointerException if non-null required parameter is null.
   */
  void addPlayersToList(String firstName, String lastName, String birthdate,
      U10PlayingPositions newPosition, int skillLevel)
      throws IllegalArgumentException, ParseException, NullPointerException;
}
