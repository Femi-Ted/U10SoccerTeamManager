package teammanager;

import java.text.ParseException;

/**
 * Interface for player object in an under 10 soccer club.
 */
public interface U10Player {

  /**
   * Get the firstname of the player.
   *
   * @return the firstname of the player.
   */
  String getFirstName();

  /**
   * get the lastname of the player.
   *
   * @return the lastname of the player.
   */
  String getLastName();

  /**
   * Get player's birthdate.
   *
   * @return the player's birthdate.
   */
  String getBirthdate();

  /**
   * Get the age of the player.
   *
   * @return the age of the player.
   */
  int getAge() throws ParseException;

  /**
   * Set a randomly generated jersey number for the player.
   *
   * @param jerseyNumber the jersey number randomly assigned.
   */
  void setJerseyNumber(int jerseyNumber);

  /**
   * Get a player's jersey number.
   *
   * @return the player's jersey number.
   */
  int getJerseyNumber();

  /**
   * Set a player's officially assigned playing position.
   *
   * @param assignedPlayingPosition the playing position randomly assigned.
   */
  void setOfficialPlayingPosition(U10PlayingPositions assignedPlayingPosition);

  /**
   * Get a player's officially assigned playing position.
   *
   * @return the player's officially assigned playing position.
   */
  U10PlayingPositions getOfficialPlayingPosition();

  /**
   * Get player's preferred playing position.
   *
   * @return player's preferred playing position.
   */
  U10PlayingPositions getPreferredPlayingPosition();

  /**
   * Set player's skill level.
   *
   * @param newSkillLevel the skill level assigned.
   */
  void setSkillLevel(int newSkillLevel);

  /**
   * Get player's skill level.
   *
   * @return player's skill level.
   */
  int getSkillLevel();
}
