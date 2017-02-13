package cn.yun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.yun.po.Student;

public interface StudentService {
	@GET
	@Path("/student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Student getStudentById(@PathParam(value="id") int studentId);
}
