package book;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/InventoryResource")
public class InventoryResource {

	InventoryRepository repository = InventoryRepository.getInstance();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Inventory> getInventories() throws SQLException {
		
		//Method to return details of the inventory.
		repository.connection();
		return repository.information();
	}

	@GET
	@Path("/{title}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Inventory> getInventory(@PathParam("title") String name)
			throws SQLException {
		
		//Method to retrieve the book by its title.
		repository.connection();
		return repository.selectInformation(name);
	}

	@POST
	public void createInventory(Inventory object) throws SQLException,
			IOException {
		
		//Method to add a book.
		repository.connection();
		repository.setDataEmployee(object);
	}

	@PUT
	@Path("/{title}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void updateInventory(@PathParam("title") String name,
			Inventory object) throws SQLException, IOException {
		
		//Method to update details of book
		repository.connection();
		repository.updateBook(object, name);
	}

	@DELETE
	public void deleteInventory() throws SQLException {
		
		//Method to delete all the books
		repository.connection();
		repository.deleteAll();

	}

	@DELETE
	@Path("/{name}")
	public void deleteBook(@PathParam("name") int id) throws SQLException {
		
		//Method to delete a book by its id.
		repository.connection();
		repository.deleteBook(id);
	}

}
