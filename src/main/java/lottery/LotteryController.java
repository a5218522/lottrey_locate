package lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    LotteryService lotteryService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/roll")
    public LotteryPOJO roll(){
        return lotteryService.roll();
    }
}
