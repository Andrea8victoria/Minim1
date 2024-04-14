package edu.upc.dsa.services;


import edu.upc.dsa.DronesManager;
import edu.upc.dsa.DronesManagerImpl;
import edu.upc.dsa.models.Dron;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Stack;

@Api(value = "/drones", description = "Endpoint to Dron Service")
@Path("/drones")
public class DronesService {

    private DronesManager tm;

    public DronesService() {
        this.tm = DronesManagerImpl.getInstance();
        if (tm.size()==0) {
            this.tm.addDron("852","Dron8888", "Cisco", "4000", 7);
            this.tm.addDron("oodDD","Fast6400", "Huawei", "6400", 2);
            this.tm.addDron("TSGS5455", "Ultra8000", "Apple", "8000", 6);
        }
    }


////GET
    @GET
    @ApiOperation(value = "get all Drons", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrones() {

        List<Dron> drones = this.tm.findAll();

        GenericEntity<List<Dron>> entity = new GenericEntity<List<Dron>>(drones) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDron(@PathParam("id") String id) {
        Dron t = this.tm.getDrone(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @GET
    @ApiOperation(value = "get all Drons per flight hours", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/byhoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDronesbyHoras() {

        List<Dron> drones = this.tm.dronsbyhoras();
        GenericEntity<List<Dron>> entity = new GenericEntity<List<Dron>>(drones) {
        };
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get all Drons at Almacen", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/almacen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDronesAlmacen() {

        Stack<Dron> listaAlmacen = this.tm.getAlmacen();

        GenericEntity<Stack<Dron>> entity = new GenericEntity<Stack<Dron>>(listaAlmacen) {
        };
        return Response.status(201).entity(entity).build();

    }


////DELETE
    @DELETE
    @ApiOperation(value = "delete a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/{id}")
    public Response deleteDron(@PathParam("id") String id) {
        Dron t = this.tm.getDrone(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteDron(id);
        return Response.status(201).build();
    }

    @DELETE
    @ApiOperation(value = "repair Dron and delete the Dron from Almacen", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/almacen")
    public Response deleteDronAlmacen() {
        this.tm.deleteAlmacen();
        return Response.status(201).build();
    }


////PUT
    @PUT
    @ApiOperation(value = "update a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/")
    public Response updateDron(Dron dron) {

        Dron t = this.tm.updateDron(dron);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }


////POST
    @POST
    @ApiOperation(value = "create a new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDron(Dron dron) {

        if (dron.getNombre()==null || dron.getFabricante()==null)  return Response.status(500).entity(dron).build();
        this.tm.addDron(dron);
        return Response.status(201).entity(dron).build();
    }

    @POST
    @ApiOperation(value = "save in Almacen a new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/almacen/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDronAlmacen(@PathParam("id") String id) {

        Dron t = this.tm.getDrone(id);
        if (t == null) return Response.status(404).build();
        else this.tm.addAlmacen(id);
        return Response.status(201).build();
    }

}