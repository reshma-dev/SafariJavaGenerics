package taxation;

import java.util.ArrayList;
import java.util.List;

public class TaxPreparers {
  public static void prepareTaxes(Taxable t) {}

// NO NO NO!  public static <E> void prepareBulkTaxes(List<E extends Taxable> lt) {
//  public static void prepareBulkTaxes(List<? extends Taxable> lt) {
  public static <E extends Taxable> void prepareBulkTaxes(List<E> lt) {
//    lt.add(new Corporation());
//    lt.add(new Taxable());
//    lt.add(new Individual());
//    lt.add(lt.get(0));  // OK with E extends Taxable, NOT OK with ? extends :)
    for (Taxable t : lt) {
      prepareTaxes(t);
    }
  }

// BAD SYNTAX #1
//  public static void collectJoesClients(List<Individual extends ?> li) {
// BAD SYNTAX #2
//  public static <E super Individual> void collectJoesClients(List<E> li) {
  public static void collectJoesClients(List<? super Individual> li) {
    li.add(new Individual());
    li.add(new Individual());

//    Individual i = li.get(0);
  }

  public static void main(String[] args) {
    List<Taxable> clients = new ArrayList(List.of(
        new Corporation(), new Individual(), new Corporation()
    ));
    collectJoesClients(clients);
    prepareBulkTaxes(clients);

    // Integrate Joe's Tax company (only deals with individuals...)
    List<Individual> joesClients = new ArrayList<>(List.of(
        new Individual(), new Individual(), new Individual()
    ));

    collectJoesClients(joesClients);
    prepareBulkTaxes(joesClients);
    prepareBulkTaxes(new ArrayList<Corporation>());
  }
}
