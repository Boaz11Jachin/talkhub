package org.codenova.talkhub.model.vo;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PostLike {
    private int id;
    private String userId;
    private int postId;
    private Date createdAt;

}
