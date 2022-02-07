package morecocontra;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ArrayExample {

  public static <F, E extends F> F[] getAsArray(List<E> in, Class<F> cl) {
//    E[] rv = new E[in.size()]; // nope, can't use E as the base type

//    nope, not this either! not assignment compat in the caller
//    E[] rv = (E[])new Object[in.size()];

    F[] rv = (F[])Array.newInstance(cl, in.size());

    int idx = 0;
    for (E e : in) {
      rv[idx++] = e;
    }
    return rv;
  }

  public static void main(String[] args) {
    List<String> ls = List.of("Fred", "Jim", "Sheila");

//    String [] sa = getAsArray(ls, String.class);
//    CharSequence [] sa = getAsArray(ls, CharSequence.class);
    var sa = getAsArray(ls, CharSequence.class);
//    Object [] sa = getAsArray(ls, CharSequence.class);

    // BUT NOT THIS ONE!!!
//    Object [] sa = getAsArray(ls, StringBuilder.class);
//    sa[0] = new Object(); // only works if we *really* have Object [] created
    sa[0] = new StringBuilder("Alice");

    System.out.println("Array type is " + new String[0].getClass());
    System.out.println("Array type is " + sa.getClass());
    System.out.println("Contains " + Arrays.toString(sa));
  }
}
