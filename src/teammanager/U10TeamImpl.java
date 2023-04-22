package teammanager;

import java.sql.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents the Team (Model) of a Soccer Team of size between 10 and 20 players.
 */
public class U10TeamImpl implements U10Team {
  // Team of Players here have no Jersey Numbers nor official playing positions assigned.
  // Just a general list of all available players for Team formation.
  private ArrayList<U10Player> teamPlayers;
  private U10PlayingPositions officialPlayingPosition;
  private boolean isTeamFinalized;


  /**
   * Constructs an under 10 soccer Team size comprising between 10 and 20 players.
   * It initializes to a team list of players.
   */
  public U10TeamImpl() throws
      IllegalArgumentException, ParseException, IllegalStateException, NullPointerException {
    this.isTeamFinalized = false;
    this.teamPlayers = new ArrayList<U10Player>();
    this.officialPlayingPosition = officialPlayingPosition;
  }

  // Return an alphabetically sorted list by (lastname) first name, last name, and jersey number.
  @Override public ArrayList<U10Player> getTeam() throws IllegalArgumentException, ParseException,
      IllegalStateException, NullPointerException, UnsupportedOperationException {
    int maxTeamSize = 20;
    int availablePlayers = this.teamPlayers.size() < maxTeamSize
        ? this.teamPlayers.size() : maxTeamSize;;
    ArrayList<U10Player> teamPlayersList = new ArrayList<U10Player>();

    // Updates teamPlayerList with 20 players all with jersey numbers already assigned.
    for (int i = 0; i < availablePlayers; i++) {
      teamPlayersList.add(this.teamPlayers.get(i));
    }
    try {
      // Sort the teamPlayersList by last name
      Collections.sort(teamPlayersList, new Comparator<U10Player>() {
        public int compare(U10Player player1, U10Player player2) {
          return player1.getLastName().compareTo(player2.getLastName());
        }
      });
    } catch (UnsupportedOperationException e) {
      throw new UnsupportedOperationException("Operation not supported");
    }
    return teamPlayersList;
  }

  @Override
  public ArrayList<U10Player> getStartingLineup()
      throws ParseException {
    int startingLineupSize = 7;

    // Assign playing positions to starting lineup players
    ArrayList<U10Player> startingLineup = getTeam();
    startingLineup = new ArrayList<>(startingLineup.subList(0, startingLineupSize));

    assignOfficialPlayingPositions(startingLineup);

    Collections.sort(startingLineup, new Comparator<U10Player>() {
      public int compare(U10Player player1, U10Player player2) {
        int pos1 = player1.getOfficialPlayingPosition().ordinal();
        int pos2 = player2.getOfficialPlayingPosition().ordinal();
        if (pos1 != pos2) {
          return Integer.compare(pos1, pos2);
        } else {
          return player1.getLastName().compareTo(player2.getLastName());
        }
      }
    });
    return startingLineup;
  }

  @Override public ArrayList<U10Player> getBenchers() throws
      IllegalArgumentException, ParseException, IllegalStateException, NullPointerException {
    int flagTotalPlayersOnStartingLineup = 7;
    int flagTotalPlayersOnTeam = 20;
    ArrayList<U10Player> benchers = new ArrayList<U10Player>();

    // Updates benchers list with players who did not make the starting lineup.
    for (int i = flagTotalPlayersOnStartingLineup + 1; i <= flagTotalPlayersOnTeam; i++) {
      benchers.add(this.teamPlayers.get(i));
    }

    return benchers;
  }

  @Override public int countPlayersOnRawList() {
    return this.teamPlayers.size();
  }

  @Override public int countPlayersOnTeam() throws ParseException {
    ArrayList<U10Player> countPlayersOnTeam = getTeam();
    return countPlayersOnTeam.size();
  }

  @Override public int countPlayersOnStartingLineup() throws ParseException {
    ArrayList<U10Player> countPlayersOnStartingLineup = getStartingLineup();
    return countPlayersOnStartingLineup.size();
  }

