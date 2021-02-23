import java.util.*;
import java.util.Map.Entry;

public class TestLineUsage {

	public static void main(String[] args) {

		LineUsage lineUsage = new LineUsage();

		lineUsage.addObservation("OPERATOR");
		lineUsage.addObservation("USERMGR");
		lineUsage.addObservation("OPERATOR");

		
		Set<Map.Entry<String, Integer>> mapSet = lineUsage.getMap().entrySet();
		int i= 1;
		System.out.println("  User_Name\tCount" );

		for (Entry <String, Integer> ent: mapSet)  {
			System.out.println(i +" " + ent.getKey() + "\t" + ent.getValue());
			i++;
		}

		Usage u = lineUsage.findMaxUsage();
		System.out.println("The most Common user is");
		System.out.println(u.getUserName() + " " + u.getCount());

	}
}