package teammanager;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * This class represents a Controller that implements U10TeamModel.
 */
public class U10TeamControllerImpl implements U10TeamController {
  private final U10Team model;
  private U10TeamView view;

  /**
   * Constructs a controller object which takes input from any source and output to any defined
   *              output destination.
   * @param model the Model to the Controller.
   */
  public U10TeamControllerImpl(U10Team model) {
    try {
      Objects.requireNonNull(model);
      if (!(model instanceof U10Team)) {
        throw new IllegalArgumentException();
      }
    } catch (NullPointerException err) {
      throw new NullPointerException("Invalid operation! Null Model unacceptable!");
    } catch (IllegalArgumentException err) {
      throw new IllegalArgumentException("Wrong U10Team object!");
    }
    this.model = model;
  }

  @Override
  public void setView(U10TeamView newView) {
    this.view = newView;
    this.view.updatePlayerList(this);
  }

  @Override public void addPlayer(String firstName, String lastName, String birthdate,
      U10PlayingPositions newPosition, int skillLevel) {

    try {
      this.model.addPlayersToList(firstName, lastName, birthdate, newPosition, skillLevel);
      this.view.toAnnouncementArea("Player successfully added!" + " You now have "
          + (model.countPlayersOnRawList()) + " Players. You can add more players "
          + "or create final team.");

      if (this.model.countPlayersOnRawList() < 10) {
        this.view.toAnnouncementArea("Player successfully added! " + " You need at LEAST "
            + (10 - (model.countPlayersOnRawList())
            + " more players before you can create a team"));
      } else {
        this.view.enableCreateTeamButton();

      }
      // Reset input fields for new profile data intake.
      this.view.clearPlayerProfileTextFields();

    } catch (ParseException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NumberFormatException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalArgumentException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      this.view.toAnnouncementArea(err.getMessage());
    }
  }

  @Override public void buildRawPlayerList() {
    try {
      // Finalizes raw team list for team creation.
      this.model.isfinalPlayerList();
      this.view.enableGetTeamPlayersButton();
      this.view.enableGetStartingLineupButton();
    } catch (IllegalArgumentException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (ParseException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      this.view.toAnnouncementArea(err.getMessage());
    }
  }

  @Override public void showTeamList() {
    try {
      this.view.toInformationDisplayArea(this.model.printPlayersOnTeam());
    } catch (IllegalArgumentException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (ParseException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      this.view.toAnnouncementArea(err.getMessage());
    }
  }

  @Override public void showStartingLineup() {
    try {
      this.view.toInformationDisplayArea(this.model.printPlayersOnStartingLineup().toString());
    } catch (IllegalArgumentException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (ParseException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      this.view.toAnnouncementArea(err.getMessage());
    }
  }

  @Override public void showBenchers() {
    try {
      this.model.getStartingLineup();
      this.model.printBenchers();
    } catch (IllegalArgumentException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (ParseException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (IllegalStateException err) {
      this.view.toAnnouncementArea(err.getMessage());
    } catch (NullPointerException err) {
      this.view.toAnnouncementArea(err.getMessage());
    }
  }
}
