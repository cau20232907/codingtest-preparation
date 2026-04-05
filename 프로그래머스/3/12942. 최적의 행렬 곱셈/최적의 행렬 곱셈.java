class Solution {
    public int solution(int[][] matrix_sizes) {
        int[][] matrixCalculations = new int[matrix_sizes.length-1][matrix_sizes.length-1];
        for(int i=0; i < matrixCalculations.length; i++) {
            for(int j=0; j < matrixCalculations.length - i; j++) {
                int currentMinCalculation = Integer.MAX_VALUE;
                for(int k=0; k < i + 1; k++) {
                    int currentCalculation = matrix_sizes[j][0] *
                        matrix_sizes[j+i+1][1] * matrix_sizes[j+k][1];
                    if (k != 0) {
                        currentCalculation += matrixCalculations[k-1][j];
                    }
                    if (k != i) {
                        currentCalculation += matrixCalculations[i-k-1][j+k+1];
                    }
                    currentMinCalculation = Math.min(currentMinCalculation, currentCalculation);
                }
                matrixCalculations[i][j] = currentMinCalculation;
            }
        }
        return matrixCalculations[matrixCalculations.length - 1][0];
    }
}