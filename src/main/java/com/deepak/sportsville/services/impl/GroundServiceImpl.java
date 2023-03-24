package com.deepak.sportsville.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.sportsville.entities.Ground;
import com.deepak.sportsville.exceptions.ResourceNotFoundException;
import com.deepak.sportsville.payloads.GroundDto;
import com.deepak.sportsville.repositories.GroundRepo;
import com.deepak.sportsville.services.GroundService;

@Service
public class GroundServiceImpl implements GroundService {

	@Autowired
	private GroundRepo groundRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public GroundDto createGround(GroundDto groundDto) {
		Ground ground = this.modelMapper.map(groundDto,Ground.class);
		Ground savedGround = this.groundRepo.save(ground);
		return this.modelMapper.map(savedGround, GroundDto.class);
	}

	@Override
	public void deleteGround(Integer groundId) {
		Ground ground = this.groundRepo.findById(groundId).orElseThrow(()->new ResourceNotFoundException("GroundId","with gorundId:",groundId));
		this.groundRepo.delete(ground);
	}

	@Override
	public GroundDto updateGround(GroundDto groundDto,Integer groundId) {
		Ground ground = this.groundRepo.findById(groundId).orElseThrow(()->new ResourceNotFoundException("GroundId","with gorundId:",groundId));
		ground.setAvalibiltyType(groundDto.isAvalibiltyType());
		ground.setGroundCostPerHour(groundDto.getGroundCostPerHour());
		ground.setGroundDescrption(groundDto.getGroundDescrption());
		ground.setGroundName(groundDto.getGroundName());
		Ground savedGround = this.groundRepo.save(ground);
		return this.modelMapper.map(savedGround, GroundDto.class);
	}

	@Override
	public GroundDto getSingleGround(Integer groundId) {
		Ground ground = this.groundRepo.findById(groundId).orElseThrow(()->new ResourceNotFoundException("GroundId","with gorundId:",groundId));
		return this.modelMapper.map(ground, GroundDto.class);
	}

	@Override
	public List<GroundDto> getAllGrounds() {
		
		List<Ground> grounds = this.groundRepo.findAll();
		List<GroundDto> groundDtos = grounds.stream().map((ground) -> this.modelMapper.map(ground,GroundDto.class)).collect(Collectors.toList());
		return groundDtos;
	}

}
