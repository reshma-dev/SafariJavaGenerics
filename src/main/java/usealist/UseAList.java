package usealist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseAList {

  // creates an array of List ... literally List[]
  // arrays know their runtime type, but cannot know
  // the E of List...
  public static void pollute(List<String> ... several) {}
  // This must be array of Object, it's NOT an array of whatever E was
  public static <E> void pollute(E ... several) {}

  // when CALLING this, compiler must validate we pass a List<String>
  // so this <String> IS passed into the classfile
  // BUT at runtime, there are not "List<String>" there are only List
//  public static void showList(List<String> ls) {}
  // BUT generic type params DO NOT differentiate attempts at overload
//  public static void showList(List<LocalDate> ls) {}

  public static void breakAList(List l) {
    l.add(1, LocalDate.now());
  }

  public static void main(String[] args) {
    List<String> names =
//        new ArrayList<String>(List.of("Freddy", LocalDate.now()));
        new ArrayList<>(List.of("Freddy"/*, LocalDate.now()*/));
    names = Collections.checkedList(names, String.class);

//    Class<String> cls = (Class<String>)"".getClass();
//    names = Collections.checkedList(names, cls);

    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");

//    names.add(1, LocalDate.now());

    System.out.println(names);
    System.out.println("first name is " + names.get(0));

    breakAList(names);

//    Object nameTwo = names.get(1);
//    String nameTwo = (String)names.get(1);
    String nameTwo = names.get(1);  // Compiler adds cast for us!!!
//    System.out.println(nameTwo);

//    names.add(1); // Autoboxing converts the primitive 1 into Integer(1)
//    Object obj = names.get(names.size() - 1);
//    System.out.println(obj.getClass());

//    names = "Hello";

//    List<int> li; // NOPE
    List<int[]> lai; // Yes!
    List<Integer> li; // Yes!

    Object obj = new ArrayList<String>();
//    if (obj instanceof List<String>) {}
    if (obj instanceof List) {}
  }
}
