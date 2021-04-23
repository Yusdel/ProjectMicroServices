package com.sacrum.users.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Nation implements Serializable{
	
	private static final long serialVersionUID = 8749503142187851039L;

	private Long nationID;
	private String nation_name;
}
