/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author wolf
 */
public class Matrices extends DomainAbs{

    private int rows;
    private int columns;
    private String name;
    private double[][] matrix;

    /**
     * @return the rowsInA
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rowsInA the rowsInA to set
     */
    public void setRows(int rowsInA) {
        this.rows = rowsInA;
    }

    /**
     * @return the columnsInA
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columnsInA the columnsInA to set
     */
    public void setColumns(int columnsInA) {
        this.columns = columnsInA;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
