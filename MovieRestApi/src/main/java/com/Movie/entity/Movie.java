package com.Movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // [GST HE..]
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;

	private int cartId;

}
