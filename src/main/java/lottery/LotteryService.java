package lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface LotteryService {
    LotteryPOJO roll();
}
