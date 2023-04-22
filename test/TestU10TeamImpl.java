import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import teammanager.U10Player;
import teammanager.U10PlayerGenerator;
import teammanager.U10PlayerImpl;
import teammanager.U10PlayingPositions;
import teammanager.U10Team;
import teammanager.U10TeamImpl;

/**
 * Test class for U10 Team in the British Columbia Soccer Club.
 */
public class TestU10TeamImpl {

//  /**
//   * Tests invalid team size with player size of nine.
//   *
//   * @throws ParseException if the string birthdate is of invalid format.
//   */
//  @Test (expected = IllegalStateException.class)
//  public void testInvalidTeamSize() throws ParseException {
//    U10PlayerGenerator newPlayerList = new U10PlayerGenerator();
//    ArrayList<U10Player> ninePlayerList = newPlayerList.getNinePlayersOnList();
//    U10TeamImpl team = new U10TeamImpl(ninePlayerList);
//  }
//
//  /**
//   * Tests invalid team list input as null.
//   *
//   * @throws ParseException if the string birthdate is of invalid format.
//   */
//  @Test (expected = NullPointerException.class)
//  public void testConstructorWithNullPlayers() throws ParseException {
//    ArrayList<U10Player> thirtyThreePlayerList = null;
//    U10Team newTeamList = new U10TeamImpl(thirtyThreePlayerList);
//  }
//
//  /**
//   * Tests invalid empty team list as input.
//   *
//   * @throws ParseException if the string birthdate is of invalid format.
//   */
//  @Test (expected = IllegalStateException.class)
//  public void testConstructorWithEmptyPlayers() throws ParseException {
//    U10PlayerGenerator newPlayerList = new U10PlayerGenerator();
//    ArrayList<U10Player> ninePlayerList = newPlayerList.getNinePlayersOnList();
//    ninePlayerList.clear();
//    U10Team newTeamList = new U10TeamImpl(ninePlayerList);
//  }
//
//  /**
//   * Tests team list generation with eleven players as input.
//   *
//   * @throws ParseException if the string birthdate is of invalid format.
//   */
//  @Test
//  public void testTeamCreationWithElevenPlayersInTeamList() throws ParseException {
//    U10PlayerGenerator newPlayerList = new U10PlayerGenerator();
//    ArrayList<U10Player> elevenPlayerList = newPlayerList.getElevenPlayersOnList();
//    U10Team newTeamList = new U10TeamImpl(elevenPlayerList);
//
//    assertEquals(11, newTeamList.getTeam().size());
//
//  }
//
//  /**
//   * Tests team list generation with eleven players as input.
//   *
//   * @throws ParseException if the string birthdate is of invalid format.
//   */
//  @Test
//  public void testConstructorWithPreciselyTenPlayersInTeamList() throws ParseException {
//    U10PlayerGenerator newPlayerList = new U10PlayerGenerator();
//    ArrayList<U10Player> elevenPlayerList = newPlayerList.getElevenPlayersOnList();
//    U10Team newTeamList = new U10TeamImpl(elevenPlayerList);
//
//    assertEquals(10, newTeamList.getTeam().size());
//  }
}