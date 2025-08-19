public class DeadCharacterException extends Exception {

    private final Character character;

    public DeadCharacterException(Character character) {
        super("The " + character.getClass().getSimpleName().toLowerCase() + " " + character.getName() + " is dead.");
        this.character = character;
    }

    @Override
    public String getMessage() {
        return "The " + character.getClass().getSimpleName().toLowerCase() + " " + character.getName() + " is dead.";
    }
    
}
