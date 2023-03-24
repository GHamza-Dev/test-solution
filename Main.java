import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    // Board labels
    private static HashMap<Integer,String> columnLabels= new HashMap<>();
    private static HashMap<Integer,String> rowLabels= new HashMap<>();

    // Positions matrix
    private static String[][] position = new String[8][8];

    public static void initMatrix(int tourPositionX, int tourPositionY){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                position[i][j] = "-";
            }
        }
        position[3][1] = "n";
        position[6][3] = "b";
        position[3][6] = "b";
        position[tourPositionX][tourPositionY] = "t";
    }

    private static void initLabels(){
        // Set column labels
        columnLabels.put(0,"a");
        columnLabels.put(1,"b");
        columnLabels.put(2,"c");
        columnLabels.put(3,"d");
        columnLabels.put(4,"e");
        columnLabels.put(5,"f");
        columnLabels.put(6,"g");
        columnLabels.put(7,"h");

        // Set row labels
        rowLabels.put(0,"8");
        rowLabels.put(1,"7");
        rowLabels.put(2,"6");
        rowLabels.put(3,"5");
        rowLabels.put(4,"4");
        rowLabels.put(5,"3");
        rowLabels.put(6,"2");
        rowLabels.put(7,"1");
    }

    public static void main(String[] args){

        initLabels();

        int initialXPos = 3;
        int initialYPos = 3;

        initMatrix(3,3);

        List<String> result = new ArrayList<>();

        // Generator
        // Get down moves
        for (int i=initialYPos+1;i<7;i++){
            if(position[initialXPos][i].equals("n")){
                result.add("T"+columnLabels.get(initialXPos)+initialYPos+"x"+columnLabels.get(initialXPos)+i);
            } else if (position[initialXPos][i].equals("-")) {
                result.add("T"+columnLabels.get(initialXPos)+rowLabels.get(initialYPos)+"-"+columnLabels.get(initialXPos)+rowLabels.get(i));
            }else {
                break;
            }
        }

        // Get up moves
        for (int i=initialYPos-1;i>0;i--){
            if(position[initialXPos][i].equals("n")){
                result.add("T"+columnLabels.get(initialXPos)+initialYPos+"x"+columnLabels.get(initialXPos)+i);
            } else if (position[initialXPos][i].equals("-")) {
                result.add("T"+columnLabels.get(initialXPos)+rowLabels.get(initialYPos)+"-"+columnLabels.get(initialXPos)+rowLabels.get(i));
            }else {
                break;
            }
        }

        for (String r : result) {
            System.out.println(r);
        }
    }
}
