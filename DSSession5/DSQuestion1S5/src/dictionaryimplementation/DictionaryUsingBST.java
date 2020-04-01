package dictionaryimplementation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONObject;


//dictionary class using binary search tree
public class DictionaryUsingBST implements DictionaryInterface{
	
	Node root;
	
	public DictionaryUsingBST(JSONObject object) throws Exception{
		if (object==null){
			throw new Exception ("Null data found");
		}
		
		for (Object entry : object.entrySet()){
			String key = (String)((Entry<?,?>)entry).getKey();
			String value = (String)((Entry<?,?>)entry).getValue();
			addElementToDictionary(new Element(key,value));
		}
	}

	/**
	 * function to add key value pairs to dictionary
	 * @element is the element object containing key and value to be added  
	 * @throws Exception if Object is null
	 */
	
	@Override
	public void addElementToDictionary(Element element) throws Exception {
		
		if (element==null){
			throw new Exception ("Null object passed");
		}

		Node newNode = new Node(element);
		
		//calling function to add node recursively
		this.root = addElement(root,newNode);
	}

	/**
	 * function to add element recursively
	 * @param currentRoot
	 * @param newNode
	 * @return node
	 */
	
	private Node addElement(Node currentRoot, Node newNode) {
		
		//if tree is empty
		if (currentRoot == null){
			currentRoot = newNode;
			return currentRoot;
		}
		
		// if element is greater than root
		if (currentRoot.getElement().getKey().compareTo(newNode.getElement().getKey()) < 0){
			currentRoot.setRightNode(addElement(currentRoot.getRightNode(),newNode));
		}
		
		//if element is smaller than root
		else if (currentRoot.getElement().getKey().compareTo(newNode.getElement().getKey()) > 0){
			currentRoot.setLeftNode(addElement(currentRoot.getLeftNode(),newNode));
		}
		
		return currentRoot;	
	}


	/**
	 * function to delete element from dictionary
	 * @throws Exception 
	 */
	@Override
	public void deleteElement(String key) throws Exception {
		if (key.trim().length()==0){
			throw new Exception ("Enter valid key");
		}
		this.root = deleteElement(this.root, key);
	}

	/**
	 * @param root
	 * @param key is the key in dictionary
	 * @return root
	 * @throws Exception if dictionary is empty
	 */
	private Node deleteElement(Node root, String key) throws Exception {
		
		//tree is empty
		if (root == null){
			throw new Exception ("Empty Dictionary");
		}
		
		if (key.compareTo(root.getElement().getKey()) < 0){
			
			root.setLeftNode(deleteElement(root.getLeftNode(), key));
		}
		
		else if (key.compareTo(root.getElement().getKey()) > 0) {
			root.setRightNode(deleteElement(root.getRightNode(), key));			
		}
		
		//node to be deleted encountered
		else{
			
			if ((root.getLeftNode()==null) && (root.getRightNode()==null)){
				root = null;
			}
			
			else if (root.getLeftNode()==null){
				root = root.getRightNode();
			}
			
			else if (root.getRightNode() ==null){
				root = root.getLeftNode();
			}
			
			else {
				root.setElement(minimumValue(root.getRightNode()));
				root.setRightNode(deleteElement(root.getRightNode(), root.getElement().getKey()));
			}
		} 
		return root;
	}

	/**
	 * function to find the minimum value
	 * @param root
	 * @return Element object having minimum key 
	 */
	
	private Element minimumValue(Node root) {
		String minimumKey = root.getElement().getKey();
		String minimumValue = root.getElement().getValue();
		while (root.getLeftNode()!=null){
			minimumKey = root.getElement().getKey();
			minimumValue = root.getElement().getValue();
			root = root.getLeftNode();
		}
		return new Element(minimumKey, minimumValue);
	}

	/**
	 * function to get value of a key from dictionary
	 * @throws Exception 
	 * @return value of key
	 * @param key is the string key
	 */
	
	@Override
	public String getValueOfKey(String key) throws Exception {
		
		if (key.trim().length()==0){
			throw new Exception ("Enter valid key");
		}
		String value = searchKey(root, key);
		return value;
	}

	/**
	 * function to search key in dictionary
	 * @param root
	 * @param key
	 * @return
	 * @throws Exception if key is not found
	 */
	private String searchKey(Node root, String key) throws Exception {
		if (root==null){
			throw new Exception ("Key Not found");
		}
		
		// if key is found
		if (root.getElement().getKey().equals(key)){
			return root.getElement().getValue();
		}

		// comparing key to the root element key
		if (root.getElement().getKey().compareTo(key) < 0){
			root = root.getRightNode();
			return searchKey(root,key);	
		}
		
		return searchKey(root.getLeftNode(),key);	
	}

	/**
	 * function to return sorted list
	 * @return sorted list
	 */
	
	@Override
	public List<Element> sortKeyValuePairs() {
		List<Element> sortedList = new ArrayList<Element>();
		sortedList = sortFunction(root,sortedList);
		return sortedList;
	}

	/**
	 * function to return sorted list through recursion
	 * @param root
	 * @param sortedList
	 * @return sorted list
	 */
	private List<Element> sortFunction(Node root, List<Element> sortedList) {
		if (root!=null){
		sortFunction(root.getLeftNode(), sortedList);
		System.out.println(root.getElement().getKey());
		sortedList.add(root.getElement());
		sortFunction(root.getRightNode(), sortedList);
		}
		return sortedList;
	}

	/**
	 * @return 
	 * @throws Exception 
	 * 
	 */
	
	@Override
	public List<Element> sortKeyValuePairsOnCondition(String firstKey, String secondKey) throws Exception {
		
		if ((firstKey.trim().length()==0) || (secondKey.trim().length()==0)){
			throw new Exception ("Enter valid keys");
		}
		List<Element> sortedList = sortKeyValuePairs();
		
		if (sortedList.size()==0){
			throw new Exception ("Empty Dictionary");
		}
		
		int iterator =0;
		int firstIndex =-1;
		int secondIndex=-1;
		
		// traversing through the list
		while (iterator<sortedList.size()){
			
			// finding index of first key
			if (sortedList.get(iterator).getKey().equals(firstKey)){
				firstIndex = iterator; 
			}
			
			//finding index of second key
			else if (sortedList.get(iterator).getKey().equals(secondKey)){
				secondIndex = iterator;
			}
			
			//when both indices arwe found
			if ((firstIndex!=-1) && (secondIndex!=-1)){
				break;
			}
			iterator++;
		}
		
		// if keys do not exist in dictionary
		if ((firstIndex==-1) || (secondIndex==-1)){
			throw new Exception ("Invalid keys");
		} 
		
		//returning list between two keys
		return sortedList.subList(firstIndex, secondIndex+1);
	}

	/**
	 * function to show 
	 */
	
	@Override
	public void show() throws Exception {
		inorder(this.root);
	}

	/**
	 * 
	 * @param root
	 * @throws Exception
	 */
	
	private void inorder(Node root) throws Exception {
		if (root!=null){
		inorder(root.getLeftNode());
		System.out.println(root.getElement().getKey());
		inorder(root.getRightNode());
		}
	}
	
	

}
