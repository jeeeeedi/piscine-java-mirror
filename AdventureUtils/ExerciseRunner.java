public class ExerciseRunner {

    public static void main(String[] args) {
        System.out.println(Character.printStatus());

/*         Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 15);

        System.out.println(Character.printStatus());

        Character winner = Character.fight(aragorn, uruk); */


        Character legolas = new Character("Legolas", 20);
        Character sephiroth = new Character("Sephiroth", 8);
        Character commandantShepard = new Character("Commandant Shepard", 18);

        Character winner = Character.fight(legolas, sephiroth);

        System.out.println(winner.toString());
        System.out.println(Character.printStatus());
    }
}