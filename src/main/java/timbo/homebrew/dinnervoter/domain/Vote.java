package timbo.homebrew.dinnervoter.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Vote {

    private long id;
    private String title;
    private String summary;
    private String options;
    private Date createTime;

}
