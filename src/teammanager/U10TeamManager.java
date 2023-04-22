package teammanager;

import java.text.ParseException;

/**
 * This class is the driver class to the MVC implementation of an U10TeamManager Application.
 * This driver passes the Model and View of the implementation to the Controller and run.
 */
public class U10TeamManager {

  /**
   * Runs the team manager application by instantiating the required objects.
   *
   * @param args arguments for the funcition (none needed).
   * @throws ParseException if the string birthdate is of invalid format.
   */
  public static void main(String[] args) throws ParseException {
    U10Team newTeamModel = new U10TeamImpl();
    U10TeamController newTeamController = new U10TeamControllerImpl(newTeamModel);
    U10TeamView newTeamView = new U10TeamViewImpl("The British Columbia U10 Soccer Club");
    newTeamController.setView(newTeamView);
  }
}