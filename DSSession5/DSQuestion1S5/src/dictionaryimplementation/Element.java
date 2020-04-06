package dictionaryimplementation;

//element class containing the key and value for the dictionary
public class Element {

	private String key;
	private String value;
	
	//constructor
	public Element(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	//getters and setters
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
