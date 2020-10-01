package J2Homework2;

public class NewException extends RuntimeException {

    private String excMessage;

    public NewException(String excMessage) {
        this.excMessage = excMessage;
    }

    @Override
    public String toString() {
        return "J2Homework2.NewException: " + excMessage;
    }


}