package teammanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * This class represents an Under 10 soccer Player person.
 */
public class U10PlayerImpl implements U10Player {
  private final String firstName;
  private final String lastName;
  private final String stringBirthdate;
  private U10PlayingPositions preferredPlayingPosition;
  private U10PlayingPositions officialPlayingPosition;
  private int skillLevel;
  private int jerseyNumber;
  private boolean jerseryNumberIsSet = false;

  /**
   * Constructs an under 10 soccer player object and instantiates it with the given parameters.
   *
   * @param firstName         the first name of this U10 soccer player.
   * @param lastName          the last name of this U10 soccer player.
   * @param stringBirthdate       the date of birth of this U10 soccer player.
   * @param preferredPlayingPosition the preferred position of play of this U10 soccer player.
   * @param skillLevel        the skill level of this U10 soccer player.
   * @throws IllegalArgumentException if the skill level is negative or above 5 or
   *        if birthdate is for player older than 10 or less than 5.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if any parameter passed is null.
   */
  public U10PlayerImpl(String firstName, String lastName, String stringBirthdate,
      U10PlayingPositions preferredPlayingPosition, int skillLevel)
      throws IllegalArgumentException, IllegalStateException, ParseException, NullPointerException {
    checkBirthdate(stringBirthdate);
    checkNames(firstName, lastName);
    checkPreferredPlayingPosition(preferredPlayingPosition);
    checkSkillLevel(skillLevel);

    this.stringBirthdate = stringBirthdate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.preferredPlayingPosition = preferredPlayingPosition;
    this.officialPlayingPosition = null;
    this.skillLevel = skillLevel;
    this.jerseyNumber = 0;
  }

  @Override public String getFirstName() {
    return this.firstName;
  }

  @Override public String getLastName() {
    return this.lastName;
  }

  @Override public String getBirthdate() {
    return this.stringBirthdate;
  }

  @Override public int getAge() throws IllegalArgumentException, ParseException {
    LocalDate dob = getLocalDateOfBirth();
    LocalDate now = LocalDate.now();
    return Period.between(dob, now).getYears();
  }

  @Override public void setJerseyNumber(int jerseyNumber) throws IllegalStateException {
    if (!this.jerseryNumberIsSet) {
      this.jerseyNumber = jerseyNumber;
      this.jerseryNumberIsSet = true;
    } else {
      throw new IllegalStateException("Jersey number allocation is complete. "
          + "Team list is finalized. To add more players, start over!");
    }
  }

  @Override public int getJerseyNumber() {
    return this.jerseyNumber;
  }

  @Override public void setOfficialPlayingPosition(U10PlayingPositions assignedPlayingPosition) {
    this.officialPlayingPosition = assignedPlayingPosition;
  }

  @Override public U10PlayingPositions getOfficialPlayingPosition() {
    return this.officialPlayingPosition;
  }

  @Override public U10PlayingPositions getPreferredPlayingPosition() {
    return this.preferredPlayingPosition;
  }

  @Override public void setSkillLevel(int newSkillLevel) {
    this.skillLevel = newSkillLevel;
  }


  @Override public int getSkillLevel() {
    return this.skillLevel;
  }

  @Override public String toString() {
    StringBuilder player = new StringBuilder();
    player.append("Name: ").append("\t\t\t\t").append(firstName)
        .append(" ").append(lastName).append("\n");
    player.append("Birthdate: ").append("\t\t").append(stringBirthdate).append("\n");
    player.append("Position: ").append("\t\t")
        .append(preferredPlayingPosition.toString()).append("\n");
    player.append("Skill level: ").append("\t").append(skillLevel);

    return player.toString();
  }

  /**
   * Converts birthdate string to LocalDate object type.
   *
   * @throws ParseException if given the wrong string date format.
   */
  private LocalDate getLocalDateOfBirth() throws ParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dateOfBirth = LocalDate.parse(this.stringBirthdate, formatter);
    return dateOfBirth;
  }

  /**
   * Check string birthdate for invalid format and for Player age range 5 to 10 inclusive.
   *
   * @param stringBirthdate the string birthdate of the player.
   * @throws ParseException if the string birthdate is an invalid format.
   * @throws IllegalArgumentException if birthdate is for player older than 10 or less than 5.
   * @throws NullPointerException if parameter passed is null.
   */
  private void checkBirthdate(String stringBirthdate)
      throws IllegalArgumentException, ParseException, NullPointerException {

    try {
      LocalDate dob = LocalDate.parse(stringBirthdate, DateTimeFormatter.ISO_LOCAL_DATE);
      LocalDate now = LocalDate.now();
      int age = Period.between(dob, now).getYears();
      if (age >= 10) {
        throw new IllegalArgumentException("Player must be below 10 years of age!");
      } else if (age <= 4) {
        throw new IllegalArgumentException("Player too young at below 5 years old!");
      }
    } catch (DateTimeParseException e) {
      throw new ParseException("Invalid date format. Expected yyyy-MM-dd", 0);
    } catch (NullPointerException e) {
      throw new NullPointerException("Date of birth cannot be null");
    }
  }

  /**
   * Check that this player's firstname and lastname are not null.
   *
   * @param firstName the player's firstname.
   * @param lastName the player's lastname.
   * @throws NullPointerException if the either the firstname or last name is null.
   */
  private void checkNames(String firstName, String lastName) throws NullPointerException {
    if (firstName == null) {
      throw new NullPointerException("Missing firstname!");
    } else if (lastName == null) {
      throw new NullPointerException("Missing lastname!");
    }
  }

  /**
   * Check that this player's preferred playing position is not null.
   *
   * @param preferredPlayingPosition the preferred playing position of this player.
   * @throws NullPointerException if the preferred playing position is null.
   */
  private void checkPreferredPlayingPosition(U10PlayingPositions preferredPlayingPosition)
      throws NullPointerException {

    if (preferredPlayingPosition == null) {
      throw new NullPointerException("Player must have a preferred playing position");
    } else if (!(preferredPlayingPosition instanceof U10PlayingPositions)) {
      throw new IllegalArgumentException("Please select a valid playing position");
    }
  }

  /**
   * Check that skill level for this player is not negative nor greater than 5.
   *
   * @param skillLevel the skill level of this player.
   * @throws IllegalArgumentException if the skill level is negative or above 5.
   */
  private void checkSkillLevel(int skillLevel) throws IllegalArgumentException,
      NumberFormatException {
    if (skillLevel < 0 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be set between 0 and 5 inclusive!");
    } else if (!((Integer) skillLevel instanceof Integer)) {
      throw new NumberFormatException("Invalid skill level: please enter a number");
    }
  }
}
