import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeScreenTest {
 
	//Test for Adding circle to screen
	@Test
	public void testAddShape1() throws Exception {
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		Boolean size = screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list); 
		assertTrue(size);
	}

	//Test for adding rectangle to screen
	@Test
	public void testAddShape2() throws Exception {
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Boolean size = screen.addShapeToScreen(new Point(10,10),Shape.shapeType.RECTANGLE, list); 
		assertTrue(size);
	}

	//Test for adding triangle to screen
	@Test
	public void testAddShape3() throws Exception {
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		Boolean size = screen.addShapeToScreen(new Point(50,50),Shape.shapeType.TRIANGLE, list); 
		assertTrue(size);
	}

	//Test for adding square to screen
	@Test
	public void testAddShape4() throws Exception {
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Boolean size = screen.addShapeToScreen(new Point(80,80),Shape.shapeType.SQUARE, list); 
		assertTrue(size);
	}

	//Test for deleting a shape
	@Test
	public void testDeleteShape() throws Exception{
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list); 
		Boolean size = screen.removeShape(new Point(2,2), Shape.shapeType.CIRCLE);
		assertTrue(size);
		
	}
	
	//Test for deleting all shapes of a type.
	@Test
	public void testAllDeleteShape() throws Exception {
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list);
		screen.addShapeToScreen(new Point(5,6),Shape.shapeType.SQUARE, list);
		screen.addShapeToScreen(new Point(40,40),Shape.shapeType.SQUARE, list);
		screen.addShapeToScreen(new Point(25,26),Shape.shapeType.CIRCLE, list);
		Boolean size = screen.removeAllShapes(Shape.shapeType.SQUARE);
		assertTrue(size);
	}

	@Test
	public void testAscendingInArea() throws Exception {
		Screen screen = new Screen();
		List<Shape> sortedShape = new ArrayList<Shape>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(7);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		screen.addShapeToScreen(new Point(5,6),Shape.shapeType.SQUARE, list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(7);
		screen.addShapeToScreen(new Point(40,40),Shape.shapeType.SQUARE, list3);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(14);
		screen.addShapeToScreen(new Point(25,26),Shape.shapeType.CIRCLE, list4);

		sortedShape.add(screen.listOfShapes.get(1));
		sortedShape.add(screen.listOfShapes.get(2));
		sortedShape.add(screen.listOfShapes.get(0));
		sortedShape.add(screen.listOfShapes.get(3));
		assertEquals(sortedShape, screen.sortOnArea());
	}

	@Test
	public void testAscendingInPerimeter() throws Exception {
		Screen screen = new Screen();
		List<Shape> sortedShape = new ArrayList<Shape>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(7);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		screen.addShapeToScreen(new Point(5,6),Shape.shapeType.SQUARE, list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(7);
		screen.addShapeToScreen(new Point(40,40),Shape.shapeType.SQUARE, list3);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(14);
		screen.addShapeToScreen(new Point(25,26),Shape.shapeType.CIRCLE, list4);
		sortedShape.add(screen.listOfShapes.get(1));
		sortedShape.add(screen.listOfShapes.get(2));
		sortedShape.add(screen.listOfShapes.get(0));
		sortedShape.add(screen.listOfShapes.get(3));
		assertEquals(sortedShape, screen.sortOnPerimeter());
	}

	@Test
	public void testAscendingInTimeStamp() throws Exception {
		Screen screen = new Screen();
		List<Shape> sortedShape = new ArrayList<Shape>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(7);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		screen.addShapeToScreen(new Point(5,6),Shape.shapeType.SQUARE, list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(7);
		screen.addShapeToScreen(new Point(40,40),Shape.shapeType.SQUARE, list3);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(14);
		screen.addShapeToScreen(new Point(25,26),Shape.shapeType.CIRCLE, list4);
		sortedShape.add(screen.listOfShapes.get(0));
		sortedShape.add(screen.listOfShapes.get(1));
		sortedShape.add(screen.listOfShapes.get(2));
		sortedShape.add(screen.listOfShapes.get(3));
		assertEquals(sortedShape, screen.sortOnTimestamp());
	}
	
	@Test
	public void testAscendingInDistanceFromOrigin() throws Exception {
		Screen screen = new Screen();
		List<Shape> sortedShape = new ArrayList<Shape>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(7);
		screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		screen.addShapeToScreen(new Point(5,6),Shape.shapeType.SQUARE, list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(7);
		screen.addShapeToScreen(new Point(40,40),Shape.shapeType.SQUARE, list3);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(14);
		screen.addShapeToScreen(new Point(25,26),Shape.shapeType.CIRCLE, list4);
		sortedShape.add(screen.listOfShapes.get(0));
		sortedShape.add(screen.listOfShapes.get(1));
		sortedShape.add(screen.listOfShapes.get(3));
		sortedShape.add(screen.listOfShapes.get(2));
		assertEquals(sortedShape, screen.sortOnDistanceFromOrigin());
	}
	
	@Test
	public void testIsPointEnclosedSquare() throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		Square square = new Square(new Point(2,2), list);
		assertEquals(true, square.isPointEnclosed(new Point(3,4)));
		
	}

	@Test
	public void testIsPointEnclosedRectangle() throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		Square square = new Square(new Point(2,2), list);
		assertEquals(true, square.isPointEnclosed(new Point(3,4)));
		
	}
 
	@Test
	public void testException1(){
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			screen.addShapeToScreen(new Point(2,2),Shape.shapeType.CIRCLE, list); 
		}
		catch(Exception e){
			assertEquals("Dimensions not given.", e.getMessage());
		}
	}

	@Test
	public void testException2(){
		Screen screen = new Screen();
		Point point = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		try{
			screen.addShapeToScreen(point,Shape.shapeType.CIRCLE, list); 
		}
		catch(Exception e){
			assertEquals("Point invalid.", e.getMessage());
		}
	}

	@Test
	public void testException3(){
		Screen screen = new Screen();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		try{
			screen.removeShape(new Point(2,2),Shape.shapeType.CIRCLE); 
		}
		catch(Exception e){
			assertEquals("List is already empty.", e.getMessage());
		}
	}
	
}
