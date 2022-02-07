package shopping;


import java.util.function.Function;

// Style *strongly* recommends single uppercase letters for type params
//public class ShoppingPair<E extends Sized, String> extends Pair<E> {
//  java.lang.String s = "Hello";
public class ShoppingPair<E extends Sized & Colored> extends Pair<E> {

  public ShoppingPair(E left, E right) {
    super(left, right);
  }

  public <F extends Sized & Colored> ShoppingPair<F> map(Function<E, F> op) {
    return new ShoppingPair(
        op.apply(left), op.apply(right)
    );
  }

  public boolean matched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }

  public static <E extends Sized & Colored> boolean matches(E left, E right) {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
