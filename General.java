package Final;


public class General {
    final protected int key = 10;
    
    String encrypt(String string){
        
        char[] ch1 = string.toCharArray();
        String encrypted = "";
        System.out.println("Original string is :"+string);
        for (char c1: ch1)
        {
            c1 += key;
            encrypted = encrypted + c1;
        }
        System.out.println("Encrypted string is :" + encrypted);
        return encrypted;

    }
    boolean containsDigit(String input)
     {
        char[] ch1 = input.toCharArray();
        for(char c: ch1){
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    boolean containsChar(String input)
     {
        char[] numbers = input.toCharArray();
        for(char c: numbers){
            if (Character.isDigit(c)) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    boolean contains10Digit(String input)
     {
         int ct = 0;
        char[] numbers = input.toCharArray();
        for(char c: numbers){
            System.err.print(c);
            ct++;
        }
        if(ct == 10){
            return true;
        }
        return false;
    }
}
