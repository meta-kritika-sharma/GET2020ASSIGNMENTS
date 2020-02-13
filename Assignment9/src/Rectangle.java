import java.util.Date;
import java.util.List;

public class Rectangle implements Shape {

	private Point originOfShape;
	private int lengthOfRectangle;
	private int breadthOfRectangle;
	private Date timeStamp;

	public Rectangle(Point originOfShape, List<Integer> dimensionOfRectangle) throws Exception {
		// Constructor for initialization of values.
		
		if (dimensionOfRectangle.size() == 0){
			throw new Exception ("Dimensions not given.");
		}
		
		this.timeStamp = new Date();
		this.originOfShape = originOfShape;
		this.lengthOfRectangle = dimensionOfRectangle.get(0);
		this.breadthOfRectangle = dimensionOfRectangle.get(1);
	}

	@Override
	public shapeType getTypeOfShape() {
		// Method to return type of shape
		
		return shapeType.RECTANGLE;
	}

	@Override
	public float getArea() {
		// Method to return area of shape
		
		return lengthOfRectangle * breadthOfRectangle;
	}

	@Override
	public float getPerimeter() {
		// Method to return perimeter of shape.
		
		return 2 * (lengthOfRectangle + breadthOfRectangle);
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
		
		if (point.x_coordinate >= originOfShape.x_coordinate
				&& point.x_coordinate <= (originOfShape.x_coordinate)
						+ lengthOfRectangle) {
			if (point.y_coordinate >= originOfShape.y_coordinate
					&& point.y_coordinate <= (originOfShape.y_coordinate)
							+ breadthOfRectangle) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Point getOrigin() {
		//Method to return origin of shape.
		
		return originOfShape;
	}

	@Override
	public Date getTimeStamp() {
		// Method to return timestamp of shape.
		
		return timeStamp;
	}

	@Override
	public float getDistnceFromOriginOfScreen() {
		// Method to return distance from origin of the shape.
		
		return (float) Math.sqrt(Math.pow(originOfShape.x_coordinate, 2)
				+ Math.pow(originOfShape.y_coordinate, 2));
	}
}