  @Override public int countBenchers() throws ParseException {
    ArrayList<U10Player> countBenchers = getBenchers();
    return countBenchers.size();
  }

  @Override
  public String printPlayersOnTeam() throws ParseException {
    ArrayList<U10Player> playersInTeamList = getTeam();
    StringBuilder sb = new StringBuilder();
    sb.append("Players on Team:\n");
    for (U10Player player : playersInTeamList) {
      sb.append(player.getFirstName()).append(" ")
          .append(player.getLastName()).append(", ")
          .append("Jersey Number: ").append(player.getJerseyNumber()).append("\n");
    }
    return sb.toString();
  }

  @Override
  public String printPlayersOnStartingLineup() throws ParseException {
    ArrayList<U10Player> startingLineup = getStartingLineup();
    StringBuilder sb = new StringBuilder();
    sb.append("Players on Starting Lineup:\n");
    for (U10Player player : startingLineup) {
      sb.append(player.getFirstName()).append(" ")
          .append(player.getLastName()).append(", ")
          .append("Jersey Number: ").append(player.getJerseyNumber()).append(", ")
          .append("Position: ").append(player.getOfficialPlayingPosition()).append("\n");
    }
    return sb.toString();
  }

  @Override
  public String printBenchers() throws ParseException {
    ArrayList<U10Player> benchers = getBenchers();
    StringBuilder sb = new StringBuilder();
    sb.append("Players on Bench:\n");
    for (U10Player player : benchers) {
      sb.append(player.getFirstName()).append(" ")
          .append(player.getLastName()).append(", ")
          .append(player.getBirthdate()).append(", ")
          .append(player.getPreferredPlayingPosition()).append(", ")
          .append("Skill Level: ").append(player.getSkillLevel()).append("\n");
    }
    return sb.toString();
  }

  @Override
  public void isfinalPlayerList()
      throws IllegalArgumentException, ParseException, IllegalStateException, NullPointerException {

    checkIfPlayerListIsNull(this.teamPlayers);
    checkIfPlayerListIsEmpty(this.teamPlayers);

    if (checkIfPlayerListIsAboveMinimum(this.teamPlayers)) {
      sortList(this.teamPlayers);

      // Then adds jersey numbers to the first 20 players.
      addGeneratedJerseyNumbers();
      this.isTeamFinalized = true;
    }
  }

  @Override
  public void addPlayersToList(String firstName, String lastName, String birthdate,
      U10PlayingPositions newPosition, int skillLevel)
      throws IllegalArgumentException, ParseException, IllegalStateException, NullPointerException {
    if (!this.isTeamFinalized) {
      U10Player newPlayer = new U10PlayerImpl(firstName, lastName, birthdate, newPosition,
          skillLevel);
      this.teamPlayers.add(newPlayer);
    }
  }

  /**
   * Helper method for constructor.
   * Sorts the field list of players (this.teamPlayers) by skill level descending.
   *
   * @param players list of players passed at constructor.
   */
  private static void sortList(ArrayList<U10Player> players) {
    Collections.sort(players, new Comparator<U10Player>() {
      @Override // Overriding the compare to method of the annoymous Comparator object.
      public int compare(U10Player player1, U10Player player2) {
        // Sort in descending order of skill level
        return Integer.compare(player2.getSkillLevel(), player1.getSkillLevel());
      }
    });
  }

  /**
   * Helper method to constructor.
   * Check if list of players passed to constructor is null.
   *
   * @param playersList the list of players to be processed.
   * @throws ParseException if the string birthdate is of invalid format.
   * @throws NullPointerException if any parameter passed is null.
   */
  private void checkIfPlayerListIsNull(List<U10Player> playersList)
      throws ParseException, NullPointerException {
    if (playersList == null) {
      throw new NullPointerException("Provide a valid player list. Error, null passed!");
    }
  }

