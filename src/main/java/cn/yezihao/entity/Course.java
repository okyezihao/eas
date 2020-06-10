package cn.yezihao.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course implements Serializable {
    private Integer Courceno;
    private String Courcename;
    private Integer Credit;
    private Integer Courcedirector;
    private String Tname;
}
