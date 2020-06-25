package project.dev.service;

import java.util.List;

import project.dev.model.dto.GolesDTO;

public interface GolesService {
	public List<GolesDTO> list();
	public List<GolesDTO> get(int jug_rut);
	public int insert(GolesDTO golesDTO);
	public int update(GolesDTO golesDTO);
	public int delete(int jug_rut);
}
