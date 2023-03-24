package com.deepak.sportsville.services;

import java.util.List;

import com.deepak.sportsville.payloads.GroundDto;

public interface GroundService {

	 GroundDto createGround(GroundDto groundDto);
	
	 void deleteGround(Integer groundId);
	 
	 GroundDto updateGround(GroundDto groundDto,Integer gorundId);
	 
	 GroundDto getSingleGround(Integer groundId);
	 
	 List<GroundDto> getAllGrounds();
 
}
