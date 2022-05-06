package com.edu.ifms.ordem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.ifms.ordem.dto.TecnicoDTO;
import com.edu.ifms.ordem.entities.Tecnico;
import com.edu.ifms.ordem.repositories.TecnicoRepository;
import com.edu.ifms.ordem.services.exceptions.EntityNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	
	private TecnicoRepository repository;
	@Transactional(readOnly = true)
	public List<TecnicoDTO> findAll(){
		List<Tecnico> list = repository.findAll();
//		List<TecnicoDTO> listDto = new ArrayList<>();
		
//		for(Tecnico t : list) {
//			listDto.add(new TecnicoDTO(t));
//		}
//		return listDto;	
		return list.stream().map(t -> new TecnicoDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional
	public TecnicoDTO findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		Tecnico entity = obj.orElseThrow(() -> new EntityNotFoundException("A entidade consultada não foi localizada"));
		return new TecnicoDTO(entity);
	}
	
	@Transactional
	public TecnicoDTO insert(TecnicoDTO dto) {
		Tecnico entity = new Tecnico();
		entity.setNome(dto.getNome());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		entity = repository.save(entity);
		return new TecnicoDTO(entity);
	}
	@Transactional(readOnly = true)
	public Page<TecnicoDTO> findAllPage(Object pageRequest) {
		Page<Tecnico> list = repository.findAll(pageRequest);
		return list.map(x -> new TecnicoDTO(x));
	}
}
