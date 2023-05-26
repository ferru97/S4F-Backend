package com.ferru97.s4f.user.microservice.model.entity;

import com.ferru97.s4f.user.microservice.constants.TablesNames;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TablesNames.USER_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "nickname", nullable = false, unique = true)
  private String nickname;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "birthday", nullable = false)
  private Date birthday;

  @Column(name = "active", nullable = false)
  private boolean active;

}
