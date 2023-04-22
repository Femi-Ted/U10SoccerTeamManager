package teammanager;

import javax.swing.JTextField;

/**
 * Represents the View in the MVC implementation of U10TeamManager.
 * It takes input from users and passes it to the Controller
 */
public interface U10TeamView {

  /**
   * Get the firstName user input from the JTextField.
   *
   * @return the firstname text input in the JTextField.
   */
  JTextField getFirstNameFromTextField();

  /**
   * Get the lastName user input from the JTextField.
   *
   * @return the lastname text input in the JTextField.
   */
  JTextField getLastNameFromTextField();

  /**
   * Get the birthdate user input from the JTextField.
   *
   * @return the birthdate text input in the JTextField.
   */
  JTextField getBirthdateFromTextField();

  /**
   * Get the preferred playing position user selection from the JComboBox.
   *
   * @return the chosen preferred playing position selection in the JComboBox.
   */
  U10PlayingPositions getPreferredPlayingPositionFromComboBox();

  /**
   * Get the skill level user input from the JTextField.
   *
   * @return the skill level text input in the JTextField.
   */
  JTextField getSkillLevelFromTextField();

  /**
   * Helps to push caught errors and program messages to user on the GUI.
   *
   * @param outputMessage the error or program message.
   */
  void toAnnouncementArea(String outputMessage);

  /**
   * Helps to push processed information to the informationDisplayArea of the GUI.
   *
   * @param outputInformation the information to be displayed.
   */
  void toInformationDisplayArea(String outputInformation);

  /**
   * Enables createTeamButton which at default is disabled.
   */
  void enableCreateTeamButton();

  /**
   * Enables getTeamPlayersButton which at default is disabled.
   */
  void enableGetTeamPlayersButton();

  /**
   * Enables getStartinglineupButton which at default is disabled.
   */
  void enableGetStartingLineupButton();

  /**
   * Clears previously added player details in readiness for new data in text fields.
   */
  void clearPlayerProfileTextFields();

  /**
   * Activates GUI buttons and through ActionListeners attaches them to
   * their respective method calls.
   *
   * @param features a representation of all features available in the Controller.
   */
  void updatePlayerList(U10TeamController features);
}
