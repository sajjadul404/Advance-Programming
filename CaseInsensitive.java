package String;

public class CaseInsensitive {
 

    public static void main (String[]args){

        String x = "Hello" ;
        String y = "hello" ;

        boolean same = y.toLowerCase().equals(y.toLowerCase());
        boolean same1 = x.toUpperCase().equals(x.toUpperCase());

        System.out.println(same);
        System.out.println(same1);

    }


}
