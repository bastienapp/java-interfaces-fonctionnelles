public interface Human {

    String parler();

    default boolean marcher() {
        return true;
    }
}
