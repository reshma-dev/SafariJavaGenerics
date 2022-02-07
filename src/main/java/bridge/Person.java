package bridge;

public class Person implements Comparable<Person> {
  @Override  // Really?? Looks more like an OVERLOAD
  public int compareTo(Person o) {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {  // MUST BE OBJECT!
    return super.equals(obj);
  }
}
