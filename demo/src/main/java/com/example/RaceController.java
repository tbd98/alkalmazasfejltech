import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/list")
    public String showRaceList(Model model) {
        List<Race> races = raceService.getAllRaces();
        model.addAttribute("races", races);
        return "raceList";
    }

    @GetMapping("/new")
    public String showNewRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "newRace";
    }

    @PostMapping("/add")
    public String addRace(@ModelAttribute Race race) {
        raceService.addRace(race);
        return "redirect:/races/list";
    }
}
