package org.zerock.b01.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {



    @CreatedDate
    @Column(name = "regdate",updatable = false)
    private LocalDateTime regDate;

    @LastModifiedBy
    @Column(name = "moddate")
    private LocalDateTime modDate;



}
