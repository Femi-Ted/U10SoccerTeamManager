import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;
import teammanager.U10Player;
import teammanager.U10PlayerImpl;
import teammanager.U10PlayingPositions;


/**
 * Test Class for U10 Player in the British Columbia Soccer Club.
 */
public class TestPlayerImpl {
  U10Player playerTracy;
  U10Player playerYemisi;
  U10Player playerKemi;
  U10Player playerCece;

  /**
   * Player object setup for player test operations.
   * @throws ParseException if invalid string birthdate input.
   */
  @Before public void setUp() throws ParseException {
    playerTracy = new U10PlayerImpl("Tracy", "Jones", "2015-12-31",
        U10PlayingPositions.FORWARD, 3);
    playerYemisi = new U10PlayerImpl("Yemisi", "Adams", "2014-11-05",
        U10PlayingPositions.GOALIE, 4);
    playerKemi = new U10PlayerImpl("Kemi", "Akindele", "2013-06-15",
        U10PlayingPositions.DEFENDER, 5);
    playerCece = new U10PlayerImpl("Cece", "Swallows", "2013-01-01",
        U10PlayingPositions.MIDFIELDER, 1);
  }

  /**
   * Test Player object with invalid date of birth format.
   */
  @Test (expected = ParseException.class)
  public void testPlayerOneInvalidDateOfBirth() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", "Jones", "12-31-2015",
      U10PlayingPositions.FORWARD, 5);
  }


  /**
   * Test to check when player is older than ten years old.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerOlderThanTen() throws ParseException {
    playerKemi = new U10PlayerImpl("Tracy", "Jones", "2000-12-31",
       U10PlayingPositions.FORWARD, 5);
  }

  /**
   * Test to check when player is younger than five years old.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerYoungerThanFiveYearsOld() throws ParseException {
    playerKemi = new U10PlayerImpl("Tracy", "Jones", "2021-12-31",
        U10PlayingPositions.FORWARD, 5);
  }

  /**
   * Test Player first name is not null value.
   */
  @Test (expected = NullPointerException.class)
  public void testNonNullPlayerFirstName() throws ParseException {
    playerYemisi = new U10PlayerImpl(null, "Jones", "2015-12-31",
        U10PlayingPositions.FORWARD, 5);
  }

  /**
   * Test Player last name is not null value.
   */
  @Test (expected = NullPointerException.class)
  public void testNonNullPlayerLastName() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", null, "2015-12-31",
        U10PlayingPositions.FORWARD, 5);
  }

  /**
   * Test Player birthdate is not null value.
   */
  @Test (expected = NullPointerException.class)
  public void testNonNullPlayerBirthDate() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", "Jones", null,
        U10PlayingPositions.FORWARD, 5);
  }


  /**
   * Test Player playing position is not null value.
   */
  @Test (expected = NullPointerException.class)
  public void testNonNullPlayerPlayingPosition() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", "Jones", "2015-12-31",
        null, 5);
  }

  /**
   * Test Player object with negative Skill.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNonNegativePlayerSkillLevel() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", "Jones", "2015-12-31",
        U10PlayingPositions.FORWARD, -1);
  }

  /**
   * Test Player object with Skill value above 5.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerWithInvalidSkillLevelAboveFive() throws ParseException {
    playerYemisi = new U10PlayerImpl("Tracy", "Jones", "2015-12-31",
        U10PlayingPositions.FORWARD, 6);
  }

  /**
   * Test Player objects firstnames.
   */
  @Test
  public void testPlayerFirstNames() throws ParseException {
    assertEquals("Tracy", playerTracy.getFirstName());
    assertEquals("Yemisi", playerYemisi.getFirstName());
    assertEquals("Kemi", playerKemi.getFirstName());
    assertEquals("Cece", playerCece.getFirstName());
  }

  /**
   * Test Player objects lastnames.
   */
  @Test
  public void testPlayerLastNames() throws ParseException {
    assertEquals("Jones", playerTracy.getLastName());
    assertEquals("Adams", playerYemisi.getLastName());
    assertEquals("Akindele", playerKemi.getLastName());
    assertEquals("Swallows", playerCece.getLastName());
  }

  /**
   * Test Player's age at Seven.
   */
  @Test
  public void testPlayerAgeAtSeven() throws ParseException {
    assertEquals(7, playerTracy.getAge());
  }

  /**
   * Test Player's age at Eight.
   */
  @Test
  public void testPlayerAgeAtEight() throws ParseException {
    assertEquals(8, playerYemisi.getAge());
  }

  /**
   * Test Player's age at Nine.
   */
  @Test
  public void testPlayerAgeAtNine() throws ParseException {
    assertEquals(9, playerKemi.getAge());
  }

  /**
   * Test Player's age at Ten.
   */
  @Test
  public void testPlayerAges() throws ParseException {
    assertEquals(10, playerCece.getAge());
  }

  /**
   * Test invalid U10 age for player - (Age at 11).
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidPlayerAgeAtEleven() throws ParseException {
    playerTracy = new U10PlayerImpl("Tracy", "Jones", "2011-12-31",
        U10PlayingPositions.FORWARD, 3);
    assertEquals(11, playerTracy.getAge());
  }

  /**
   * Test invalid U10 age for player - (Age at 5).
   * Players will not comprise of kids under 5 years old.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidPlayerAgeAtFour() throws ParseException {
    playerTracy = new U10PlayerImpl("Tracy", "Jones", "2019-03-15",
        U10PlayingPositions.FORWARD, 3);
    assertEquals(4, playerTracy.getAge());
  }

  /**
   * Test Player's preferred playing positions - Forward.
   */
  @Test
  public void testPlayerPreferredPositionForward() throws ParseException {
    assertEquals(U10PlayingPositions.FORWARD, playerTracy.getPreferredPlayingPosition());
    ;
  }

  /**
   * Test Player's preferred playing positions - Goalie.
   */
  @Test
  public void testPlayerPreferredPositionGoalie() throws ParseException {
    assertEquals(U10PlayingPositions.GOALIE, playerYemisi.getPreferredPlayingPosition());
  }

  /**
   * Test Player's preferred playing positions - Defender.
   */
  @Test
  public void testPlayerPreferredPositionDefender() throws ParseException {
    assertEquals(U10PlayingPositions.DEFENDER, playerKemi.getPreferredPlayingPosition());
  }

  /**
   * Test Player's preferred playing positions - Midfielder.
   */
  @Test
  public void testPlayerPreferredPositionMidFielder() throws ParseException {
    assertEquals(U10PlayingPositions.MIDFIELDER, playerCece.getPreferredPlayingPosition());
  }

  /**
   * Test Player's skill level.
   */
  @Test
  public void testPlayerPreferredPosition() throws ParseException {
    assertEquals(3, playerTracy.getSkillLevel());
    assertEquals(4, playerYemisi.getSkillLevel());
    assertEquals(5, playerKemi.getSkillLevel());
    assertEquals(1, playerCece.getSkillLevel());
  }

  /**
   * Test Player's Birthdates.
   */
  @Test
  public void testPlayerBirthdates() throws ParseException {
    assertEquals("2015-12-31", playerTracy.getBirthdate());
    assertEquals("2014-11-05", playerYemisi.getBirthdate());
    assertEquals("2013-06-15", playerKemi.getBirthdate());
    assertEquals("2013-01-01", playerCece.getBirthdate());
  }

  /**
   * Locally test setJerseyNumber() and getJerseyNumber() on created player.
   */
  @Test
  public void testSetJerseyNumberAndGetJerseyNumberMethodsOnPlayer() throws ParseException {
    playerTracy.setJerseyNumber(2);
    assertEquals(2, playerTracy.getJerseyNumber());
  }

  /**
   * Locally test setOfficialPlayingPosition() and getOfficialPlayingPosition() on created player.
   */
  @Test
  public void testSetOfficialPlayingPositionAndGetOfficialPlayingPosition() throws ParseException {
    playerYemisi.setOfficialPlayingPosition(U10PlayingPositions.GOALIE);
    assertEquals("GOALIE", playerYemisi.getOfficialPlayingPosition().toString());
  }

  /**
   * Locally test setSkillLevel() and getSkillLevel() on created player.
   */
  @Test
  public void testSetSkillLevelAndGetSkillLevelOnPlayer() throws ParseException {
    playerYemisi.setSkillLevel(5);
    assertEquals(5, playerYemisi.getSkillLevel());
  }

  /**
   * Locally test IllegalStateException thrown when jersey number reassignment occurs.
   * is
   */
  @Test (expected = IllegalStateException.class)
  public void testInvalidReassignmentOfJerseyNumber() throws ParseException {
    playerTracy.setJerseyNumber(2);
    playerTracy.setJerseyNumber(12);
  }

  /**
   * Test String representation of players.
   */
  @Test
  public void testToString() {
    assertEquals(
        "Name: \t\t\t\tTracy Jones\n"
            + "Birthdate: \t\t2015-12-31\n"
            + "Position: \t\tFORWARD\n"
            + "Skill level: \t3", playerTracy.toString());
  }
}


