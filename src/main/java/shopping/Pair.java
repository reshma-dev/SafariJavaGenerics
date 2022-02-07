package shopping;

import java.util.function.BiPredicate;

// here, <E> "declares" a generic type parameter for
// *instances* of Pair
public class Pair<E> {
  E left;
  E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

//  public boolean matched() {
//    // nasty possibilities include
//    // test with instanceof Sized, cast...
//    return left.getSize() == right.getSize();
//  }

  // BEST possiblity
  public boolean matched(BiPredicate<E, E> test) {
    return test.test(left, right);
  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
