/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author francescdepuigguixe
 */
@Path("video/{videoId}")
public class VideoResource {

    
    Video videoDAO = new Video();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public VideoResource() {
    }

    /**
     * Retrieves representation of an instance of video.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getHtml(@PathParam("videoId") String videoId) {
        //TODO return proper representation object
        VideoModel video =videoDAO.getById(videoId);
        return Response.ok(video.getJSON(), MediaType.APPLICATION_JSON).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param videoId
     * @param content representation for the resource
     */
    @PUT
    @Path("/incrementViews")
    @Consumes(MediaType.TEXT_HTML)
    public Response putHtml(@PathParam("videoId") String videoId,String content) {
        videoDAO.addReproducciones(videoId);
        VideoModel video =videoDAO.getById(videoId);
        return Response.ok(video.getJSON(), MediaType.APPLICATION_JSON).build();
    }
}
