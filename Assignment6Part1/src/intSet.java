/* @author Kritika Sharma
 * date 20-01-2020
 * The program implements the immutable class intSet using an array to represent a set of integers in the range 1-1000. It supports public methods like - 
 * Method to check whether x is a member of the set and return a boolean value.
 * Method to return the size of the set
 * Method to check whether a given set is a subset of the original set.
 * Method to return the complement set assuming that 1..1000 is the universal set
 * Method to return the union of two sets.
*/
import java.util.*;

public final class intSet {

	private int setOfNumbers[];
	private final int lowerBound = 0;
	
	public intSet(int[] userInputArray) throws Exception {
		/* Constructor method to initialize the values.
		 * @param userInputArray is the input given by the user.
		 * @throw exception when the array is empty. 
		 */
		
		if (userInputArray.length == 0) {
			throw new Exception("Array is empty.");
		}
		for (int i=0; i<userInputArray.length; i++){
			if ((userInputArray[i] < 0) || (userInputArray[i] > 1000)){
				throw new Exception ("Input Value should be between 0 and 1000");
			}
		}
		//Arrays.sort(userInputArray);
		int sizeOfSetOfNumbers = numberOfUniqueElements(userInputArray);
		//finding the number of unique elements in array. 
		this.setOfNumbers = new int[sizeOfSetOfNumbers+1];
		setOfNumbers = removeDuplicateElements(userInputArray,sizeOfSetOfNumbers+1);
	}

	public static int numberOfUniqueElements(int[] userGivenArray){
		/* Method to find number of unique elements in the array.
		 * @param userGivenArray is the input  given by the user.
		 * @return sizeOfSetOfNumbers is the size of the set after removal of duplicate elements.
		 */
		
		Arrays.sort(userGivenArray);
		int sizeOfSetOfNumbers = 0;
		for (int i = 0; i < userGivenArray.length - 1; i++) {
			if (userGivenArray[i] != userGivenArray[i + 1]) {
				 sizeOfSetOfNumbers++;
			}
		}
		return sizeOfSetOfNumbers;
	}
	
	public static int[] removeDuplicateElements(int[] userGivenArray, int sizeOfSet){
		/* Method to remove the duplicate elements from the array.
		 * @param userGivenArray is the input given by the user.
		 * @param sizeOfSet is the size of the set after removal of duplicate elements.
		 * @return the array after the removal of duplicate elements. 
		 */
		
		int indexOfSetOfNumbers = 0;
		int[] arrayAfterDuplicateRemoval = new int[sizeOfSet];
		
		//removing duplicate elements.
		for (int i = 0; i < userGivenArray.length - 1; i++) {
			if (userGivenArray[i] != userGivenArray[i + 1]) {
				arrayAfterDuplicateRemoval[indexOfSetOfNumbers] = userGivenArray[i];
 				indexOfSetOfNumbers++;
			}
		}
		if (indexOfSetOfNumbers<sizeOfSet){
		arrayAfterDuplicateRemoval[indexOfSetOfNumbers] = userGivenArray[userGivenArray.length - 1];
		indexOfSetOfNumbers++;
		}
		return arrayAfterDuplicateRemoval;
	}
	
	public static int binarySearch(int[] userInputArray, int elementToBeSearched)
			throws Exception {
		/* Method to find the index of the element entered as input by the user.
		 * @param userInputArray is the array of elements in which the given element will be searched.
		 * @param elementToBeSearched is the element whose index will be returned to the user.
		 * @return index of the element if found in the array else -1 will be returned.
		 * @throw exception if length of array is zero. 
		 */

		if (userInputArray.length == 0) {
			throw new Exception("Array is empty.");
		}
		int startIndex = 0;
		int endIndex = userInputArray.length - 1;
		return binarySearch(userInputArray, elementToBeSearched, startIndex,
				endIndex);
	}

