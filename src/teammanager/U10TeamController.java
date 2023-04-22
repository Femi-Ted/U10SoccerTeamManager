package teammanager;

import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Represents a Controller for U10Team selector: handles player addition and team
 * generation using U10TeamImpl Model. And converys player/team related information to
 * user.
 */
public interface U10TeamController {

  /**
   * Helps Controller take player profile inputs from the view and passing it to the Model.
   *
   * @param firstName the first name of the player to be added.
   * @param lastName the last name of the player to be added.
   * @param birthdate the birthdate of the player to be added.
   * @param newPosition the preferred playing position of the player to be added.
   * @param skillLevel the skill level of the player to be added.
   */
  void addPlayer(String firstName, String lastName, String birthdate,
      U10PlayingPositions newPosition, int skillLevel);

  /**
   * Helps Controller asks the Model to build the unprocessed list of players and make it firm for
   * team creation.
   */
  void buildRawPlayerList();

  /**
   * Helps Controller ask Model to forward the list of Team Players and passes this to the View.
   */
  void showTeamList();

  /**
   * Helps Controller ask Model to forward the list of Starting Lineup and passes this to the View.
   */
  void showStartingLineup();

  /**
   * Helps Controller ask Model to forward the list of Benchers and passes this to the View.
   */
  void showBenchers();

  /**
   * Provide view with all the callbacks so Controller can couple with the View.
   *
   * @param newView the view.
   */
  void setView(U10TeamView newView);
}
