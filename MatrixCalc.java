import java.util.Scanner;
import java.util.ArrayList;
public class MatrixCalc {
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		String[] operations = {"Addition", "Subtraction", "Scalar multiplication", "Matrix multiplication", "Invert", "Get determinant", "Get submatrix", "Transpose", "Get matrix of minors"};
		System.out.println("Hello, welcome to my Matrix Calc");
		int noOfMats = 0;
		do
		{
			System.out.println("How many matrices do you want to enumerate");
			noOfMats = input.nextInt();
		} while(noOfMats <= 0);
		ArrayList<double[][]> matrices = new ArrayList<double[][]>();
		for(int i = 0; i < noOfMats; i++)
		{
			//do{
				matrices.add(i, Matrix.createMatrix());
			//} while(Matrix.isValidMatrix(matrices.get(i)));
		}
		
		while(true)
		{
			System.out.println("Now choose an operation by inputing its number:");
			printOperations(operations);
			int j = -1;
			while(j < 0 || j >= operations.length)
			{
				j = input.nextInt();
			}
			
			int mat = 0, mat1 = 0, mat2 = 0;
			if(j == 2 || j > 3)
			{
				printAllMatrices(matrices);
				System.out.println("Choose one of your matrices: ");
				mat = input.nextInt();
			}
			else
			{
				System.out.println("Choose two of your matrices: ");
				printAllMatrices(matrices);	
				System.out.println("Choose your first matrix:");
				mat1 = input.nextInt();
				System.out.println("Choose your second matrix:");
				mat2 = input.nextInt();
			}
			
			int i = matrices.size();
			switch(j)
			{
				case 0:
					if(Matrix.canBeAdded(matrices.get(mat1), matrices.get(mat2)))
					{
						System.out.println("The additon of the matrices:");
						Matrix.printMatrix(matrices.get(mat1));
						System.out.println("and");
						Matrix.printMatrix(matrices.get(mat2));
						System.out.println("is: ");
						matrices.add(Matrix.addMatrices(matrices.get(mat1),  matrices.get(mat2)));
						Matrix.printMatrix(matrices.get(i));
					}
					else
					{
						System.out.println("Matrices cannot be subtracted");
					}
					break;
					
				case 1:
					if(Matrix.canBeAdded(matrices.get(mat1), matrices.get(mat2)))
					{
						System.out.println("The subtraction of the matrices:");
						Matrix.printMatrix(matrices.get(mat1));
						System.out.println("and");
						Matrix.printMatrix(matrices.get(mat2));
						System.out.println("is: ");
						matrices.add(Matrix.subtractMatrices(matrices.get(mat1),  matrices.get(mat2)));
						Matrix.printMatrix(matrices.get(i));
					}
					else
					{
						System.out.println("Matrices cannot be subtracted");
					}
					break;
				
				case 2:
					System.out.println("Choose a scalar value (of any real value)");
					double k = input.nextDouble();
					System.out.println("The scalar multiplication of:");
					Matrix.printMatrix(matrices.get(mat));
					System.out.println("and");
					System.out.println(k);
					System.out.println("is: ");
					matrices.add(Matrix.scalarMultiplication(matrices.get(mat), k));
					Matrix.printMatrix(matrices.get(i));
					break;
					
				case 3:
					if(Matrix.canMatrixMult(matrices.get(mat1), matrices.get(mat2)))
					{
						System.out.println("The matrix multiplication of the matrices:");
						Matrix.printMatrix(matrices.get(mat1));
						System.out.println("and");
						Matrix.printMatrix(matrices.get(mat2));
						System.out.println("is: ");
						matrices.add(Matrix.matrixMultiplication(matrices.get(mat1), matrices.get(mat2)));
						Matrix.printMatrix(matrices.get(i));
					}
					else
					{
						System.out.println("These matrices cannot be multiplied");
					}
					break;
					
				case 4:
					if(Matrix.canBeInverted(matrices.get(mat)))
					{
						System.out.println("The inverted matrix of the matrix:");
						Matrix.printMatrix(matrices.get(mat));
						System.out.println("is: ");
						matrices.add(Matrix.invert(matrices.get(mat)));
						Matrix.printMatrix(matrices.get(i));
					}
					else
					{
						System.out.println("Cannot be inverted");
					}
					break;
					
				case 5:
					if(Matrix.canGetDet(matrices.get(mat)))
					{
						System.out.println("The determinant of the matrix:");
						Matrix.printMatrix(matrices.get(mat));
						System.out.println("is:");
						System.out.println(Matrix.getDet(matrices.get(mat)));
					}
					break;
					
				case 6:
					if(matrices.get(mat).length == 1 || matrices.get(mat)[0].length == 1)
					{
						System.out.println("Cannot make a submatrix from this");
					}
					else
					{
						int rI = 0, cI = 0;
						while(true)
						{
							System.out.println("Choose a row index:");
							rI = input.nextInt();
							if(rI >= 0 && rI < matrices.get(i).length)
							{
								break;
							}
						} 
						while(true)
						{
							System.out.println("Choose a column index:");
							cI = input.nextInt();
							if(cI >= 0 && cI < matrices.get(i)[0].length)
							{
								break;
							}
						} 
						System.out.println("The submatrix of the matrix:");
						Matrix.printMatrix(matrices.get(mat));
						System.out.println("for the element at the index: " + rI + ", " + cI + " is:");
						matrices.add(Matrix.makeASubmatrix(matrices.get(mat), rI, cI));
						Matrix.printMatrix(matrices.get(i));
					}
					break;
					
				case 7:
					System.out.println("The transposition of the matrix: ");
					Matrix.printMatrix(matrices.get(mat));
					System.out.println("is: ");
					matrices.add(Matrix.transpose(matrices.get(mat), matrices.get(mat).length, matrices.get(mat)[0].length));
					Matrix.printMatrix(matrices.get(i));
					break;
					
				case 8:
					// matrix of minors
					System.out.println("The matrix of minors of the matrix: ");
					Matrix.printMatrix(matrices.get(mat));
					System.out.println("is: ");
					matrices.add(Matrix.matrixOfMinors(matrices.get(mat)));
					Matrix.printMatrix(matrices.get(i));
					break;
			}
		}
	}
	
	public static void printOperations(String[] operation)
	{
		for(int i = 0; i < operation.length; i++)
		{
			System.out.println(i + ": " + operation[i]);
		}
	}
	
	public static void printAllMatrices(ArrayList<double[][]> matrices)
	{
		for(int i = 0; i < matrices.size(); i++)
		{
			System.out.println("Matrix number " + i);
			Matrix.printMatrix(matrices.get(i));
			System.out.println("");
		}
	}
}
