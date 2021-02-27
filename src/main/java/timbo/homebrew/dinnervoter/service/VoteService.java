package timbo.homebrew.dinnervoter.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;
import timbo.homebrew.dinnervoter.domain.VoteDetail;
import timbo.homebrew.dinnervoter.domain.VoteOptionDetail;
import timbo.homebrew.dinnervoter.domain.VotePoll;
import timbo.homebrew.dinnervoter.domain.VoteSummary;
import timbo.homebrew.dinnervoter.repository.VoteMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

            StringBuilder ob = new StringBuilder();
            Arrays.stream(v.getOptions().split(";"))
                    .sequential()
                    .forEach(s -> ob.append(s).append(" / "));
            voteSummary.setOptions(ob.substring(0, ob.length() - 2));

            List<VoteDetail> voteDetails = voteMapper.findAllVoteDetailByVoteId(v.getId());
            if (voteDetails.size() == 0) {
                voteSummary.setSatisfactionRatio("无投票");
            } else {
                AtomicInteger totalVote = new AtomicInteger(0);
                AtomicInteger ratingSum = new AtomicInteger(0);
                voteDetails.forEach(d -> {
                    totalVote.incrementAndGet();
                    ratingSum.addAndGet(d.getRating());
                });
                voteSummary.setSatisfactionRatio(new BigDecimal(ratingSum.doubleValue() / (totalVote.doubleValue() * 10))
                        .multiply(new BigDecimal(100))
                        .setScale(2, RoundingMode.HALF_EVEN)
                        .toString() + "%");
            }

            voteSummaries.add(voteSummary);
        });
        return voteSummaries;
    }

    public VoteOptionDetail getVoteOptionDetail(long id) {
        VotePoll votePoll = voteMapper.findOne(id);
        String date = DateFormatUtils.format(votePoll.getCreateTime(), "yyyy-MM-dd");

        List<VoteDetail> voteDetails = voteMapper.findAllVoteDetailByVoteId(id);

        VoteOptionDetail detail = new VoteOptionDetail();

        detail.setTitle("于" + date + "在" + votePoll.getShop() + "订购的晚餐");

        LinkedList<Triple<String, String, String>> options = new LinkedList<>();
        AtomicInteger totalVote = new AtomicInteger(0);
        Arrays.stream(votePoll.getOptions().split(";"))
                .sequential()
                .forEach(s -> {
                    List<VoteDetail> filterList = voteDetails.stream()
                            .filter(v -> v.getVoteFor().equals(s))
                            .collect(Collectors.toList());

                    if (filterList.size() == 0) {
                        options.add(Triple.of(s, "0", "0"));
                        return;
                    }

                    AtomicInteger voteCount = new AtomicInteger(0);
                    AtomicInteger ratingSum = new AtomicInteger(0);
                    filterList.forEach(f -> {
                        totalVote.incrementAndGet();
                        voteCount.incrementAndGet();
                        ratingSum.addAndGet(f.getRating());
                    });
                    options.add(Triple.of(s, voteCount.toString(),
                            new BigDecimal(ratingSum.doubleValue() / (voteCount.doubleValue() * 10))
                                    .multiply(new BigDecimal(100))
                                    .setScale(2, RoundingMode.HALF_EVEN)
                                    .toString() + "%"));
                });
        detail.setTotalVote(totalVote.intValue());
        detail.setOptions(options);

        return detail;
    }

    public void save(String shop, String options) {
        voteMapper.save(shop, options);
    }

    public int vote(long voteId, String voteFor, int rating) {
        return voteMapper.vote(voteId, voteFor, rating);
    }
}
