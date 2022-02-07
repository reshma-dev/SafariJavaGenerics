package shopping;

public class Shop {
  public static void main(String[] args) {
    ShoppingPair<Sock> ps = new ShoppingPair<>(new Sock(9, "Red"), new Sock(10, "Red"));

    System.out.println("pair matches? " + ps.matched());

    ShoppingPair<Sock> ps2 =
        new ShoppingPair<>(new Sock(10, "Red"), new Sock(10, "Green"));

    System.out.println("pair matches? " + ps2.matched());
  }
}
