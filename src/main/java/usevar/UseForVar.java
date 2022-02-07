package usevar;

public class UseForVar {
  public static void main(String[] args) {
    int x = 99;
    String y = "Hello";
    boolean b = Math.random() > 0.5;

//    Comparable & Serializable obj = b ? x : y;
    var obj =
        b ? x : y;
    obj.compareTo(null);
  }
}
