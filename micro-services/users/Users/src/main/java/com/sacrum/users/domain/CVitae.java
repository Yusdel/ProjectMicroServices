package com.sacrum.users.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class CVitae implements Serializable{
	
	private static final long serialVersionUID = 751733571724458520L;

	private Long cvitaeID;
	private String introduction;
}
