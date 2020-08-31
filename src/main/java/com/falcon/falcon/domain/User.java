package com.falcon.falcon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder(toBuilder = true)
@Table(name = "T_USER")
@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQ_USER", allocationSize = 1)
public class User extends PersistentEntity implements Serializable {

	private static final long serialVersionUID = 760789451910707748L;

	@Column(name = "NAME", length = 255, unique = true, nullable = false)
	private String name;
}
