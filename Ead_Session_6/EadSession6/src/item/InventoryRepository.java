package item;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class InventoryRepository.
 */
public class InventoryRepository {
	
List<Inventory> inventories;
	
	/**
	 * Instantiates a new inventory repository.
	 */
	public InventoryRepository()
	{		
		inventories=new ArrayList<>();
		Inventory object1=new Inventory();
		object1.setName("Apples");
		object1.setQuantity(3);
		
		Inventory object2=new Inventory();
		object2.setName("Oranges");
		object2.setQuantity(7);
		
		Inventory object3=new Inventory();
		object3.setName("Pomergranates");
		object3.setQuantity(55);
		
		inventories.add(object1);
		inventories.add(object2);
		inventories.add(object3);
		
	}
	
	/**
	 * Method to return list of items
	 *
	 * @return inventories is the list.
	 */
	public List<Inventory> getInventories()
	{
		return inventories;
	}
	
	/**
	 * Gets the inventory.
	 *
	 * @param name the name of item
	 * @return the inventory object
	 */
	public Inventory getInventory(String name)
	{
		for(Inventory iterator:inventories)
		{
			if(iterator.getName().compareTo(name)==0)
				return iterator;
		}
		return new Inventory();
	}
	
	/**
	 * Adding item to the list
	 *
	 * @param item the item to be added
	 */
	public void create(Inventory item)
	{
		inventories.add(item);
	}
	
	/**
	 * Update.
	 *
	 * @param item is the name of item
	 */
	public void update(Inventory item)
	{
		inventories.removeAll(inventories);
		inventories.add(item);		
	}
	
	/**
	 * Update one item from the list
	 *
	 * @param name the name of item
	 * @param object of item
	 * @return the inventory object
	 */
	
	public Inventory updateOne(String name,Inventory item)
	{
		for(Inventory iterator:inventories)
		{
			if(iterator.getName().compareTo(name)==0)
			{
				iterator.setName(item.getName());
				iterator.setQuantity(item.getQuantity());
				return iterator;
			}
				
		}
		return new Inventory();		
	}
	
	/**
	 * Delete one specific item
	 *
	 * @param name is the name of the item
	 */
	
	public void deleteOne(String name)
	{
		inventories.remove(getInventory(name));
	}

	/**
	 * Delete all objects from the inventory
	 */
	
	public void deleteAll() 
	{
		inventories.removeAll(inventories);		
	}

}
