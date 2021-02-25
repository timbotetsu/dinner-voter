package timbo.homebrew.dinnervoter.domain;

import lombok.Data;

@Data
public class VoteSummary {

    private long id;
    private String title;
    private String options;
    private String satisfactionRatio;

}
