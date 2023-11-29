public class merchant {
    public static gameUtilities Utility = new utilities(); 
    
    public static void handle_username(String userm){
        String username=userm;
        player player1= Utility.getUser_records().get(username).getPlayer();
        System.out.println(username);

    }

    /* actual implementation of the merchant*/
    //TODO: implement the merchant, please pull out the coins, the health and the sword from 
    // 
}
