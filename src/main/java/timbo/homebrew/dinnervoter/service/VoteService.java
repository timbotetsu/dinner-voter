package timbo.homebrew.dinnervoter.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import timbo.homebrew.dinnervoter.domain.VoteSummary;
import timbo.homebrew.dinnervoter.repository.VoteMapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class VoteService {

    private final VoteMapper voteMapper;

    public VoteService(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }

    public List<VoteSummary> getVoteSummaries() {
        LinkedList<VoteSummary> voteSummaries = new LinkedList<>();
        voteMapper.listAll().stream().sequential().forEach(v -> {
            VoteSummary voteSummary = new VoteSummary();
            voteSummary.setId(v.getId());
            voteSummary.setTitle(DateFormatUtils.format(v.getCreateTime(), "yyyy-MM-dd") + " / " + v.getShop());

            StringBuilder ob = new StringBuilder("");
            Arrays.stream(v.getOptions().split(";")).sequential()
                    .forEach(s -> ob.append(s.split(":")[1]).append(" / "));
            voteSummary.setOptions(ob.substring(0, ob.length() - 2));

            voteSummary.setSatisfactionRatio("0"); // TODO

            voteSummaries.add(voteSummary);
        });
        return voteSummaries;
    }

    public void save(String shop, String options) {
        voteMapper.save(shop, options);
    }
}
