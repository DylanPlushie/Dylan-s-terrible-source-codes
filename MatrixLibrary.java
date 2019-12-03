//import java.util.Scanner;
public class Matrix {
  public static void main(String[] args)
	{
    // Use the following (m1, m2, m3, m4) to define matrices (you can also make more if you want to)
    // It should be noted that if you create or edit a matrix, you should test if it is a valid matrix I'll comment where that is
    // BTW, if at anytime you don't want to run a piece of code in this main method, you should comment the lines of code by placing "//" in front of the line
    // Here are a list of the methods and their uses:
    /*
      isValidMatrix(double[][] matrix) - checks if the matrix you put in the parentheses is a valid matrix, this returns a true/false value
      printMatrix(double[][] matrix) - If you want to print out a matrix, use this
      canBeAdded(double[][] mat1, double[][] mat2) - checks if the two matrices you passed into the arguments can be added together
      addMatrices(double[][] mat1, double[][] mat2) - adds two matrices together
      subtractMatrices(double[][] mat1, double[][] mat2) - subtracts mat2 from mat1
      scalarMultiplication(double[][] matrix, double scalar) - multiplies every element in the matrix by the scalar
      canMatrixMult(double[][] mat1, double[][] mat2) - checks if two matrices can be multiplied together (in respective order)
      matrixMultiplication(double[][] mat1, double[][] mat2) - multiplies two matrices together
      transpose(double[][] matrix) - transposes a square matrix
      transpose(doube[][] matrix, int rowNumber, int columnNumber) - transposes a rectangular matrix
      makeASubmatrix(double[][] matrix, int rowIndex, int columnIndex) - makes a submatrix from a matrix given an index of a specific element
      validInverse(double[][] matrix) - checks if the determinant of a matrix is zero and if the matrix is square, (if it can be an inverse)
      canGetDet(double[][] matrix) - checks if the matrix is square... (I still don't know if you can find the determinant of a non-square matrix yet)
      getDet(double[][] matrix) - finds the determinant of a matrix
      canBeInverted(double[][] matrix) - Checks that the matrix can be inverted (is square)
      invert(double[][] matrix) - returns the inverse of the matrix
      matrixOfMinors(double[][] matrix) - finds the matrix of minors of a square matrix
      cofactor(double[][] matrix) - cofactors the entire matrix
      isInverse(double[][] matrix) - checks that the inverse is actually the invers (i.e. their matrix multiplication returns the identity matrix)
    */
		double[][] m1 = {
				{2, 3, 4, 2},
				{5, 10, 8, 6},
				{9, 0, 1, 3},
				{16, 7, 3, 2}
		};
		double[][] m2 = {
				{1, 7, 2, 4, 2},
				{17, 0, 0, 3, 5},
				{3, 9, 8, 3, 2},
				{4, 27, 1, 3, 67}
		};
		double[][] m3 = {
				{1, 5},
				{33, 2}
		};
		double[][] m4 = {
				{3, 4, 7},
				{1, 2, 3},
				{3, 2, 1}
		};
	}

    /*public static double[][] createMatrix()
    {
        Scanner input = new Scanner(System.in);
        int m = 0, n = 0;
        do
        {
            System.out.println("How many rows do you want?");
            m = input.nextInt();
        } while(m <= 0);
        do
        {
            System.out.println("How many columns do you want?");
            n = input.nextInt();
        } while(n <= 0);
        
        double[][] matrix = new double[m][n];
        for(int i = 0; i < matrix.length; i++)
        {
        	for(int j = 0; j < matrix[0].length; j++)
        	{
        		System.out.println("What number do you want at index " + i + ", " + j);
        		matrix[i][j] = input.nextDouble();
        	}
        }
        //input.close();
        return matrix;
    }*/

