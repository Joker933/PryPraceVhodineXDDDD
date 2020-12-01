package cz.educanet.weebik2;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {
    private static List<Uzivatel> names = new ArrayList<Uzivatel>();

    @GET
    public Response getAll() {

        return Response.ok(names).build();
    }

    @PUT
    @Path("/{jmeno}")
    public Response changeUzivatel(@PathParam("jmeno") String jmeno, @QueryParam("jmeno") String changedjmeno) {
        Uzivatel tempUzivatel = new Uzivatel(jmeno, "");
        if(doesUzivatelExist(tempUzivatel)){
            for(int i = 0; i < names.size(); i++) {
                if(names.get(i).getjmeno().equals(tempUzivatel.getjmeno())) {
                    names.get(i).setjmeno(changedjmeno);
                    return Response.ok(jmeno + " changed to " + changedjmeno).build();
                }
            }
        } else {
            return Response.ok("Uzivatel " + jmeno + " doesn't exist!").build();
        }

        return Response.serverError().build();
    }

    @POST
    public Response createUzivatel(@QueryParam("jmeno") String jmeno, @QueryParam("heslo") String heslo) {
        Uzivatel tempUzivatel = new Uzivatel(jmeno,heslo);
        if(doesUzivatelExist(tempUzivatel)){
            return Response.status(406).build();
        } else {
            names.add(tempUzivatel);
            return Response.ok("Uzivatel Created").build();
        }
    }

    public Boolean doesUzivatelExist(Uzivatel Uzivatel) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getjmeno().equals(Uzivatel.getjmeno())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @DELETE
    public Response removeUzivatel(Uzivatel Uzivatel) {
        if(doesUzivatelExist(Uzivatel)) {
            names.remove(Uzivatel);
            return Response.ok().build();
        } else {
            return Response.status(406).build();
        }
    }


}
