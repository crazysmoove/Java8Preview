public interface PhoneNumberInterface {

    public abstract String getAreaCode();

    public abstract String getNumber();

    public default String getFullNumber() {
        return "(" + getAreaCode() + ") " + getNumber();
    }

    public abstract boolean isOutOfState();

    public default boolean isLocal() {
        return !isOutOfState();
    }

}
