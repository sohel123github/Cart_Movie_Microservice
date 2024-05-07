package com.cart.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String cart;

	transient private List<Movie> movie;

}
