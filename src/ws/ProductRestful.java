package ws;

import entities.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.*;

@Path("product")
public class ProductRestful {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findall")
	public Response findAll() {
		ProductModel pm = new ProductModel();
		return Response
				.ok()
				.entity(new GenericEntity<List<Product>>(pm.findAll()) {
				})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{id}")
	public Response find(@PathParam(value = "id") String id) {
		ProductModel pm = new ProductModel();
		Product p = pm.find(Integer.valueOf(id));
		if (p == null)
			return null;
		return Response
				.ok()
				.entity(new GenericEntity<Product>(p) {
				})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Product p) {
		ProductModel pm = new ProductModel();
		pm.create(p);
		return Response
				.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam(value = "id") String id) {
		ProductModel pm = new ProductModel();
		pm.delete(pm.find(Integer.valueOf(id)));
		return Response
				.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit")
	public Response edit(Product p) {
		ProductModel pm = new ProductModel();
		pm.update(p);
		return Response
				.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
}
