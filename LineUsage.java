
import java.util.*;

public class LineUsage {
   
	//Declare a hashmap
   private  Map<String, Integer> logInfo;
  
   //
   public LineUsage() {
       this.logInfo = new HashMap<String, Integer>();
   }
   //add entries into a hashmap 
   //Check the key first and if the key exists increment it's value by 1 
   //if not add the entry for the first time
   public void addObservation(String username) {
       if(logInfo.containsKey(username))
           logInfo.put(username,logInfo.get(username) + 1  );
       else
           logInfo.put(username, 1);
   }
  //Usage object created aout of hashmap and stored into arraylist 
  //then parse each element of arraylist to find the common user
   public Usage findMaxUsage(){
       int count = 0;
       Usage usage;

       ArrayList<Usage> us = new ArrayList<Usage>();

       for (String s: logInfo.keySet() ) {
           count = logInfo.get(s);
           usage = new Usage(s, count);
           us.add(usage);
       }
       
       if (us.isEmpty()) {  return null; }
  
       int max = us.get(0).getCount();
       String uName = us.get(0).getUserName();
       for (Usage usa : us) {
           if(usa.getCount() > max) {
               max = usa.getCount();
               uName = usa.getUserName();
              }
          }
       usage = new Usage(uName,max);
       return usage;
   }
   
   public Usage getLogInfo(int i){
       ArrayList <Usage> usage = new ArrayList<Usage>();
       int count ;
       for (String s: logInfo.keySet() ) {
           count = logInfo.get(s);
           usage.add(new Usage(s, count));
       }
       return usage.get(i);
   }
  
  public int mapSize() {
	  
	  return logInfo.size();
  }
  public Map <String, Integer> getMap(){
	  
	  return logInfo;
  }
}