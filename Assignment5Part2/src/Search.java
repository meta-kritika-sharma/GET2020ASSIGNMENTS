import java.util.*;

public class Search {
	
	public static int linearSearch(int[] userInputArray, int elementToBeSearched) throws Exception{
		/* Method to find the index of the element entered as input by the user.
		 * @param userInputArray is the array of elements in which the given element will be searched.
		 * @param elementToBeSearched is the element whose index will be returned to the user.
		 * @return index of the element if found in the array else -1 will be returned.
		 * @throw exception if length of array is zero. 
		 */
		if (userInputArray.length == 0) {
			throw new Exception("Array is empty.");
		}
		int iterator =0;
		return linearSearch(userInputArray, elementToBeSearched, iterator);
	}
	
	private static int linearSearch(int[] userInputArray, int elementToBeSearched, int iterator) throws Exception{
		if ((userInputArray.length==1) && (userInputArray[0]==elementToBeSearched)){
			return 0;
		}
		if (userInputArray[iterator] == elementToBeSearched) {
			return iterator;
		} 
		else if (iterator <= userInputArray.length - 1) {
			iterator++;
			return linearSearch(userInputArray, elementToBeSearched, iterator);
		} 
		else {
			return -1;
		}
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
	
	public static void main(String args[]) throws Exception {
		Search object = new Search();
		int[] arr = new int[] {1,2,3,4};
		System.out.println(binarySearch(arr,5));
	}
}
