import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main (String[]args){

        Support_Bot supportbot = new Support_Bot();
        supportbot.GreetCustomer();
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            String a;

            while((a = br.readLine()) != null) {
                if(supportbot.sayGoodbye(a.toLowerCase())){break;}
                supportbot.InsertStringtoArray(a);
                supportbot.checkForIntent();
            }

        }catch(Exception e){
            e.printStackTrace();
        }





    }
}
