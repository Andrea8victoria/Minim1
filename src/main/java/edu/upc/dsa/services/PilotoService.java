package edu.upc.dsa.services;


import edu.upc.dsa.DronesManager;
import edu.upc.dsa.DronesManagerImpl;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/pilotos", description = "Endpoint to Piloto Service")
@Path("/pilotos")
public class PilotoService {

    private DronesManager tm;

    public PilotoService() {
        this.tm = DronesManagerImpl.getInstance();
        if (tm.sizePiloto()==0) {
            this.tm.addPiloto("Paco", "Dann", 8);
            this.tm.addPiloto("Carlos", "Fonsi",3);
            this.tm.addPiloto("Juan", "Antonio",4);
        }
    }


////GET
    @GET
    @ApiOperation(value = "get all Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Piloto.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotos() {

        ArrayList<Piloto> pilotos = this.tm.getListaPilotos();

        GenericEntity<List<Piloto>> entity = new GenericEntity<List<Piloto>>(pilotos) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Piloto.class),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPiloto(@PathParam("id") String id) {
        Piloto t = this.tm.getPiloto(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @GET
    @ApiOperation(value = "get all Pilotos per flight hours", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/byhoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotosbyHoras() {

        List<Piloto> pilotos = this.tm.pilotobyhoras();
        GenericEntity<List<Piloto>> entity = new GenericEntity<List<Piloto>>(pilotos) {
        };
        return Response.status(201).entity(entity).build();

    }


////DELETE
    @DELETE
    @ApiOperation(value = "delete a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/{id}")
    public Response deletePiloto(@PathParam("id") String id) {
        Piloto t = this.tm.getPiloto(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deletePiloto(id);
        return Response.status(201).build();
    }


////PUT
    @PUT
    @ApiOperation(value = "update a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/")
    public Response updatePiloto(Piloto piloto) {

        Piloto t = this.tm.updatePiloto(piloto);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }


////POST
    @POST
    @ApiOperation(value = "create a new Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Piloto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPiloto(Piloto piloto) {

        if (piloto.getNombre()==null || piloto.getApellidos()==null)  return Response.status(500).entity(piloto).build();
        this.tm.addPiloto(piloto);
        return Response.status(201).entity(piloto).build();
    }

}