	private static int binarySearch(int[] userInputArray, int elementToBeSearched,
			int lowIndex, int highIndex) {
		/* Helper method of Binary Search to find the index of the element entered as input by the user.
		 * @param userInputArray is the array of elements in which the given element will be searched.
		 * @param elementToBeSearched is the element whose index will be returned to the user.
		 * @param lowIndex is the starting index of the array.
		 * @param highIndex is the last index of the array.
		 * @return index of the element if found in the array else -1 will be returned.
		 * @throw exception if length of array is zero. 
		 */

		int midIndex = 0;
		if (highIndex >= lowIndex) {
			midIndex = lowIndex + (highIndex - lowIndex) / 2;
			if (userInputArray[midIndex] == elementToBeSearched) {
				return midIndex;
			} else if (userInputArray[midIndex] > elementToBeSearched) {
				return binarySearch(userInputArray, elementToBeSearched, lowIndex, midIndex - 1);
			} else {
				return binarySearch(userInputArray, elementToBeSearched, midIndex + 1, highIndex);
			}
		}
		return -1;
	
	}
	
	public Boolean isMember(int elementToBeChecked) throws Exception {
		/* Method to find whether an element is present in the set or not.
		 * @param elementToBeChecked is the element whose presence is to be checked.
		 * @return true if element is present and false otherwise.
		 */
		
		int resultOfBinarySearch = binarySearch(setOfNumbers, elementToBeChecked);
		if (resultOfBinarySearch == -1){
			return false;
		}
		else{
			return true;
		}
	}

	public int size() {
		/* Method to find the size of the set.
		 * @return setOfNumbers.length is the size of the set.
		 */
		
		return setOfNumbers.length;
	}

	public Boolean isSubSet(intSet smallSet) {
		/* Method to find if a given set is a subset of the original set.
		 * @param smallSet is the smaller set which is to be checked.
		 * @return true if given set is a subset else false.
		 */
		
		int i, j;
		if (smallSet.setOfNumbers.length > setOfNumbers.length) {
			return false;
		}
		for (i = 0, j = 0; i < smallSet.setOfNumbers.length
				&& j < setOfNumbers.length; i++) {
			while (smallSet.setOfNumbers[i] > setOfNumbers[j]) {
				j++;
				if (j >= setOfNumbers.length) {
					return false;
				}
			}
			if (smallSet.setOfNumbers[i] != setOfNumbers[j]) {
				return false;
			}
		}
		return true;
	}

	public int[] getComplement() throws Exception {
		/* Method to return the complement set of the given set assuming that [1..1000] is the universal set.
		 * @return the complement set.
		 * @throw exception if array is empty.
		 */
		final int upperBound = 1000;
		int indexOfComplementArray = 0;
		int flag = 0;
		int countOfElementInSmallerArray = 0;
		int[] complementArray = new int[upperBound - setOfNumbers.length + 1];
		for (int i = 0; i <= upperBound; i++) {
			if (countOfElementInSmallerArray<setOfNumbers.length){
				if (isMember(i)){
					countOfElementInSmallerArray++;
				}
				else{
					complementArray[indexOfComplementArray] = i;
					indexOfComplementArray++;
				}
			}
			else{
				complementArray[indexOfComplementArray] = i;
				indexOfComplementArray++;
			}
 		}
		return complementArray;
	}

	public static int[] union(intSet firstSet, intSet secondSet) {
		/* Method to return the union of two given sets.
		 * @param firstSet
		 * @param secondSet
		 * @return union of firstSet and secondSet.
		 */
		int sizeOfUnionArray = firstSet.setOfNumbers.length + secondSet.setOfNumbers.length;
		int indexOfUnionArray = 0;
		int[] unionSet = new int[sizeOfUnionArray];
		for (int i = 0; i < firstSet.setOfNumbers.length; i++) {
			unionSet[indexOfUnionArray] = firstSet.setOfNumbers[i];
			indexOfUnionArray++;
		}
		for (int j = 0; j < secondSet.setOfNumbers.length; j++) {
			unionSet[indexOfUnionArray] = secondSet.setOfNumbers[j];
			indexOfUnionArray++;
		}
 
		int sizeOfUnionSet = numberOfUniqueElements(unionSet);
		int[] unionSetFinal = new int[sizeOfUnionSet];
		Arrays.sort(unionSet);
		unionSetFinal = removeDuplicateElements(unionSet, sizeOfUnionSet+1);
 		return unionSetFinal;
	}

	public static void main(String args[]) throws Exception {
 		intSet arr2 = new intSet(new int[] { 1});
		intSet arr3 = new intSet(new int[] { 2});
		System.out.println("\nIs union result");
		int[] union = arr2.union(arr2, arr3);
		for (int i = 0; i < union.length; i++) {
			System.out.print(union[i]+" ");
		}
 	}

}