	public static void printMatrix(double[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

	public static boolean isValidMatrix(double[][] matrix)
	{
		if(matrix.length > 1)
		{
			for(int i = 1; i < matrix.length; i++)
			{
				if(matrix[i-1].length != matrix[i].length)
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean canBeAdded(double[][] m1, double[][] m2)
	{
		if(m1.length == m2.length && m1[0].length == m2[0].length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static double[][] addMatrices(double[][] m1, double[][] m2)
	{
		for(int i = 0; i < m1.length; i++)
		{
			for(int j = 0; j < m1[i].length; j++)
			{
				m1[i][j] += m2[i][j];
			}
		}
		return m1;
	}

	public static double[][] subtractMatrices(double[][] m1, double[][] m2)
	{
		for(int i = 0; i < m1.length; i++)
		{
			for(int j = 0; j < m1[i].length; j++)
			{
				m1[i][j] -= m2[i][j];
			}
		}
		return m1;
	}

	public static double[][] scalarMultiplication(double[][] matrix, double scalar)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] *= scalar;
			}
		}
		return matrix;
	}

	public static boolean canMatrixMult(double[][] m1, double[][] m2)
	{
		if(m1[0].length == m2.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static double[][] matrixMultiplication(double[][] m1, double[][] m2)
	{
		double[][] matrix = new double[m1.length][m2[0].length];
		m2 = transpose(m2, m2.length, m2[0].length);
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				double temp = 0;
				for(int k = 0; k < m1[0].length; k++)
				{
					temp += (m1[i][k] * m2[j][k]);
				}
				matrix[i][j] = temp;
			}
		}
		return matrix;
	}

	public static double[][] transpose(double[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = i; j < matrix[0].length; j++)
			{
				double temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		return matrix;
	}
	
	public static double[][] transpose(double[][] matrix, int matRows, int matCols)
	{
		double[][] matrix2 = new double[matCols][matRows];
		for(int i = 0; i < matCols; i++)
		{
			for(int j = 0; j < matRows; j++)
			{
				matrix2[i][j] = matrix[j][i];
			}
		}
		return matrix2;
	}

	public static double[][] makeASubmatrix(double[][] matrix, int rowIndex, int columnIndex)
	{
		double[][] submatrix = new double[matrix.length-1][matrix[0].length-1];
		int k = 0, l = 0;
		for(int i = 0; i < matrix.length; i++)
		{
			if(i == rowIndex) { continue; }
			l = 0;
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(j == columnIndex) { continue; }
				submatrix[k][l] = matrix[i][j];
				l++;
			}
			k++;
		}
		return submatrix;
	}
	
	public static boolean validInverse(double[][] matrix)
	{
	    if((getDet(matrix) == 0) || (matrix.length != matrix[0].length))
	    {
	        return false;
	    }
	    return true;
	}
	
	public static boolean canGetDet(double[][] matrix)
	{
		if(matrix.length == matrix[0].length)
		{
			return true;
		}
		return false;
	}
	
	public static double getDet(double[][] matrix)
	{
	    double determinant = 0.00;
	    if(matrix.length == 2)
	    {
	        return ((matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]));
	    }
	    else
	    {
	        for(int i = 0; i < matrix.length; i++)
	        {
	            if(i%2 == 0)
	            {
	                determinant += matrix[0][i] * getDet(makeASubmatrix(matrix, 0, i));
	            }
	            else
	            {
	                determinant -= matrix[0][i] * getDet(makeASubmatrix(matrix, 0, i));
	            }
	        }
	        return determinant;
	    }
	}
	
	public static boolean canBeInverted(double[][] matrix)
	{
		if(matrix.length == matrix[0].length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static double[][] matrixOfMinors(double[][] matrix)
	{
	    double[][] minor = new double[matrix.length][matrix[0].length];
	    for(int i = 0; i < minor.length; i++)
	    {
	        for(int j = 0; j < minor[i].length; j++)
	        {
	            minor[i][j] = getDet(makeASubmatrix(matrix, i, j));
	        }
	    }
	    return minor;
	}
	
	public static double[][] cofactor(double[][] matrix)
	{
	    for(int i = 0; i < matrix.length; i++)
	    {
	        for(int j = 0; j < matrix[i].length; j ++)
	        {
	            if((i+j)%2 == 1)
	            {
	                matrix[i][j] = -matrix[i][j];
	            }
	        }
	    }
	    return matrix;
	}
     
    public static double[][] invert(double[][] matrix)
    {
    	double det = 1 / getDet(matrix);
    	matrix = matrixOfMinors(matrix);
    	matrix = cofactor(matrix);
    	matrix = transpose(matrix);
    	matrix = scalarMultiplication(matrix, det);
    	return matrix;
    }

 	public static boolean isInverse(double[][] m1, double[][] m2)
 	{
 		double[][] matrix = matrixMultiplication(m1, m2);
 		for(int i = 0; i < matrix.length; i++)
 		{
 			for(int j = 0; j < matrix[0].length; j++)
 			{
 				if(i == j)
 				{
 					if(matrix[i][j] != 1.00)
 					{
 						return false;
 					}
 				}
 				else
 				{
 					if(matrix[i][j] != 0.00)
 					{
 						return false;
 					}
 				}
 			}
 		}
 		return true;
 	}
}
