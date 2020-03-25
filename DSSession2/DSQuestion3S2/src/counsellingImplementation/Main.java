/*
 * @author - Kritika Sharma
 * @date - 25-03-2020
 */
package counsellingImplementation;

public class Main {
	public static void main(String args[]){
		try{
			CounsellingClass counsellor = new CounsellingClass();
			counsellor.allocatePrograms();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
