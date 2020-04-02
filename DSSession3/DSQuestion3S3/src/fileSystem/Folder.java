package fileSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to implement a Folder 
 *
 */
public class Folder {
	private String name;
	private Folder parent;
	private Map<String, Folder> children;
	private Date createdAt;

	/**
	 * Constructor initializes folder name
	 * @param name
	 * @throws Exception if name is null or empty
	 */
	public Folder(String name) throws Exception {
		if (name == null || name.length() == 0) {
			throw new Exception("Folder Name required");
		}
		this.name = name;
		this.children = new HashMap<String, Folder>();
		this.createdAt = new Date();
	}

	/**
	 * Function to get name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Function to get parent folder
	 * @return parent
	 */
	public Folder getParent() {
		return this.parent;
	}

	/**
	 * Function to set parent folder
	 * @param parent
	 */
	public void setParent(Folder parent) {
		this.parent = parent;
	}

	/**
	 * Function to add new folder
	 * @param folderName
	 * @throws Exception
	 */
	public void addFolder(String folderName) throws Exception {
		if (this.children.get(folderName) == null) {
			Folder newFolder = new Folder(folderName);
			newFolder.setParent(this);
			this.children.put(folderName, newFolder);
			System.out.println("Folder " + folderName
					+ " created successfully!\n");
		} else {
			System.out.println("Folder with name " + folderName
					+ " already exists!\n");
		}
	}

	/**
	 * Function to find folder in children
	 * @param folderName
	 * @return
	 */
	public Folder findFolder(String folderName) {
		return this.children.get(folderName);
	}

	/**
	 * Function to display folder details
	 */
	private void display() {
		System.out.println(this.name + "\t" + this.children.size() + "\t\t"
				+ this.createdAt);
	}

	/**
	 * Function to list details of sub directories
	 */
	public void listSubDirectories() {
		if (this.children.size() == 0) {
			System.out.println(" -- Empty --");
		} else {
			System.out.println("Name\tSubfolders\tCreated At");
			for (Folder folder : this.children.values()) {
				folder.display();
			}
			System.out.println();
		}
	}

	/**
	 * Recursive function to print tree structure
	 * @param level of tree structure
	 */
	public void printTree(int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("---");
		}
		System.out.println(this.name);

		for (Folder folder : this.children.values()) {
			folder.printTree(level + 1);
		}
	}

	/**
	 * Function to return absolute path present folder
	 * @return absolute path
	 */
	public String getPath() {
		StringBuilder path = new StringBuilder();
		List<String> directories = new ArrayList<String>();
		Folder currentFolder = this;
		while (currentFolder != null) {
			directories.add(currentFolder.getName());
			currentFolder = currentFolder.getParent();
		}
		for (int i = directories.size() - 1; i >= 0; i--) {
			path.append(directories.get(i));
			if (i > 0) {
				path.append("\\");
			}
		}
		return path.toString();
	}

	/**
	 * Recursive function to find folder by name
	 * @param name
	 * @throws Exception if name is null or empty
	 */
	public void findFolderRecursively(String name) throws Exception {
		if (name == null || name.length() == 0) {
			throw new Exception("Name is required!");
		}
		Folder foundFolder = this.children.get(name);
		if (foundFolder != null) {
			System.out.println(foundFolder.getPath());
		}
		for (Folder folder : this.children.values()) {
			folder.findFolderRecursively(name);
		}
	}
}