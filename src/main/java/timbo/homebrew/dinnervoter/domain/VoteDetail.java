package timbo.homebrew.dinnervoter.domain;

import lombok.Data;

import java.util.Date;

@Data
public class VoteDetail {

    private long id;
    private long voteId;
    private String voteFor;
    private int rating;
    private String extra;
    private Date createTime;

}