  /**
   * Helper method to constructor.
   * Checks that the list at constructor is not null.
   *
   * @param playersList the list of players to be processed.
   * @throws IllegalStateException if player list passed is empty.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  private void checkIfPlayerListIsEmpty(List<U10Player> playersList)
      throws IllegalStateException, ParseException {
    if (playersList.isEmpty()) {
      throw new IllegalStateException("Team players list is empty!");
    }
  }

  /**
   * Helper method to constructor.
   * Checks that original player list is does not contain less than 10 players.
   *
   * @param playersList the list of players to be processed.
   * @return boolean true if player list is above minimum, false otherwise.
   * @throws IllegalStateException if player list passed has less than 10 players.
   * @throws ParseException if the string birthdate is of invalid format.
   */
  public boolean checkIfPlayerListIsAboveMinimum(List<U10Player> playersList)
      throws IllegalStateException, ParseException {
    int minTeamSize = 10;
    if (playersList.size() >= minTeamSize) {
      return true;
    } else {
      throw new IllegalStateException("You need more players to form a Team! "
          + "You currently have: " + this.teamPlayers.size() + "Players");
    }
  }

  /**
   * Helper method to getPlayersOnTeam().
   * Assigns randomly generated but unique jersey numbers to players through call to
   *    getRandomJerseyNumber().
   */
  private void addGeneratedJerseyNumbers() throws ParseException {
    int maxTeamSize = 20;

    // Tenary operator allows maxJerseyAssignable to evaluate based on if
    // this.teamPlayers.size() < maxTeamSize is true or false.  If true, maxJerseyAssignbale
    // evaluates to this.teamPlayers.size(), if false, it evaluates to maxTeamSize.
    int maxJerseysAssignable = this.teamPlayers.size() < maxTeamSize
        ? this.teamPlayers.size() : maxTeamSize;

    List<Integer> assignedJerseyNumbers = new ArrayList<Integer>();

    for (int i = 0; i < maxJerseysAssignable; i++) {
      int jerseyNumber = getRandomJerseyNumber(assignedJerseyNumbers);

      assignedJerseyNumbers.add(jerseyNumber);
      this.teamPlayers.get(i).setJerseyNumber(jerseyNumber);
    }
  }

  /**
   * Helper method to getPlayersOnTeam() through addGeneratedJerseyNumbers().
   * Aids to generate unique jersey numbers.
   *
   * @param assignedJerseyNumbers list of already assigned jersey number used to confirm
   *                              number that has been allocated in order to prevent
   *                              non-unique assignment of jersey numbers to players.
   * @return the jersery number of players.
   */
  private int getRandomJerseyNumber(List<Integer> assignedJerseyNumbers) {

    int maxJerseyNumber = 20;
    int minJerseyNumber = 1;

    // Generate a list of all possible jersey numbers between 1 and 20 inclusive
    List<Integer> allJerseyNumbers = new ArrayList<Integer>();
    for (int i = minJerseyNumber; i <= maxJerseyNumber; i++) {
      allJerseyNumbers.add(i);
    }

    // Remove all used jersey numbers from the list of possible jersey numbers
    allJerseyNumbers.removeAll(assignedJerseyNumbers);

    // If all jersey numbers have been used, throw an exception
    if (allJerseyNumbers.isEmpty()) {
      throw new IllegalStateException("All jersey numbers have been assigned.");
    }

    // Generate a random index and return the corresponding jersey number
    int randomIndex = (int) (Math.random() * allJerseyNumbers.size());
    int randomJerseyNumber = allJerseyNumbers.get(randomIndex);

    return randomJerseyNumber;
  }

