package Library_Management_System;

public class Encryption {
    private String password;
    Encryption(String password){
        this.password = password;
        } 

        public String main(){
        int length = this.password.length();

        char[] passwordArray = password.toCharArray();
        char[] encryptedArray = new char[length];
        for (int i = 0; i < passwordArray.length; i++) {
            encryptedArray[i] = (char) (passwordArray[i] + length);
        }

        String encryptedPassword = new String(encryptedArray);
        System.out.println("Original Password: " + password);
        System.out.println("Encrypted Password: " + encryptedPassword);
        return encryptedPassword;

        
        
    }
}
