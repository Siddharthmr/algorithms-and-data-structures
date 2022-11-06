public class Main{
    private static int[][] matrixA = {
        { 1, 2 },
        { 3, 4 }
    };
    private static int[][] matrixB = {
        { 5, 6 },
        { 7, 8 }
    };
    private static int[][] solution; //resulting matrix
    public static void main(String[] args){
        //nothing here, just calling methods
        add();
        multiply();
    }
    
    /**
     * adds matrix A to matrix B
     */
    public static void add(){
        System.out.println("A + B:");
        //if matrixes arent same size then addition isnt possible
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length){
           System.out.println("undefined");
           return;
        }
        //set the size of the resulting matrix
        solution = new int[matrixA.length][matrixA[0].length];
        //looping through and adding each value
         for (int i = 0; i < matrixA.length; i++){
            for (int j = 0; j < matrixA[0].length; j++){
                solution[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        //calles the method to print matrixes and the solution
        printSolution("a+b");
    }
    
    /**
     * Handles multiplication for a*b and b*a
     */
    public static void multiply(){
        System.out.println("\nA * B:");
        //the number columns of matrix a has to equal the number of rows of matrix B
        if (matrixA[0].length != matrixB.length){
            //if the condition is true, multiplication is not possible
            System.out.println("undefined");
            return;
        }
        //set the size of the resulting matrix
        solution = new int[matrixA.length][matrixB[0].length];
        //looping through both rows and columns to get the "dot product"
        //dot product from mathisfun.com
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixB.length; k++)
                    //multiplying then suming up
                    solution[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }
        //calling method to print solution
        printSolution("a*b");
        
        /** Same thing but matrix B and A are switches **/
        System.out.println("\nB * A:");
        solution = new int[matrixB.length][matrixA[0].length];
        for (int i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                for (int k = 0; k < matrixA.length; k++)
                    solution[i][j] += matrixB[i][k] * matrixA[k][j];
            }
        }
        printSolution("b*a");
    }
    
    /**
     * Handles printing out the solution and matrixes in correct format
     */
    public static void printSolution(String s){
        //conditions to see which solution needs to be printed
        if (s.equals("a*b") || s.equals("a+b")){
            //printing matrixA
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++){
                    //spacing from stackoverflow
                    //3 digits + 1 space = 4
                    System.out.printf("%4s", matrixA[i][j]);
                }
                //linebreak after each row
                System.out.println();
            }
            //which operator needs to be printed
            if (s.equals("a*b")){
                System.out.println("*");
            } else {
                System.out.println("+");
            }
            //printing matrixB
            for (int i = 0; i < matrixB.length; i++) {
                for (int j = 0; j < matrixB[0].length; j++){
                    System.out.printf("%4s", matrixB[i][j]);
                }
                System.out.println();
            }
        } else { //otherwise operation must be b*a
            //print matrixB
            for (int i = 0; i < matrixB.length; i++) {
                for (int j = 0; j < matrixB[0].length; j++){
                    System.out.printf("%4s", matrixB[i][j]);
                }
                System.out.println();
            }
            System.out.println("*");
            //print MatrixA
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++){
                    System.out.printf("%4s", matrixA[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("=");
        //print solution
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++){
                System.out.printf("%4s", solution[i][j]);
            }
            System.out.println();
        }
    }
}
