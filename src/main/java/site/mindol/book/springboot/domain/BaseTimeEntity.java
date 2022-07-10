package site.mindol.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseTimeEntity 클래스는 모든 Entity 의 상위 클래스가 되어 Entity 들의
 * createdDate, modifiedDate 를 자동으로 관리하는 역할
 *
 * @MappedSuperClass -> JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우
 * 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 한다
 *
 * @EntityListeners(AuditingEntityListener.class) -> 클래스에 Auditing 기능을 포함시킨다
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
