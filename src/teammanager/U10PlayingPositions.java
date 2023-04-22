package teammanager;

/**
 * This class enumerates the playing positions available in an U10 soccer team.
 */
public enum U10PlayingPositions {
  GOALIE("GOALIE"),
  DEFENDER("DEFENDER"),
  MIDFIELDER("MIDFIELDER"),
  FORWARD("FORWARD");

  private final String playingPositions;

  /**
   * Constructs a String label "playingPositions" for playing soccer.
   *
   * @param display the String that will be displayed.
   */
  U10PlayingPositions(String display) {
    this.playingPositions = display;
  }

  @Override
  public String toString() {
    return this.playingPositions;
  }

  /**
   * Returns an array of all the string values of the enum.
   *
   * @return an array of all the string values of the enum.
   */
  public static String[] getStringValues() {
    U10PlayingPositions[] positions = values();
    String[] stringValues = new String[positions.length];
    for (int i = 0; i < positions.length; i++) {
      stringValues[i] = positions[i].playingPositions;
    }
    return stringValues;
  }

  /**
   * Returns the U10PlayingPositions enum value that corresponds to the given string.
   *
   * @param positionStr the string representation of the playing position.
   * @return the U10PlayingPositions enum value that corresponds to the given string.
   * @throws IllegalArgumentException if no matching enum value is found.
   */
  public static U10PlayingPositions fromString(String positionStr) {
    for (U10PlayingPositions position : U10PlayingPositions.values()) {
      if (position.playingPositions.equalsIgnoreCase(positionStr)) {
        return position;
      }
    }
    throw new IllegalArgumentException("Invalid playing position: " + positionStr);
  }
}
