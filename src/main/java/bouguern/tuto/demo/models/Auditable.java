package bouguern.tuto.demo.models;

import java.time.LocalDateTime;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Setter
@Getter
public abstract class Auditable {
	
	@CreatedDate
	@Column(name = "creationDate", nullable = false, updatable = false)
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(name = "lastUpdateDate", insertable = false)
	private LocalDateTime lastModifiedDate;

}
