package shopping;


// Style *strongly* recommends single uppercase letters for type params
//public class ShoppingPair<E extends Sized, String> extends Pair<E> {
//  java.lang.String s = "Hello";
public class ShoppingPair<E extends Sized & Colored> extends Pair<E> {

  public ShoppingPair(E left, E right) {
    super(left, right);
  }

  public boolean matched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
