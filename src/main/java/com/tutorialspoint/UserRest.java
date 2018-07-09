package com.tutorialspoint;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserRest {
    UserDao userDao = new UserDao();
    // http://localhost:8080/RestFullEx3-1.0-SNAPSHOT/rest/users/get/3
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUsers(@PathParam("id") long id){
        return userDao.get(id);
    }
    // http://localhost:8080/RestFullEx3-1.0-SNAPSHOT/users/getAll
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return userDao.getAll();
    }
    // http://localhost:8080/RestFullEx3-1.0-SNAPSHOT/users/add/1/email/last_name/name/password?active=1&email=email&last_name=last_name&name=name&password=password
    @POST
    @Path("/add/{active}/{email}/{last_name}/{name}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(
            @PathParam("active") int active,
            @PathParam("email") String email,
            @PathParam("last_name") String last_name,
            @PathParam("name") String name,
            @PathParam("password") String password
            ){
        User user = new User();
        user.setActive(active);
        user.setEmail(email);
        user.setLast_name(last_name);
        user.setName(name);
        user.setPassword(password);
        return userDao.add(user);
    }
    // http://localhost:8080/RestFullEx3-1.0-SNAPSHOT/users/delete/1
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public List<User> deleteUser(@PathParam("id") long id){
        return userDao.delete(id);
    }
    // http://localhost:8080/RestFullEx3-1.0-SNAPSHOT/users/put/2/1/email/last_name/name/password
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/put/{id}/{active}/{email}/{last_name}/{name}/{password}")
//    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(
            @PathParam("id") long id,
            @PathParam("active") int active,
            @PathParam("email") String email,
            @PathParam("last_name") String last_name,
            @PathParam("name") String name,
            @PathParam("password") String password
    ) {
        return userDao.update(id,active,email,last_name,name,password);
    }
}
