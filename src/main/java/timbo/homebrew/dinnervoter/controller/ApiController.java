package timbo.homebrew.dinnervoter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import timbo.homebrew.dinnervoter.service.VoteService;

@Controller
@RequestMapping
public class ApiController {

    private final VoteService voteService;

    public ApiController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("createnew")
    @ResponseBody
    public ResponseEntity createnew(String shop, String options) {
        if (StringUtils.hasText(shop) && StringUtils.hasText(options)) {
            voteService.save(shop, options);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("vote")
    @ResponseBody
    public ResponseEntity vote(long voteId, String voteFor, int rating) {
        voteService.vote(voteId, voteFor, rating);
        return ResponseEntity.ok().build();
    }

}
