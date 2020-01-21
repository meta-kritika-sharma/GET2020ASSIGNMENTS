/*@author Kritika Sharma
 *@date 15-01-2020
 *The class Area is used to calculate areas for different shapes. It contains :
 *Method to return area of a Triangle.
 *Method to return area of a Rectangle.
 *Method to return area of a Square.
 *Method to return area of a Circle.
*/

import java.util.*;

public class Area {
	
	public double areaOfTriangle(double triangleBase, double triangleHeight){
		/* Method to calculate area of triangle
		 * @param triangleBase is a double type value of the base of triangle.
		 * @param triangleHeight is a double type value of the height of triangle
		 * @return the area of triangle as a double value.
		 */ 
		
		double triangleArea = 0.5 * triangleBase * triangleBase;
		return triangleArea;
	}
	
	public double areaOfRectangle(double rectangleWidth, double rectangleHeight){
		/* Method to calculate area of rectangle
		 * @param rectangleWidth is a double type value of the width of rectangle.
		 * @param rectangleHeight is a double type value of the height of rectangle.
		 * @return the area of rectangle as a double value.
		 */
		
		double rectangleArea = rectangleHeight * rectangleWidth;
		return rectangleArea;
	}

	public double areaOfSquare(double squareSide){
		/* Method to calculate area of square
		 * @param squareSide is a double type value of the side of square.
		 * @return the area of square as a double value.
		 */ 
		
		double squareArea = squareSide * squareSide;
		return squareArea;
	}

	public double areaOfCircle(double circleRadius){
		/* Method to calculate area of circle.
		 * @param circleRadius is a double type value of the radius of circle.
		 * @return the area of circle as a double value.
		 */ 
		
		double circleArea = ( 22.0 / 7 ) * circleRadius * circleRadius;
		return circleArea;
	}

	public void getUserChoice(){
		/* Method to get user choice and values for the shape for which area is to calculated.
		 * @throw exception when a string or character value is entered instead of expected integer value.
		 * @throw arithmetic exception
		 */
		System.out.println("Enter 1 to calculate area of triangle.");
		System.out.println("Enter 2 to calculate area of rectangle.");
		System.out.println("Enter 3 to calculate area of square.");
		System.out.println("Enter 4 to calculate area of circle.");
		int userChoice;
		int flag = 0;
		while (flag == 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice : ");
			try{
				userChoice = sc.nextInt();
				if (userChoice == 1){
					System.out.println("Enter base of the triangle :");
					double baseOfTriangle = sc.nextDouble();
					System.out.println("Enter height of the triangle :");
					double heightOfTriangle = sc.nextDouble();
					System.out.printf("Area of triangle = %.2f\n" , (areaOfTriangle(baseOfTriangle, heightOfTriangle)));
					
				}
				else if (userChoice == 2){
					System.out.println("Enter width of the rectangle :");
					double widthOfRectangle = sc.nextDouble();
					System.out.println("Enter height of the rectangle :");
					double heightOfRectangle = sc.nextDouble();
					System.out.printf("Area of rectangle = %.2f\n" , (areaOfRectangle(widthOfRectangle, heightOfRectangle)));
				}
				else if (userChoice == 3){
					System.out.println("Enter side of the square :");
					double sideOfSquare = sc.nextDouble();
					System.out.printf("Area of square = %.2f\n" , (areaOfSquare(sideOfSquare)));
				}
				else if (userChoice == 4){
					System.out.println("Enter radius of the circle :");
					double radiusOfCircle = sc.nextDouble();
					System.out.printf("Area of circle = %.2f\n" , (areaOfCircle(radiusOfCircle)));
				}
				else if (userChoice == 5){
					flag = 1;
				}
				else{
					System.out.println("Invalid choice.");
				}
			}
			catch (InputMismatchException e){
				System.out.println("Ïnvalid input");
			}
			catch(ArithmeticException e){
				System.out.println("Arithmetic Exception");			}
		}
	}
	
	public static void main(String args[]){
		Area object = new Area();
		object.getUserChoice();
	}
}
