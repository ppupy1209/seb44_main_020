package com.moovda_project.moovda.audit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/* extends Auditable 해서 사용 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변경 이벤트를 감지하고 처리하는 리스너를 등록
public class Auditable {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
