public class Support_Bot {
    private Dictonary dictonary = new Dictonary();
    private Data Data = new Data();
    private String ContextString = "";
    private String [] InsertArray;
    private String Intent;
    private String IntentPlusContext;


    public void GreetCustomer(){
        String Greeting = dictonary.Greeting;
        System.out.println(Greeting);
    }
    public void InsertStringtoArray(String UserInsert){
        //TODO Bi-gramm bzw Normalisierung
        UserInsert = UserInsert.toLowerCase();
        InsertArray = UserInsert.split("[\\s \\p{Punct} ]+");
    }

    public void checkForIntent(){
        Intent  = "";
        for(int i =0 ; i < InsertArray.length ; i++){
            if(dictonary.Keys.containsKey(InsertArray[i])){
                    Intent = dictonary.Keys.get(InsertArray[i]);
            }
            }
        checkForSolutionWorking(InsertArray);
        if(Intent.equals("")) {
            System.out.println(Data.NoMatch);
        }else {
            getResponse();
        }

       //System.out.println("INTENT-->"+ Intent);
    }

    public void getResponse(){
       String Response = "";
        if(!ContextString.contains(Intent)) {
            IntentPlusContext = ContextString + Intent;
            ContextString += Intent;
        }
        //System.out.println("INTENTContext-->"+ IntentPlusContext);
        if(dictonary.Responses.containsKey(IntentPlusContext)) {
            Response = dictonary.Responses.get(IntentPlusContext);
            if(IntentPlusContext.contains("Problem") && IntentPlusContext.contains("Product")){
                ContextString += Config.Solution;
            }
        }else {
            ContextString = "";
            Response = Data.NoMatch;
        }
        System.out.println(Response);
    }

    private void checkForSolutionWorking (String []UserInsert){
        String IntentPlusContext = ContextString + Intent;
        if(IntentPlusContext.contains(Config.Solution)) {
            for (int i = 0; i < UserInsert.length; i++) {
                for (int I = 0; I < dictonary.goodKeyword.length; I++) {
                    if (dictonary.goodKeyword[I].equals(UserInsert[i])) {
                        Intent = Config.Positive;
                    }
                }
                for (int I = 0; I < dictonary.badKeyword.length; I++) {
                    if (dictonary.badKeyword[I].equals(UserInsert[i])){
                        Intent = Config.Negative;
                    }
                }
            }
        }
    }

    public boolean sayGoodbye(String UserInsert){
                for (int I = 0; I < dictonary.End.length; I++) {
                    if (UserInsert.contains(dictonary.End[I])) {
                        return true;
                    }
                }

        return false;

    }




}
