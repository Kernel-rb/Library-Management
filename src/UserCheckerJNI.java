package src;

public class UserCheckerJNI {
    static {
        System.loadLibrary("usercheck");
    }
    public native static boolean checkUsernameExists(String username);
    public native static boolean checkEmailExists(String email);
    public native static boolean checkPhoneNumberExists(String phoneNumber);

    public static void main(String[] args) {
        String usernameToCheck = "kernel";
        if (checkUsernameExists(usernameToCheck)) {
            System.out.println("Username " + usernameToCheck + " exists.");
        } else {
            System.out.println("Username " + usernameToCheck + " does not exist.");
        }

        String emailToCheck = "kernel@gmail.com";
        if (checkEmailExists(emailToCheck)) {
            System.out.println("Email " + emailToCheck + " exists.");
        } else {
            System.out.println("Email " + emailToCheck + " does not exist.");
        }

        String phoneNumberToCheck = "65456435";
        if (checkPhoneNumberExists(phoneNumberToCheck)) {
            System.out.println("Phone number " + phoneNumberToCheck + " exists.");
        } else {
            System.out.println("Phone number " + phoneNumberToCheck + " does not exist.");
        }
    }
}
