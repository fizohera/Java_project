

import java.util.Scanner;

public class LineReport {
    //Declare instance variable
	public static   final int ARRSIZ = 500;
	public  static LineUsage[] lineUsage = new LineUsage[ARRSIZ + 1];
	
   //create a constructor
	public LineReport() {
		for (int i = 1; i < ARRSIZ +1; i++)
			lineUsage[i] = new LineUsage();
	 }

	//Read log file line by line 
	//and split it into two string using white space  
	//store the result into string of array
	public void readLogFile() {
		
		Scanner scanner = new Scanner(System.in);
		String[] lineUser;

		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			if (!currentLine.trim().equals("")) {
				// System.out.println(currentLine);
				lineUser = currentLine.split(" ");
				int indx = Integer.parseInt(lineUser[0]);
			   lineUsage[indx].addObservation(lineUser[1]);  
			   //System.out.println("user " + lineUser[1] + "logged in terminal# " + lineUser[0]);
			}
		}
		scanner.close();
	}
	public LineUsage[] getLineUsage() { return lineUsage; }
	
	public static void main(String[] args) {
		LineReport lineReport = new LineReport();
		lineReport.readLogFile();
		LineUsage[] lineusag = lineReport.getLineUsage();
		
		
		System.out.println("Line Most Common User Count ");
		System.out.println("=========================== ");


		int max = 1; 
		while(lineusag[max].findMaxUsage() == null)
		{
			max++;
		}
		Usage maxUsage = lineusag[max].findMaxUsage();
		//System.out.println(max+" | " + c.getUserName()+ " "+ c.getCount())
		for (int i = 1; i < ARRSIZ+1; i++) {
            Usage usage = lineusag[i].findMaxUsage();
            if (usage != null) {
				if ((usage.getUserName().equals(maxUsage.getUserName()))) {
					System.out.println(i + "\t| " + maxUsage.getUserName() + "  |\t" + maxUsage.getCount());
				} else {
					System.out.println(i + "\t| " + usage.getUserName() + "  |\t" + usage.getCount());
				}
			}
           
		}
	}
}

		
//	public static void main(String[] args){
//        LineReport lineReport = new LineReport();
//        lineReport.readLogFile();
//        LineUsage[] lineUsage = lineReport.getLineUsage();
//        int mapsiz = lineUsage[1].mapSize();
//        int j = 1;
//        System.out.println("Line Most Common User Count ");
//        System.out.println("=========================== ");
//        Usage maxUsage = lineUsage[j].findMaxUsage();
//        System.out.println(j+" | "+ maxUsage.getUserName()+ "\t"+ maxUsage.getCount());
//        for (int i = 1; i < mapsiz; i++) {
//              j++;
//            Usage usage = lineUsage[i].getLogInfo(i);
//            if ((usage.getUserName().equals(maxUsage.getUserName())))
//                System.out.println(j+" | " + maxUsage.getUserName()+ "|\t"+ maxUsage.getCount());
//            else{System.out.println(j+" | " + usage.getUserName()+ "|\t"+ usage.getCount());}
//
//        }
//    }
//
//}
//	
