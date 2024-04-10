import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static int maxSum = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> emptyCoords = new ArrayList<Integer>();
            navigate(7, i, 0, emptyCoords);
        }
        System.out.println("Bilbo's path is: ");
        for (int i = 0; i < publicCoords.size() - 1; i += 2) {
            System.out.println("Move " + (i / 2 + 1) + " Row " + (8 - publicCoords.get(i)) + " Col " + (publicCoords.get(i + 1) + 1));
        }
        System.out.println("The total number of gems collected on the way is " + maxSum);
        System.out.println("The Arkenstone is stored in vault " + (publicCoords.get(publicCoords.size() - 1) + 1));
    }

    public static ArrayList<Integer> publicCoords;

    public static void navigate(int row, int col, int accumulator, ArrayList<Integer> localCoords) {
        int[][] vault = {
                {21, 95, 20, 82, 66, 52, 89, 35},
                {74, 40, 37, 78, 23, 14, 5, 79},
                {63, 16, 4, 31, 25, 17, 59, 32},
                {15, 92, 71, 13, 48, 77, 11, 91},
                {12, 67, 88, 22, 64, 47, 70, 56},
                {7, 30, 51, 65, 27, 94, 97, 83},
                {93, 53, 24, 46, 86, 1, 41, 10},
                {84, 99, 68, 75, 98, 44, 33, 96}
        };
        //start here
        /**
         coords.add(row);
         coords.add(col);
         if (row == 7) {
         ArrayList<Integer> path1 = new ArrayList<>(coords);
         ArrayList<Integer> path2 = new ArrayList<>(coords);
         ArrayList<Integer> path3 = new ArrayList<>(coords);
         accumulator += vault[7][col];
         navigate(row - 1, col, accumulator, path1);
         navigate(row - 1, col - 1, accumulator, path2);
         navigate(row - 1, col + 1, accumulator, path3);
         */
        // when at top
        if (row == 0) {
            localCoords.add(row);
            localCoords.add(col);
            if (col == 0) {
                accumulator += vault[row][col];
                if (accumulator > maxSum) {
                    maxSum = accumulator;
                    publicCoords = localCoords;
                }
            }
            if (col == 7) {
                accumulator += vault[row][col];
                if (accumulator > maxSum) {
                    maxSum = accumulator;
                    publicCoords = localCoords;
                }
            } else if (col > 0 && col < 7) {
                accumulator += vault[row][col];
                if (accumulator > maxSum) {
                    maxSum = accumulator;
                    publicCoords = localCoords;
                }
            }
            //between top and bottom rows
        } else {
            localCoords.add(row);
            localCoords.add(col);
            if (col == 0) {
                //accumulator += Math.max(vault[row][col], vault[row][col + 1]);
                ArrayList<Integer> path1 = new ArrayList<>(localCoords);
                ArrayList<Integer> path2 = new ArrayList<>(localCoords);
                navigate(row - 1, col, accumulator + vault[row][col], path1);
                navigate(row - 1, col + 1, accumulator + vault[row][col], path2);
            }
            if (col == 7) {
                //accumulator += Math.max(vault[row][col], vault[row][col - 1]);
                ArrayList<Integer> path1 = new ArrayList<>(localCoords);
                ArrayList<Integer> path2 = new ArrayList<>(localCoords);
                navigate(row - 1, col, accumulator + vault[row][col], path1);
                navigate(row - 1, col - 1, accumulator + vault[row][col], path2);

            } else if (col > 0 && col < 7) {
                //accumulator += Math.max(vault[row][col], Math.max(vault[row][col - 1], vault[row][col + 1]));
                ArrayList<Integer> path1 = new ArrayList<>(localCoords);
                ArrayList<Integer> path2 = new ArrayList<>(localCoords);
                ArrayList<Integer> path3 = new ArrayList<>(localCoords);

                navigate(row - 1, col, accumulator + vault[row][col], path1);
                navigate(row - 1, col + 1, accumulator + vault[row][col], path2);
                navigate(row - 1, col - 1, accumulator + vault[row][col], path3);
            }
        }
    }
}