  /**
   * Helper method to getPlayersOnStartingLineup().
   * Assign official playing positions to players who made the starting lineup.
   *
   * @param startingLineup the list of starting lineup.
   */
  private void assignOfficialPlayingPositions(ArrayList<U10Player> startingLineup) {
    // Sort players by skill level in descending order.
    startingLineup.sort(Comparator.comparingInt(U10Player::getSkillLevel).reversed());

    // Map holds playing positions (keys) and number of players assigned to the position (value).
    Map<U10PlayingPositions, Integer> assignedPositions = new HashMap<>();
    assignedPositions.put(U10PlayingPositions.GOALIE, 0);
    assignedPositions.put(U10PlayingPositions.DEFENDER, 0);
    assignedPositions.put(U10PlayingPositions.MIDFIELDER, 0);
    assignedPositions.put(U10PlayingPositions.FORWARD, 0);

    // All Skill level 5 players get their preferred playing positions
    // as their official playing positions based on availability of the position.
    for (U10Player player : startingLineup) {
      if (player.getSkillLevel() == 5) {
        U10PlayingPositions preferredPlayingPosition = player.getPreferredPlayingPosition();
        if (preferredPlayingPosition != null && assignedPositions.get(preferredPlayingPosition)
            < getMaximumPlayersPerPosition(preferredPlayingPosition)) {
          assignPosition(player, preferredPlayingPosition, assignedPositions);
        }
      }
    }

    // All skill level 4 to 1 players get randomly assigned official playing positions
    // to replace their preferred playing positions based on availability of positions.
    for (int i = 0; i < startingLineup.size(); i++) {
      U10Player player = startingLineup.get(i);
      U10PlayingPositions preferredPosition = player.getPreferredPlayingPosition();
      if (player.getOfficialPlayingPosition() != null) {
        continue;
      } else if ((preferredPosition != null) && ((assignedPositions.get(preferredPosition)
          < getMaximumPlayersPerPosition(preferredPosition)))) {
        assignPosition(player, preferredPosition, assignedPositions);
      } else {
        U10PlayingPositions randomPosition = getRandomPosition(player, assignedPositions);
        assignPosition(player, randomPosition, assignedPositions);
      }
    }
  }

  /**
   * Helper method to getPlayersOnStartingLineup() through assignOfficialPlayingPositions().
   * Helps assign player's alloted position to official playing positions.
   *
   * @param player the player to be assigned a playing position.
   * @param position the playing position to be assigned to players on starting lineup.
   * @param assignedPositions a Map to track already assigned positions.
   */
  private void assignPosition(U10Player player, U10PlayingPositions position,
      Map<U10PlayingPositions, Integer> assignedPositions) {

    // Set position passed to official playing position.
    player.setOfficialPlayingPosition(position);

    // Updates number of players already assigned.
    assignedPositions.put(position, assignedPositions.get(position) + 1);
  }

  /**
   * Helper method to getPlayersOnStartingLineup() through assignOfficialPlayingPositions().
   * Randomly assigns official playing positions to players with skill level 4 and below.
   *
   * @param player the player to be assigned a playing position.
   * @param assignedPositions a Map to track already assigned positions.
   */
  private U10PlayingPositions getRandomPosition(U10Player player,
      Map<U10PlayingPositions, Integer> assignedPositions) {

    List<U10PlayingPositions> availablePositions = new ArrayList<>();
    for (U10PlayingPositions position : U10PlayingPositions.values()) {
      if (assignedPositions.get(position) < getMaximumPlayersPerPosition(position)) {
        availablePositions.add(position);
      }
    }

    int randomIndex = (int) (Math.random() * availablePositions.size());
    return availablePositions.get(randomIndex);
  }

  /**
   * Helper method to getPlayersOnStartingLineup() through
   *    assignOfficialPlayingPositions() and getRandomPosition().
   *
   * Keeps track of the total number of playing positions available per position.
   *
   * @param position the position to be assigned.
   */
  private int getMaximumPlayersPerPosition(U10PlayingPositions position) {
    switch (position) {
      case GOALIE:
        return 1;
      case DEFENDER:
        return 2;
      case MIDFIELDER:
        return 3;
      case FORWARD:
        return 1;
      default:
        return 0;
    }
  }
}