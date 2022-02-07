package shopping;

import java.time.LocalDate;

public class UseAPair {
  public static void main(String[] args) {
    Pair<String> ps = new Pair<>("Fred", "Jones" /*LocalDate.now()*/);

//    ps.setRight(99);
    String l = ps.getLeft();
  }
}
