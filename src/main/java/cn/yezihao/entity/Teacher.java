package cn.yezihao.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher implements Serializable {
    // Tno教工号 Tname(Courcedirector授课老师) Tsex教师性别 Tage教师年龄
    private Integer Tno;
    private String Tname;
    private String Tsex;
    private Integer Tage;
}
