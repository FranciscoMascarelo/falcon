package com.falcon.falcon.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PersistentEntity implements Serializable {

	private static final long serialVersionUID = -6955927543497077668L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@CreationTimestamp
	@CreatedDate
	@Column(name = "CREATED_DATE", updatable = false, nullable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@LastModifiedDate
	@Column(name = "LAST_MODIFIED_DATE", nullable = false)
	private LocalDateTime lastModifiedDate;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version;

	@Transient
	public boolean isPersisted() {
		return !(getId() == null || getId().equals(0L));
	}

}
