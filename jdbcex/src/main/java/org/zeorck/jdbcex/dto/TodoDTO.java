package org.zeorck.jdbcex.dto;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {



    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
