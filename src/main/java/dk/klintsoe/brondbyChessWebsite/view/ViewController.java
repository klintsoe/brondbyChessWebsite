package dk.klintsoe.brondbyChessWebsite.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private Logger timerLog = LogManager.getLogger("timer");
    private Logger log = LogManager.getLogger();
    @RequestMapping("/")
    public String index(Model model) {
        timerLog.info("ViewController: log start");

        log.info("ViewController: logging Søren er den bedste... :-)");

        timerLog.info("ViewController: log stop");
        model.addAttribute("name", "Søren");
        return "index";
    }
}
