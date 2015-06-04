/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wolf
 */
public class MatrixImpl implements IMatrix {

    private List<String> data = new ArrayList<String>();
    private String fileName;
    private char matrix;

    public void MatrixMaker() {
        readFile();
    }

    private void readFile() {
        try {
            fileName = "Matrix " + matrix + ".csv";

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fileName));
            data = (List<String>) ois.readObject();
            ois.close();

        } catch (Exception e) { //exceptions need to be defined declared thrown and caught
            data = new ArrayList<String>();
            System.out.println("file read error");
        }
    }

    private void writeFile(char matrix) {
        try {
            fileName = "Matrix " + matrix + ".csv";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(data);
            oos.close();

        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
            System.out.println("file write error");
        }
    }

    /**
     * @param matrix the matrix to set
     */

        @Override
    public double[][] setMatrix(String input, int rows, int cols) throws ServiceException {

        //Setting matrix A up
        double[][] outFinal = new double[rows][cols];
        String[] matStringArray = input.split(",");
        double[] matDoubleArray = new double[matStringArray.length];

        if (matStringArray.length != (rows * cols)) {
            throw new ServiceException("Theres the wrong amount of values in your matrix!");
        }

        for (int i = 0; i < matDoubleArray.length; i++) {
            try {
                matDoubleArray[i] = Double.parseDouble(matStringArray[i]);
            } catch (NumberFormatException nfe) {
                System.out.println("exception making Matrix into double = " + nfe);
            }
        }

        //Setting out matrix
        {
            int i = 0;
            for (int j = 0; j < outFinal.length; j++) {
                for (int k = 0; k < outFinal[0].length; k++) {
                    outFinal[j][k] = matDoubleArray[i];
                    i++;
                }
            }
        }
        return outFinal;
    }
    
    @Override
    public double[][] add(double[][] matA, double[][] matB, int rows, int colls) throws ServiceException {

        int c;
        int d;
        double[][] sum = new double[rows][colls];

        if (matA.length != rows) {
            throw new ServiceException("You have an incorrect amount of rows in the matrix A");
        } else if (matA[0].length != colls) {
            throw new ServiceException("You have an incorrect amount of collumns in matrix A");
        } else if (matB.length != rows) {
            throw new ServiceException("You have an incorrect amount of rows in matrix B");
        } else if (matB[0].length != colls) {
            throw new ServiceException("You have an incorrect amount of collumns in matrix B");
        } else if (matA.length != matB.length) {
            throw new ServiceException("The rows in the matrices need to be the same!");
        } else if (matA[0].length != matB[0].length) {
            throw new ServiceException("The collumns in the matrices need to be the same!");
        }

        for (c = 0; c < rows; c++) {
            for (d = 0; d < colls; d++) {
                sum[c][d] = matA[c][d] + matB[c][d];
            }
        }
        return sum;
    }

    
    @Override
    public double[][] multiply(double[][] matA, double[][] matB, int rowsInA, int collsInA, int collsInB) throws ServiceException {

        double[][] finalMatrix = new double[rowsInA][collsInB];

        if (matA.length != rowsInA) {
            throw new ServiceException("You have an incorrect amount of rows in the matrix A");
        } else if (matA[0].length != collsInA) {
            throw new ServiceException("You have an incorrect amount of collumns in matrix A");
        } else if (matB.length != collsInA) {
            throw new ServiceException("You have an incorrect amount of rows in matrix B");
        } else if (matB[0].length != collsInB) {
            throw new ServiceException("You have an incorrect amount of collumns in matrix B");
        }

        //multiplying Matrices
        for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < collsInB; j++) {
                for (int k = 0; k < collsInA; k++) {
                    finalMatrix[i][j] = finalMatrix[i][j] + matA[i][k] * matB[k][j];
                }
            }
        }
        return finalMatrix;
    }
}
