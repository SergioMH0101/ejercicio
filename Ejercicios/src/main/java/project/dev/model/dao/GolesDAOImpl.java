package project.dev.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.dev.model.dto.GolesDTO;


@Repository
@Transactional
public class GolesDAOImpl implements GolesDAO{
	private String list = "SELECT jug_rut, jug_nombre, equ_cod, gol_cantidad FROM goles g, jugador j, equipo e ORDER BY equ_cod";
	private String get = "SELECT j.jug_rut, j.jug_nombre, e.equ_cod, g.gol_cantidad " +
			"FROM goles g, jugador j, equipo e " +
			" WHERE e.equ_cod=? and j.jug_rut=g.jug_rut ORDER BY e.equ_cod";
	private String insert = "INSERT INTO jobs VALUES (?,?,?,?)";
	private String update = "UPDATE goles SET gol_cantidad=? WHERE jug_rut=?";
	private String delete = "DELETE jobs WHERE job_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public List<GolesDTO> list() {
		List<GolesDTO> listGolesDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(GolesDTO.class));
		return listGolesDTO;
	}

	@Override
	public List<GolesDTO> get(int equ_cod) {
	    Object[] args = {equ_cod};
	    List<GolesDTO> golesDTO;
	    
	    try {
	    	golesDTO = jdbcTemplate.query(get,args,BeanPropertyRowMapper.newInstance(GolesDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	golesDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	golesDTO=null;
	    	e.printStackTrace();
	    }
	    return golesDTO;
	}

	@Override
	public int insert(GolesDTO notasDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GolesDTO golesDTO) {
		int rows = 0;
	    Object[] args = {
	    		golesDTO.getJug_rut(),
	    		golesDTO.getGol_cantidad()
	    };
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public int delete(int alumno_rut) {
		// TODO Auto-generated method stub
		return 0;
	}

}
