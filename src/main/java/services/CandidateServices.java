package services;

import entity.Candidate;
import model.Answer;
import provider.CandidateProvider;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("Presidencia")
public class CandidateServices {

    @GET
    @Path("Candidatos")
    @Produces("application/json")
    public Response getCandidates(){
        CandidateProvider prov = new CandidateProvider();
        try {
            ArrayList<Candidate> can = prov.getCanditates();
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(can).build();
        } catch (SQLException e) {
            Answer answer = new Answer("SQLException",e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(answer).build();
        } catch (ClassNotFoundException e) {
            Answer answer = new Answer("ClassNotFoundException",e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(answer).build();
        }
    }

    @PUT
    @Path("Resultados")
    @Produces("application/json")
    public Response putCandidates(Candidate candidate){
        CandidateProvider prov = new CandidateProvider();
        try {
            prov.UpdateVotes(candidate);
            Answer ans = new Answer("SUCCESS", "SUCCESS");
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(ans).build();
        } catch (SQLException e) {
            Answer answer = new Answer("SQLException",e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(answer).build();
        } catch (ClassNotFoundException e) {
            Answer answer = new Answer("ClassNotFoundException",e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(answer).build();
        }
    }



}
