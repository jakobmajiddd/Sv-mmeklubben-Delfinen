package staff;

import competition.Competition;
import competition.Discipline;
import main.UI;

import java.util.ArrayList;

/**
 * @author Martin
 */

public class Coach {
  UI ui = new UI();
  private String name;
  ArrayList<Competition> competitions = new ArrayList<>();

  public Coach(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


}
