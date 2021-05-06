package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "club")
@Data
@NoArgsConstructor
@AllArgsConstructor
	public class Club {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(name = "name" , nullable = false, length= 100)
		@NotNull
		private String name;

		@Column(name = "address" , nullable = false, length = 300)
		@NotNull
		private String adresse;

		@Column(name = "city" , nullable = false, length = 10)
		@NotNull
		private String city;

		@Column(name = "zipCode" , nullable = false, length = 10)
		@NotNull
		private String zipCode;

		@Column(name = "mail" , nullable = false)
		@NotNull
		private String mail;

		@Column(name = "tel" , nullable = false)
		@NotNull
		private Number tel;

}
