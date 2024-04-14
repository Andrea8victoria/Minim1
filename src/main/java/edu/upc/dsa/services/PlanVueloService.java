package edu.upc.dsa.services;

import edu.upc.dsa.DronesManager;
import edu.upc.dsa.DronesManagerImpl;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;
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
import java.util.Stack;

@Api(value = "/planesVuelos", description = "Endpoint to PlanVuelo Service")
@Path("/planesVuelos")
public class PlanVueloService {

    private DronesManager tm;

    public PlanVueloService() {
        this.tm = DronesManagerImpl.getInstance();
        if (tm.sizePlanVuelo()==0) {
            this.tm.addPlanVuelo(this.tm.findAll().get(0).getId(), "15/05/2003+15:00", "4", "Barcelona", "Roma", this.tm.getListaPilotos().get(0).getNombre());
            this.tm.addPlanVuelo(this.tm.findAll().get(1).getId(), "1/08/2021+16:00", "8", "Lisboa","Oslo", this.tm.getListaPilotos().get(1).getNombre());
            this.tm.addPlanVuelo(this.tm.findAll().get(2).getId(), "5/06/2023+17:00", "2", "Madrid","Paris", this.tm.getListaPilotos().get(2).getNombre());
        }
    }



////GET
    @GET
    @ApiOperation(value = "get all PlanesVuelos", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PlanVuelo.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanesVuelos() {

        ArrayList<PlanVuelo> planesVuelos = this.tm.getPlanesVuelos();

        GenericEntity<List<PlanVuelo>> entity = new GenericEntity<List<PlanVuelo>>(planesVuelos) {};
        return Response.status(201).entity(entity).build()  ;

    }



////ADD
    @POST
    @ApiOperation(value = "create a new PlanVuelo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= PlanVuelo.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPlanVuelo(PlanVuelo plan) {

        if (plan.getFecha()==null || plan.getOrigen()==null || plan.getDestino()==null|| plan.getPiloto()==null)  return Response.status(500).entity(plan).build();
        this.tm.addPlanVuelo(plan);
        return Response.status(201).entity(plan).build();
    }

}
