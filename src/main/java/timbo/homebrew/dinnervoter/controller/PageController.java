package timbo.homebrew.dinnervoter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import timbo.homebrew.dinnervoter.service.VoteService;

@Controller
@RequestMapping
public class PageController {

    @Autowired
    private VoteService voteService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("voteSummaries", voteService.getVoteSummaries());
        return "index";
    }

    @GetMapping("createnew")
    public String createNewPage() {
        return "createnew";
    }

    @GetMapping("success")
    public String successPage() {
        return "success";
    }

    @GetMapping("vote/{id}")
    public String votePage(@PathVariable("id") long id,
                           Model model) {
        model.addAttribute("voteId", id);
        model.addAttribute("voteOptionDetail", voteService.getVoteOptionDetail(id));
        return "vote";
    }

}
