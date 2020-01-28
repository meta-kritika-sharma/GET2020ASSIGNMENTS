import java.util.ArrayList;
import java.util.List;

/* Class to create objects of different shapes at one place*/
public class Factory {

	public static Shape createShapeObject(Shape.shapeType type, Point point, List<Integer> dimensionsOfShape) throws Exception{
		/* Method to create objects of different shapes.
		 * @param type is of enum type created in shape class to define the type of shape for which object is to be created.
		 * @param point represents the coordinates.
		 * @param dimensionsOfShape contains the dimensions of the shape.
		 * @return shape object.
		 */
		
		Shape shapeObject = null;
		 
		if (type == Shape.shapeType.RECTANGLE){
			shapeObject = new Rectangle(point, dimensionsOfShape);
		}
		if (type== Shape.shapeType.TRIANGLE){
			shapeObject = new Triangle(point, dimensionsOfShape);
		}
		if (type== Shape.shapeType.SQUARE){
			shapeObject = new Square(point, dimensionsOfShape);
		}
		else if (type == Shape.shapeType.CIRCLE){
			 
			shapeObject = new Circle(point, dimensionsOfShape);
		}
		else{
			
		}
		return shapeObject;
	}

}
