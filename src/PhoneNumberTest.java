public class PhoneNumberTest implements PhoneNumberInterface {

    public static void main(String[] args) {
        PhoneNumberTest test = new PhoneNumberTest();
        System.out.println(test.getFullNumber());
        System.out.println(test.isLocal());
    }

    @Override
    public String getAreaCode() {
        return "901";
    }

    @Override
    public String getNumber() {
        return "123-4567";
    }

    @Override
    public boolean isOutOfState() {
        return false;
    }

    @Override
    public boolean isLocal() {
        return true;
    }

}
