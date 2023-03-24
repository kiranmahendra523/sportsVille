package com.deepak.sportsville.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="grounds")
@Getter
@Setter
@NoArgsConstructor
public class Ground {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )	
	private int groundId;
	
	private String groundName;
	
	private String groundDescrption;
	
	private int groundCostPerHour;
	
	private boolean avalibiltyType;
}