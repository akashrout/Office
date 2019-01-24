package com.akash.RestDemoJersey;

import java.util.Arrays;
import java.util.List;

//import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;

import com.akash.RestDemoJersey.repo.AlienRepository;

import javafx.scene.control.Alert;

@Path("aliens")
public class AlienResource {
	
	
	AlienRepository repo=new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON )
	public List<Alien> getAlien() {
		System.out.println("getAleannnnn");		
		
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/102")
	@Produces(MediaType.APPLICATION_XML )
	public Alien getAlienn() {
		return repo.getAlien(102);
	}
	
	@GET
	@Path("alien/db")
	@Produces(MediaType.APPLICATION_XML )
	public List<Alien> getAlienByDb() {
		return repo.getDbAlien();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON )
	public Alien getAliens( int id) {
		System.out.println("By id Called");
		return repo.getAlien(id);
	}
	
//	@GET
//	@Path("fromdb")
//	@Produces(MediaType.APPLICATION_JSON )
//	public Alien getAlienfromDB( int id) {
//		System.out.println("By id Called");
//		return repo.getDbAlien();
//	}
	
	@POST 
	@Path("aliendbbyid")
	public Alien createAlein(Alien a1) {
		System.out.println(a1);
		
		
		return a1;
		
		
	}
	
	

}
