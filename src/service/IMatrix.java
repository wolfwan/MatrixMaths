/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author wolf
 */
public interface IMatrix {

    public double[][] setMatrix(String input, int rows, int cols) throws ServiceException;

    public double[][] add(double[][] MatA, double[][] MatB, int rows, int colls) throws ServiceException;

    public double[][] multiply(double[][] MatA, double[][] MatB, int rowsInA, int CollsInA, int CollsInB) throws ServiceException;
}
