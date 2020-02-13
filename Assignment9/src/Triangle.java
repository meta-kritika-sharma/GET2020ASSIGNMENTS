import java.util.Date;
import java.util.List;

public class Triangle implements Shape {

	 
	int firstSideOfTriangle;
	int secondSideOfTriangle;
	int thirdSideOfTriangle;
	int heightOfTriangle;
	Point originOfShape;
	Date timeStamp;

	public Triangle(Point originOfShape, List<Integer> dimensionOfTriangle) throws Exception {
		/**
		 * Instantiates a new triangle.
		 * @param originOfShape the origin of shape
		 * @param dimensionOfTriangle is an array containing the dimensions of triangle
		 */
		
		if (dimensionOfTriangle.size() == 0){
			throw new Exception ("Dimensions not given.");
		}

		this.timeStamp = new Date();
		this.firstSideOfTriangle = dimensionOfTriangle.get(0);
		this.secondSideOfTriangle = dimensionOfTriangle.get(1);
		this.thirdSideOfTriangle = dimensionOfTriangle.get(2);
		this.heightOfTriangle = dimensionOfTriangle.get(3);
		this.originOfShape = originOfShape;
	}

 	@Override
	public shapeType getTypeOfShape() {
 		// Method to return type of the shape.
		
 		return shapeType.TRIANGLE;
	}

 	@Override
	public float getArea() {
		// Calculation of area using heron's formula and return it.
		
 		float semiPerimeter = getPerimeter() / 2;
		return (float) Math.sqrt(semiPerimeter
				* (semiPerimeter - firstSideOfTriangle)
				* (semiPerimeter - secondSideOfTriangle)
				* (semiPerimeter - thirdSideOfTriangle));
	}

	public float getArea(double side1, double side2, double side3) {
		// Calculation of area using parameters.
		
		double semiperimeter = (side1 + side2 + side3) / 2;
		return (float) Math.sqrt(semiperimeter * (semiperimeter - side1)
				* (semiperimeter - side2) * (semiperimeter - side3));
	}

 	@Override
	public float getPerimeter() {
 		// Method to return perimeter of the shape.
 		
 		return (firstSideOfTriangle + secondSideOfTriangle + thirdSideOfTriangle);
	}

 	@Override
	public boolean isPointEnclosed(Point point) throws Exception {
		/* Method to check if a point is enclosed in a shape.
		 * @param point specifies the x and y coordinate.
		 * @return true if point lies within the shape and false otherwise.
		 */
 		
		if (point == null) {
			throw new Exception("Point not valid.");
		}

		// finding the remaining two vertices of triangle.
		Point point1 = null;
		point1.x_coordinate = originOfShape.x_coordinate;
		point1.y_coordinate = originOfShape.y_coordinate;
		Point point2 = null;
		point2.x_coordinate = originOfShape.x_coordinate + firstSideOfTriangle;
		point2.y_coordinate = originOfShape.y_coordinate;
		Point point3 = null;
		point3.x_coordinate =  (int) (distanceBetwwenTwoCoordinates(point1,
				point2) / 2);
		point3.y_coordinate = heightOfTriangle;

		double distanceFromFirstVertex = distanceBetwwenTwoCoordinates(point1,
				point);
		double distanceFromSecondVertex = distanceBetwwenTwoCoordinates(point2,
				point);
		double distanceFromThirdVertex = distanceBetwwenTwoCoordinates(point3,
				point);

		double areaOfPart1 = getArea(distanceFromFirstVertex,
				distanceFromSecondVertex, firstSideOfTriangle);
		double areaOfPart2 = getArea(distanceFromSecondVertex,
				secondSideOfTriangle, distanceFromThirdVertex);
		double areaOfPart3 = getArea(distanceFromThirdVertex,
				thirdSideOfTriangle, distanceFromSecondVertex);

		if ((areaOfPart1 + areaOfPart2 + areaOfPart3) <= (getArea())) {
			return true;
		}
		return false;
	}

	public double distanceBetwwenTwoCoordinates(Point point1, Point point2) {
		double distance;
		double temporaryResult1 = Math.pow(point2.x_coordinate
				- point1.x_coordinate, 2);
		double temporaryResult2 = Math.pow(point2.y_coordinate
				- point1.y_coordinate, 2);
		distance = Math.sqrt(temporaryResult2 + temporaryResult1);
		return distance;
	}

 	@Override
	public Point getOrigin() {
 		// Method to return distance from origin of the shape.
		
 		return originOfShape;
	}
 
	@Override
	public Date getTimeStamp() {
		// Method to return timestamp of the shape.
		
		return timeStamp;
	}

 	@Override
	public float getDistnceFromOriginOfScreen() {
 		// Method to return distance from origin of the shape.
 		
		return (float) Math.sqrt(Math.pow(originOfShape.x_coordinate, 2)
				+ Math.pow(originOfShape.y_coordinate, 2));
	}

}
