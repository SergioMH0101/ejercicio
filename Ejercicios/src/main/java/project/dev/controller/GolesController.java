package project.dev.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import project.dev.model.dto.GolesDTO;
import project.dev.service.GolesService;

@RestController
@RequestMapping(value="/Goles")
public class GolesController {

	@Autowired
	GolesService golesService;
	
	
	@RequestMapping(value="/get")
	public List<GolesDTO> ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		List<GolesDTO> goles = golesService.get(Integer.parseInt(req.getParameter("equ_cod")));
		return goles;
	
	}
	@RequestMapping(value="/update")
	public  int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			GolesDTO g = new Gson().fromJson(requestData, GolesDTO.class);
			rows = golesService.update(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
}
