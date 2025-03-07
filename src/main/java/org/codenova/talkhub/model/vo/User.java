package org.codenova.talkhub.model.vo;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private  String password;
    private String nickname;
    private String gender;
    private int birth;
    private Date createdAt;
}
