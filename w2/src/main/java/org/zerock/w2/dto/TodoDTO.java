package org.zerock.w2.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
