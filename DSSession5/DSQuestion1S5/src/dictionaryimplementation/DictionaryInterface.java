package dictionaryimplementation;

import java.util.List;

public interface DictionaryInterface {

	//function to add key value pair to the dictionary
	void addElementToDictionary (Element element) throws Exception;
	
	//function to get value of a key from dictionary
	String getValueOfKey(String key) throws Exception;
	
	//function to sort key value pairs
	List<Element> sortKeyValuePairs();
	
	//function to display dictionary
	void show() throws Exception;
	
	//function to delete element from the dictioanry
	void deleteElement(String key) throws Exception;
	
	//function to sort key value pairs between two given keys
	List<Element> sortKeyValuePairsOnCondition(String firstKey, String secondKey) throws Exception;
}
