package teammanager;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * This is the GUI view of the U10Team Model implementation of the U10 Team Manager application.
 * It extends JFrame class and implements the U10TeamView interface.
 * This class displays the main operations available to create U10 Teams and Starting lineup.
 */
public class U10TeamViewImpl extends JFrame implements U10TeamView {
  private final JTextField firstNameTextField;
  private final JTextField lastNameTextField;
  private final JTextField birthdateTextField;
  private final JComboBox<String> preferredPlayingPositionComboBox;
  private final JTextField skillLevelTextField;
  private final JButton addPlayerButton;
  private final JButton createTeamButton;
  private final JButton getTeamPlayersButton;
  private final JButton getStartingLineupButton;
  private final JTextArea informationDisplayArea;
  private final JTextArea errorTextArea;

  /**
   * Constructs a new GUI display frame with associated JSwing components for management of
   * operations need to create U10 Team Players and Starting Lineup.
   * @param caption the title being passed to Super class JFrame.
   */
  public U10TeamViewImpl(String caption) {
    super(caption);

    // Set up the view
    setSize(1200, 600);
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Declares, add and activate border around the frame
    Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
    this.getRootPane().setBorder(padding);

    // Declares, add and activate labels and text fields for user input
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(5, 5, 5, 5); // add padding between elements

    // Declares, add and activate First upper horizontal grid position
    // Declares, add and activate first name JFrame component to Frame.
    c.gridx = 0;
    c.gridy = 0;
    this.add(new JLabel("First Name:"), c);

    c.gridx = 1;
    c.gridy = 0;
    c.gridwidth = 1;
    firstNameTextField = new JTextField(15);
    this.add(firstNameTextField, c);

    // Declares, add and activate last name JFrame component to Frame.
    c.gridx = 2;
    c.gridy = 0;
    this.add(new JLabel("Last Name:"), c);

    c.gridx = 3;
    c.gridy = 0;
    lastNameTextField = new JTextField(15);
    this.add(lastNameTextField, c);

    //Declares, add and activate birthdate JFrame component to Frame.
    c.gridx = 4;
    c.gridy = 0;
    this.add(new JLabel("Birthdate:"), c);

    c.gridx = 5;
    c.gridy = 0;
    birthdateTextField = new JTextField(15);
    this.add(birthdateTextField, c);

    // Next horizontal grid position below the First upper horizontal grid position.
    // Declares, add and activate Preferred Playing Position JFrame component to Frame.
    c.gridx = 0;
    c.gridy = 1;
    this.add(new JLabel("Preferred Position:"), c);

    c.gridx = 1;
    c.gridy = 1;
    c.gridwidth = 1;

    // Create the default value of the Preferred Playing Position JComboBox.
    String defaultValue = "Select a position";

    // Add the default value as the first element in the JComboBox for preferred playing position.
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    model.addElement(defaultValue);
    for (String position : U10PlayingPositions.getStringValues()) {
      model.addElement(position);
    }
    // Create the JComboBox with selected index at 0 for default user prompt.
    preferredPlayingPositionComboBox = new JComboBox<>(model);
    preferredPlayingPositionComboBox.setSelectedIndex(0);
    this.add(preferredPlayingPositionComboBox, c);

    // Declares, add and activate skill level JFrame component to Frame.
    c.gridx = 2;
    c.gridy = 1;
    this.add(new JLabel("Skill Level:"), c);

    c.gridx = 3;
    c.gridy = 1;
    skillLevelTextField = new JTextField(15);
    this.add(skillLevelTextField, c);

    // Declares, add and activate Add Player Button. JFrame component to Frame.
    c.gridx = 5;
    c.gridy = 1;
    c.gridwidth = 1;
    addPlayerButton = new JButton("Add Player");
    addPlayerButton.setActionCommand("Add Player");
    this.add(addPlayerButton, c);

    // Third horizontal grid position lower down.
    // Declares, add and activate error text area for communicating program error messages to user.
    c.gridx = 0;
    c.gridy = 3;
    c.gridwidth = 6;
    c.fill = GridBagConstraints.BOTH;

    errorTextArea = new JTextArea("");
    errorTextArea.setForeground(Color.RED);
    errorTextArea.setEditable(false);
    errorTextArea.setLineWrap(true);
    errorTextArea.setWrapStyleWord(true);
    errorTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    this.add(new JScrollPane(errorTextArea), c);

    // Fourth horizontal grid position lower down.
    // Declares, add and activate create team JButton component to Frame.
    c.gridx = 0;
    c.gridy = 4;
    c.gridwidth = 2;
    createTeamButton = new JButton("Create Team");
    createTeamButton.setActionCommand("Create Team");
    this.add(createTeamButton, c);
    createTeamButton.setEnabled(false);

    // Declares, add and activate get team players JButton component to Frame.
    c.gridx = 2;
    c.gridy = 4;
    c.gridwidth = 2;
    getTeamPlayersButton = new JButton("Get Team Players");
    getTeamPlayersButton.setActionCommand("Get Team Players");
    this.add(getTeamPlayersButton, c);
    getTeamPlayersButton.setEnabled(false);

    // Declares, add and activate get starting lineup JButton component to Frame.
    c.gridx = 4;
    c.gridy = 4;
    c.gridwidth = 2;
    getStartingLineupButton = new JButton("Get Starting Lineup");
    getStartingLineupButton.setActionCommand("Get Starting Lineup");
    this.add(getStartingLineupButton, c);
    getStartingLineupButton.setEnabled(false);

    // Fifth horizontal grid position lower down.
    // Declare, add and activate an output/display area to Frame.
    c.gridx = 0;
    c.gridy = 5;
    c.gridwidth = 6;
    informationDisplayArea = new JTextArea(30, 50);
    informationDisplayArea.setEditable(false);
    this.add(new JScrollPane(informationDisplayArea), c);


    pack();
    setVisible(true);
  }

