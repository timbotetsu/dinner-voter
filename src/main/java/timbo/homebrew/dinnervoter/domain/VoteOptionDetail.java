package timbo.homebrew.dinnervoter.domain;

import lombok.Data;
import org.apache.commons.lang3.tuple.Triple;

import java.util.LinkedList;

@Data
public class VoteOptionDetail {

    private String title;
    private int totalVote;
    private LinkedList<Triple<String, String, String>> options;

}
