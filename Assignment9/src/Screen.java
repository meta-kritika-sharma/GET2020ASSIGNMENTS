import java.util.ArrayList;
import java.util.List;
 
public class Screen {
	
	/** The list of shapes. */
	ArrayList<Shape> listOfShapes = new ArrayList<>();

	public Boolean addShapeToScreen(Point point, Shape.shapeType shape,
			ArrayList<Integer> dimensionsOfShape) throws Exception {
		
		/**
		 * Adds the shape to screen.
		 *
		 * @param point the coordinates of shape.
		 * @param shape to be added.
		 * @param dimensionsOfShape the dimensions of shape
		 * @return true if shape successfully added, false otherwise.
		 */
		
		if (Factory.createShapeObject(shape, point,
				dimensionsOfShape) == null){
			throw new Exception("Object not created.");
		}
  		if (listOfShapes.add(Factory.createShapeObject(shape, point,
				dimensionsOfShape))) {
 			return true;
		}
  		
  		return false;
	}

	public Boolean removeShape(Point point, Shape.shapeType shapeType) throws Exception {
		/**
		 * Removes the shape.
		 *
		 * @param point the coordinates of shape.
		 * @param shape to be removed.
		 * @return true if shape successfully removed, false otherwise.
		 */
		if (listOfShapes.size() == 0){
			throw new Exception ("List is already empty.");
		}
 		for (int iterator = 0; iterator < listOfShapes.size(); iterator++) {
  			if (listOfShapes.get(iterator).getTypeOfShape() == shapeType && point.x_coordinate == listOfShapes.get(iterator).getOrigin().getXCoordinate() && 
  					point.y_coordinate == listOfShapes.get(iterator).getOrigin().getYCoordinate()) {
	 			listOfShapes.remove(listOfShapes.get(iterator));
	 			return true;
			}
		}

		return false;
	}

	public Boolean removeAllShapes(Shape.shapeType shape) {
		/**
		 * Removes all the shapes of a given type.
		 *
		 * @param shape the shape to be removed
		 * @return the boolean true if removed successfully.
		 */

 		int iterator = 0;
 		while (iterator < listOfShapes.size()) {
 			if (listOfShapes.get(iterator).getTypeOfShape() == shape) {
				listOfShapes.remove(listOfShapes.get(iterator));
				iterator = iterator - 1;
 			}
			iterator++;
 		}
  		return true;
	}

	public ArrayList<Shape> sortOnArea() {
		/**
		 * Sort the shapes based on area.
		 *
		 * @return the sorted array list
		 */

		ArrayList<Shape> sortedList = (ArrayList<Shape>) listOfShapes.clone();

		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = 0; j < sortedList.size() - 1; j++) {
				if (sortedList.get(j).getArea() > sortedList.get(j + 1)
						.getArea()) {
					Shape temporary = sortedList.get(j + 1);
					sortedList.set(j + 1, sortedList.get(j));
					sortedList.set(j, temporary);
				}
			}
		}
		return sortedList;
	}

 	public ArrayList<Shape> sortOnPerimeter() {
		/**
		 * Sort the shapes based on perimeter.
		 *
		 * @return the sorted array list
		 */

		ArrayList<Shape> sortedList = (ArrayList<Shape>) listOfShapes.clone();

		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = 0; j < sortedList.size() - 1; j++) {
				if (sortedList.get(j).getPerimeter() > sortedList.get(j + 1)
						.getPerimeter()) {
					Shape temporary = sortedList.get(j + 1);
					sortedList.set(j + 1, sortedList.get(j));
					sortedList.set(j, temporary);
				}
			}
		}
		return sortedList;
	}

 	public ArrayList<Shape> sortOnTimestamp() {
		/**
		 * Sort the shapes based on time stamp.
		 *
		 * @return the sorted array list
		 */

		ArrayList<Shape> sortedList = (ArrayList<Shape>) listOfShapes.clone();

		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = 0; j < sortedList.size() - 1; j++) {
				if (sortedList.get(j).getTimeStamp()
						.compareTo(sortedList.get(j + 1).getTimeStamp()) > 0) {
					Shape temporary = sortedList.get(j + 1);
					sortedList.set(j + 1, sortedList.get(j));
					sortedList.set(j, temporary);
				}
			}
		}
		return sortedList;
	}
 
	public ArrayList<Shape> sortOnDistanceFromOrigin() {
		/**
		 * Sort the shapes based on distance from origin.
		 *
		 * @return the sorted array list
		 */

		ArrayList<Shape> sortedList = (ArrayList<Shape>) listOfShapes.clone();

		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = 0; j < sortedList.size() - 1; j++) {
				if (sortedList.get(j).getDistnceFromOriginOfScreen() > sortedList
						.get(j + 1).getDistnceFromOriginOfScreen()) {
					Shape temporary = sortedList.get(j + 1);
					sortedList.set(j + 1, sortedList.get(j));
					sortedList.set(j, temporary);
				}
			}
		}
		return sortedList;
	}

	public ArrayList<Shape> shapesEnclosingPoint(Point point) throws Exception {
		/**
		 * To determine if the Shape encloses the given point.
		 *
		 * @param point the point
		 * @return the array list
		 */

		ArrayList<Shape> enclosingAPointList = new ArrayList<>();
		for (Shape iterator : enclosingAPointList) {
			if (iterator.isPointEnclosed(point)) {
				enclosingAPointList.add(iterator);
			}
		}
		return enclosingAPointList;
	}
	
}