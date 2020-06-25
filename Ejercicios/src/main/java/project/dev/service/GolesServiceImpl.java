package project.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dev.model.dao.GolesDAO;
import project.dev.model.dto.GolesDTO;


@Service
public class GolesServiceImpl implements GolesService{

	@Autowired
	GolesDAO golesDAO;
	
	@Override
	public List<GolesDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GolesDTO> get(int jug_rut) {
		return golesDAO.get(jug_rut);
	}

	@Override
	public int insert(GolesDTO golesDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GolesDTO golesDTO) {
		return golesDAO.update(golesDTO);
	}

	@Override
	public int delete(int jug_rut) {
		// TODO Auto-generated method stub
		return 0;
	}

}
