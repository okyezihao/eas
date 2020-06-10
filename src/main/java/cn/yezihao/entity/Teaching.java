package cn.yezihao.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teaching implements Serializable {
    private Integer Tno;
    private Integer Cno;
    private Integer Courceno;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date Teachtime;

    // tcher
    private String Tname;

    // cour
    private String Courcename;
    private Integer Credit;

    // cla
    private String Cname;
    private String Xname;

    // claroom Rno
    private String Raddr;

    // occupy
    private Integer Usetime;

}
