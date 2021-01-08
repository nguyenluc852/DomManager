package com.manager_dormitory.entity;

import javax.persistence.CascadeType;
import javax.persistence.*;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User  extends BaseEntity {
	 
	String name;
	String cmnd;
	String email;
	String password;
	String address;
	String date_of_birth;
	int dom_id;
	String token_firebase;
	String image;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();
	
}
