import java.util.*;
public class Lab01Task2
{
    /**
     * The method compares the old game records with the new game records and return a GameRecord array containing the most updated game records.
     * 
     * For the rules to generate the updated game record array, please refer to the lab manual online.
     * 
     * @param oldRecords    The GameRecord array holding up to 10 best records for each level from the previous game played.
     * @param newRecord     The new game record from the current game play.
     */
    public GameRecord[] updateGameRecords(GameRecord[] oldRecords, GameRecord newRecord) {
        GameRecord[] res = oldRecords;
        if (oldRecords.length < 1) {
            GameRecord[] reslt = new GameRecord[1];
            reslt[0] = newRecord;
            res = reslt;
        }
        else {
            GameRecord[] nersl = new GameRecord[oldRecords.length + 1];
            for (int f = 0; f < oldRecords.length; f++) {
                nersl[f] = oldRecords[f];
            }
            nersl[oldRecords.length] = newRecord;
            Util.sort(nersl);
            int nOfitems = 0;
            for (int i = 0; i < oldRecords.length; i++) { 
                if (oldRecords[i].getLevel() == newRecord.getLevel()) {
                    nOfitems += 1;
                }
            }
        
            String[] allName = new String[nOfitems];
            int n = 0;
            for (int i = 0; i < oldRecords.length; i++) { 
                if (oldRecords[i].getLevel() == newRecord.getLevel()) {
                    allName[n] = oldRecords[i].getName();
                    n += 1;
                }
            }
            for (int i = 0; i < oldRecords.length; i++) { 
                if (oldRecords[i].getLevel() == newRecord.getLevel() && oldRecords[i].getName().equals(newRecord.getName())) {
                    if (oldRecords[i].getScore() < newRecord.getScore()) {
                        oldRecords[i] = newRecord;
                        Util.sort(oldRecords);
                        res = oldRecords;
                        System.out.println(Arrays.asList(allName).contains("B"));
                    }
                }
                
                else if ( oldRecords[i].getLevel() == newRecord.getLevel() && !Arrays.asList(allName).contains(newRecord.getName())) {
                    if (nOfitems < 10) {                        
                        res = nersl;
                    }
                    else { 
                        for (int m = 0; m < oldRecords.length; m++) {
                            res[m] = nersl[m];
                        }
                    }
                }
                else if(oldRecords[i].getLevel() != newRecord.getLevel()) {
                    if (nOfitems < 10) {
                        res = nersl;
                    }
                    else {
                        for (int m = 0; m < oldRecords.length; m++) {
                            res[m] = nersl[m];
                        }
                    }
                }
            }
        }
        return res; // this line should be removed or modified when the implementation of this method is completed.
    }
    
    private void sort(GameRecord[] records) {
        Util.sort(records);
    }
    //test case 0: updating null or empty array
    public static void testCase0() {
    
        GameRecord[] oldRecords = new GameRecord[1];
        oldRecords[0] = new GameRecord("0", 0, 0);
        
        GameRecord newRecord = new GameRecord("B", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    // test case 1: updating an existing record, given that the new record has a better score.
    public static void testCase1() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord("B", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    // test case 2: inserting a new record given that we have less than records for the new record's level.
    public static void testCase2() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord("C", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("B, 2, 8");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }

    // test case 3: replacing a lower score record of the same level, given that we already have 10 records for that level.
    public static void testCase3() {
    
        GameRecord[] oldRecords = new GameRecord[10];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 10);
        oldRecords[2] = new GameRecord("C", 2, 10);
        oldRecords[3] = new GameRecord("D", 2, 10);
        oldRecords[4] = new GameRecord("E", 2, 10);
        oldRecords[5] = new GameRecord("F", 2, 10);
        oldRecords[6] = new GameRecord("G", 2, 10);
        oldRecords[7] = new GameRecord("H", 2, 10);
        oldRecords[8] = new GameRecord("I", 2, 10);
        oldRecords[9] = new GameRecord("J", 2, 8);
        
        GameRecord newRecord = new GameRecord("K", 2, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("D, 2, 10");
        System.out.println("E, 2, 10");
        System.out.println("F, 2, 10");
        System.out.println("G, 2, 10");
        System.out.println("H, 2, 10");
        System.out.println("I, 2, 10");
        System.out.println("K, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    public static void testCase4() {
    
        GameRecord[] oldRecords = new GameRecord[10];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 10);
        oldRecords[2] = new GameRecord("C", 2, 10);
        oldRecords[3] = new GameRecord("D", 2, 10);
        oldRecords[4] = new GameRecord("E", 2, 10);
        oldRecords[5] = new GameRecord("F", 2, 10);
        oldRecords[6] = new GameRecord("G", 2, 10);
        oldRecords[7] = new GameRecord("H", 2, 10);
        oldRecords[8] = new GameRecord("I", 2, 10);
        oldRecords[9] = new GameRecord("J", 2, 8);
        
        GameRecord newRecord = new GameRecord("A", 0, 10);
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 0, 10");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("D, 2, 10");
        System.out.println("E, 2, 10");
        System.out.println("F, 2, 10");
        System.out.println("G, 2, 10");
        System.out.println("H, 2, 10");
        System.out.println("I, 2, 10");
        System.out.println("K, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    // You can add more test case to test your program prior to submitting your code to the online grader.
    
    private static void printHighscoreTable(GameRecord[] records) {
        
        if (records == null) {
            return;
        }
        
        for (int i = 0; i < records.length; i++) {
            if (records[i] != null) {
                System.out.println(records[i].getName() + ", " + records[i].getLevel() + ", " + records[i].getScore());
            } else {
                System.out.println();
            }
        }
    }
}
