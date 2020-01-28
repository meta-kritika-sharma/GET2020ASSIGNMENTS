import java.util.Date;
import java.util.List;

public class Circle implements Shape {

	private int radius;
	private Point originOfShape;
	private Date timeStamp;

	public Circle(Point originOfShape, List<Integer> dimensionOfCircle) throws Exception {
		/**
		 * Instantiates a new circle.
		 * @param originOfShape the origin of shape
		 * @param dimensionOfCircle is an array containing the dimensions of circle.
		 */
		if (dimensionOfCircle.size() == 0){
			throw new Exception ("Dimensions not given.");
		}

		this.radius = dimensionOfCircle.get(0);
		this.originOfShape = originOfShape;
		this.timeStamp = new Date();
	}

	@Override
	public Point getOrigin() {
		// Method to return the origin of shape.
		
		return originOfShape;
	}

	@Override
	public shapeType getTypeOfShape() {
		// Method to return the type of shape.
		
		return shapeType.CIRCLE;
	}

	@Override
	public float getArea() {
		// Method to return the area of shape.
		
		return (float) (Math.PI * radius * radius);
	}

	@Override
	public float getPerimeter() {
		// Method to return the perimeter of shape.
		
		return (float) (2 * Math.PI * radius);
	}

	private Point getCenter() {
		double slope = Math.atan(originOfShape.getYCoordinate() / originOfShape.getXCoordinate());
		//H^2 = B^2 + L^2
		double distOfOrigin = Math.sqrt(originOfShape.getYCoordinate() * originOfShape.getYCoordinate() + originOfShape.getXCoordinate() * originOfShape.getXCoordinate());
		double distOfCenter = radius + distOfOrigin;
		double xCoord = distOfCenter * Math.cos(slope);
		double yCoord = distOfCenter * Math.sin(slope);
		Point center = new Point(xCoord, yCoord);
		return center;
		}

	@Override
	public boolean isPointEnclosed(Point point) throws Exception {
		/* Method to check if a point is enclosed in a shape.
		 * @param point specifies the x and y coordinate.
		 * @return true if point lies within the shape and false otherwise.
		 */
		if (point == null) {
			throw new Exception("Point invalid");
		}

		Point centerOfCircle = getCenter();
		float temp1 = (float) Math.pow(
				(point.x_coordinate - centerOfCircle.x_coordinate), 2);
		float temp2 = (float) Math.pow(
				(point.y_coordinate - centerOfCircle.y_coordinate), 2);
		if ((Math.sqrt(temp1 + temp2)) >= (radius)) {
			return false;
		}

		return true;
	}

	@Override
	public Date getTimeStamp() {
		// Method to return the time stamp of shape.
		
		return timeStamp;
	}

	@Override
	public float getDistnceFromOriginOfScreen() {
		// Method to return distance from origin of the shape.
		
		return (float) Math.sqrt(Math.pow(originOfShape.x_coordinate, 2)
				+ Math.pow(originOfShape.y_coordinate, 2));
	}

}
