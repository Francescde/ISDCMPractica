/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Video;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author francescdepuigguixe
 */
@WebService(serviceName = "VideoFilter")
public class VideoFilter {

    
    Video videoDAO = new Video();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "FilterByTitle")
    public List<Integer> FilterByTitle(@WebParam(name = "title") String title) {
        List<VideoModel> videos= videoDAO.getAll();
        ArrayList<Integer> videosReturned = new ArrayList<Integer>();
        for(VideoModel video : videos ){
            if(video.getTitulo().contains(title))
                videosReturned.add(video.getId());
        }
        return videosReturned;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "filterByYearAuthorAndTitle")
    public List<VideoModelResource> filterByYearAuthorAndTitle(@WebParam(name = "Year") Integer Year, @WebParam(name = "Author") String Author, @WebParam(name = "Title") String Title) {
        //TODO write your implementation code here:
        List<VideoModel> videos= videoDAO.getAll();
        List<VideoModelResource> videosReturned = new ArrayList<VideoModelResource>();
        for(VideoModel video : videos ){
            //System.out.println(video.getFechaCreacion().toLocalDate().getYear()+"  "+Year);
            //System.out.println(video.getFechaCreacion().toLocalDate().getYear()==Year);
                
            if( (Title==null || video.getTitulo().contains(Title)) &&
                    (Year==null || video.getFechaCreacion().toLocalDate().getYear()==Year) &&
                    (Author==null || video.getAutor().contains(Author))){
                videosReturned.add( new VideoModelResource(video));
            }
        }
        return videosReturned;
    }
}
