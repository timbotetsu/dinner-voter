package timbo.homebrew.dinnervoter.domain;

import lombok.Data;

import java.util.Date;

@Data
public class VotePoll {

    private long id;
    private String shop;
    private String options;
    private Date createTime;

}
