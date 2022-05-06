package com.edu.ifms.ordem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ifms.ordem.dto.TecnicoDTO;
import com.edu.ifms.ordem.services.TecnicoService;

@RestController
@RequestMapping(value ="/tecnicos")
public class TecnicoResource {
	@Autowired
	private TecnicoService service;
	
	@GetMapping
	public ResponseEntity<Page<TecnicoDTO>> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , orderBy);
		
		
		Page<TecnicoDTO> list = service.findAllPage(pageRequest);	
		return ResponseEntity.ok().body(list);
	}
	
	//@GetMapping
	//public ResponseEntity<List<TecnicoDTO>> findAll(){
	//	List<TecnicoDTO> list = service.findAll();	
	//	return ResponseEntity.ok().body(list);
	//}
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id){
	TecnicoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDTO> insert(@RequestBody TecnicoDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok().body(dto);
	}
}
