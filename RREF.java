import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RREF {
    public static void RREFsolver(int i, int rowCountInt, int colCountInt, float[][] matrix){
        float[] array = matrix[i];

        if (array[i] == 0) {
            int storei = i;
            for (int y=0; y<rowCountInt; y++) {
                float[] array2 = matrix[y];
                if (i<y && array2[i] != 0){
                    matrix[y] = matrix[i];
                    matrix[i] = array2;
                    System.out.println("----");
                    System.out.println("R"+(i+1) +" swap "+ "R"+(y+1)+":");
                    for (int z=0; z < matrix.length; z++) {
                        System.out.println(Arrays.toString(matrix[z]));
                    }
                    i = y;
                }
            }
            i = storei;
        }
        array = matrix[i];
        if (array[i] == 1){
            for (int y=0; y<rowCountInt; y++){
                float[] array2 = matrix[y];
                float rowMultiple = array2[i];
                if (array2[i] != 0 && array2 != array){
                    for (int z=0; z<colCountInt; z++){
                        array2[z] = array2[z] - (array[z]*rowMultiple);
                    }
                    System.out.println("----");
                    System.out.println("R"+(y+1) + " -("+rowMultiple+")R"+(i+1)+":");
                    for (int a=0; a < matrix.length; a++) {
                        System.out.println(Arrays.toString(matrix[a]));
                    }
                }
            }
        }
        if (array[i] != 0) {
            if (array[i] != 1) {
                float multiple = array[i]; // storing array[i] since it will be changed in first time through loop
                for (int z = 0; z < colCountInt; z++) {
                    array[z] = array[z] / multiple;
                }
                System.out.println("----");
                System.out.println("R" + (i + 1) + "/" + multiple + ":");
                for (int a = 0; a < matrix.length; a++) {
                    System.out.println(Arrays.toString(matrix[a]));
                }
            }
            for (int y=0; y<rowCountInt; y++){
                float[] array2 = matrix[y];
                float rowMultiple = array2[i];
                if (array2[i] != 0 && array2 != array){
                    for (int x=0; x<colCountInt; x++){
                        array2[x] = array2[x] - (array[x]*rowMultiple);
                    }
                    System.out.println("----");
                    System.out.println("R"+(y+1) + " -("+rowMultiple+")R"+(i+1)+":");
                    for (int a=0; a < matrix.length; a++) {
                        System.out.println(Arrays.toString(matrix[a]));
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter # of columns ");
        String colCount = scanner.nextLine();
        int colCountInt = Integer.parseInt(colCount);
        System.out.println("Enter # of rows ");
        String rowCount = scanner.nextLine();
        int rowCountInt = Integer.parseInt(rowCount);

        float[][] matrix = new float[rowCountInt][];

        for (int i=0; i<rowCountInt; i++){ // figure out why this skips values (print out i), learn what is actually happening to value i
            float[] array;
            array = new float[colCountInt];
            for (int x=0; x<array.length; x++){
                System.out.println("Enter an entry for row " + (i+1) + " column " + (x+1));
                String entry = scanner.nextLine();
                array[x]=Integer.valueOf(entry); // Converts string entry to integer
            }
            matrix[i] = array;
        }
        System.out.println("Your Matrix: ");
        for (int i=0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        if (colCountInt < rowCountInt){
            for (int i=0; i<colCountInt; i++) {
                RREFsolver(i, rowCountInt, colCountInt, matrix);
            }
        }
        else {
            for (int i=0; i<rowCountInt; i++) {
                RREFsolver(i, rowCountInt, colCountInt, matrix);
            }

        }
        System.out.println("----");
        System.out.println("Your matrix in Reduced Row Echelon Form:");
        for (int a=0; a < matrix.length; a++) {
            System.out.println(Arrays.toString(matrix[a]));
        }
    }
}
