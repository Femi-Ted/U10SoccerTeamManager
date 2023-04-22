import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import org.junit.Test;
import teammanager.U10PlayerGenerator;

/**
 * Test the U10Players were created and added to team list.
 */
public class TestU10PlayerGenerator {

  U10PlayerGenerator thirtyThreePlayerList;

  /**
   * Test that list of players contain thirty-three valid players.
   *
   * @throws ParseException if invalid string birthdate input.
   */
  @Test public void testThirtyThreePlayersOnList() throws ParseException {
    thirtyThreePlayerList = new U10PlayerGenerator();
    assertEquals(33, thirtyThreePlayerList.getThirtyThreePlayersOnList().size());
  }


  /**
   * Test that list of players contain eleven valid players.
   *
   * @throws ParseException if invalid string birthdate input.
   */
  @Test public void testElevenPlayersOnList() throws ParseException {
    thirtyThreePlayerList = new U10PlayerGenerator();
    assertEquals(11, thirtyThreePlayerList.getElevenPlayersOnList().size());
  }

  /**
   * Test that list of players contain nine valid players.
   *
   * @throws ParseException if invalid string birthdate input.
   */
  @Test public void testNinePlayersOnList() throws ParseException {
    thirtyThreePlayerList = new U10PlayerGenerator();
    assertEquals(9, thirtyThreePlayerList.getNinePlayersOnList().size());
  }

  /**
   * Test that list of players contain one valid players.
   *
   * @throws ParseException if invalid string birthdate input.
   */
  @Test public void testOnePlayersOnList() throws ParseException {
    thirtyThreePlayerList = new U10PlayerGenerator();
    assertEquals(1, thirtyThreePlayerList.getOnePlayerOnList().size());
  }
}
