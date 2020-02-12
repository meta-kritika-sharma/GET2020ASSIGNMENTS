package item;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class InventoryResource {

	InventoryRepository repositoryObject = new InventoryRepository();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Inventory> getInventories() {
		
		//return the list of inventory items
		return repositoryObject.getInventories();
	}

	@GET
	@Path("/{name}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Inventory getInventory(@PathParam("name") String name) {
		
		//returns a particular inventory item object
		return repositoryObject.getInventory(name);
	}

	@POST
	public Inventory createInventory(Inventory item) {
		
		//adds an item to the list.
		repositoryObject.create(item);
		return item;
	}

	@PUT
	public List<Inventory> updateInventory(Inventory item) {
		
		//updates the list of items
		repositoryObject.update(item);
		return repositoryObject.getInventories();
	}

	@PUT
	@Path("/{name}")
	public Inventory updateOneInventory(@PathParam("name") String name,
			Inventory updateItem) {
		
		//updates a single item in the inventory
		Inventory item = repositoryObject.updateOne(name, updateItem);
		return item;
	}

	@DELETE
	public List<Inventory> deleteInventory() {
		
		//deletes all items from inventory
		repositoryObject.deleteAll();
		return repositoryObject.getInventories();
	}

	@DELETE
	@Path("/{name}")
	public Inventory deleteOneInventory(@PathParam("name") String name) {
		
		//delete a particular item from the inventory
		Inventory item = repositoryObject.getInventory(name);
		repositoryObject.deleteOne(name);
		return item;
	}
}
