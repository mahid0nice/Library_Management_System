//package Library_Management_System;

public class Encryption {
    private String password;
    Encryption(String password){
        this.password = password;
        } 

        public String encrypt(){
        int length = this.password.length();

        char[] pass = password.toCharArray();
        char[] encrypt = new char[length];
        for (int i = 0; i < pass.length; i++) {
            encrypt[i] = (char) (pass[i] + length);
        }

        String encryptedPassword = new String(encrypt);
        System.out.println("Original Password: " + password);
        System.out.println("Encrypted Password: " + encryptedPassword);
        return encryptedPassword;

        
        
    }
}