  @Override
  public JTextField getFirstNameFromTextField() {
    return this.firstNameTextField;
  }

  @Override
  public JTextField getLastNameFromTextField() {
    return this.lastNameTextField;
  }

  @Override
  public JTextField getBirthdateFromTextField() {
    return this.birthdateTextField;
  }

  @Override
  public U10PlayingPositions getPreferredPlayingPositionFromComboBox() {
    return U10PlayingPositions.valueOf(preferredPlayingPositionComboBox
        .getSelectedItem().toString());
  }

  @Override
  public JTextField getSkillLevelFromTextField() {
    return this.skillLevelTextField;
  }

  @Override
  public void toInformationDisplayArea(String outputInformation) {
    this.informationDisplayArea.setText(outputInformation);
  }

  @Override
  public void toAnnouncementArea(String outputMessage) {
    errorTextArea.setForeground(Color.RED);
    errorTextArea.setText(outputMessage);
  }

  @Override
  public void enableCreateTeamButton() {
    createTeamButton.setEnabled(true);
  }

  @Override
  public void enableGetTeamPlayersButton() {
    getTeamPlayersButton.setEnabled(true);
  }

  @Override
  public void enableGetStartingLineupButton() {
    getStartingLineupButton.setEnabled(true);
  }

  @Override
  public void updatePlayerList(U10TeamController features) {
    try {
      this.addPlayerButton.addActionListener(
          evt -> features.addPlayer(getFirstNameFromTextField().getText(),
              getLastNameFromTextField().getText(), getBirthdateFromTextField().getText(),
              getPreferredPlayingPositionFromComboBox(),
              Integer.parseInt(getSkillLevelFromTextField().getText())));

      this.createTeamButton.addActionListener(evt -> features.buildRawPlayerList());
      this.getTeamPlayersButton.addActionListener(evt -> features.showTeamList());
      this.getStartingLineupButton.addActionListener(evt -> features.showStartingLineup());
    } catch (NumberFormatException err) {
      toAnnouncementArea(err.getMessage());
    } catch (IllegalArgumentException err) {
      toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      toAnnouncementArea(err.getMessage());
    }
  }

  @Override
  public void clearPlayerProfileTextFields() {
    this.firstNameTextField.setText("");
    this.lastNameTextField.setText("");
    this.birthdateTextField.setText("");
    this.preferredPlayingPositionComboBox.setSelectedIndex(-1);
    this.skillLevelTextField.setText("");
  }
}