package cn.yezihao.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private Integer Sno;
    private String Sname;
    private String Ssex;
    private Integer Sage;
    private String Smajor;
    private Integer Cno;
}
