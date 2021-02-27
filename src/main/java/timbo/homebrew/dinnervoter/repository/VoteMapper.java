package timbo.homebrew.dinnervoter.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import timbo.homebrew.dinnervoter.domain.VoteDetail;
import timbo.homebrew.dinnervoter.domain.VotePoll;

import java.util.List;

@Mapper
@Repository
public interface VoteMapper {

    @Select("SELECT * FROM VOTE_POLL ORDER BY CREATE_TIME DESC")
    List<VotePoll> listAll();

    @Select("SELECT * FROM VOTE_POLL WHERE ID = #{id}")
    VotePoll findOne(@Param("id") long id);

    @Insert("INSERT INTO VOTE_POLL(SHOP, OPTIONS)" +
            " VALUES(#{shop}, #{options}) ")
    int save(@Param("shop") String shop,
             @Param("options") String options);


    @Select("SELECT * FROM VOTE_DETAIL WHERE VOTE_ID = #{voteId}")
    List<VoteDetail> findAllVoteDetailByVoteId(@Param("voteId") long voteId);

    @Insert("INSERT INTO VOTE_DETAIL(VOTE_ID, VOTE_FOR, RATING) " +
            " VALUES(#{voteId}, #{voteFor}, #{rating}) ")
    int vote(@Param("voteId") long voteId,
             @Param("voteFor") String voteFor,
             @Param("rating") int rating);

}
