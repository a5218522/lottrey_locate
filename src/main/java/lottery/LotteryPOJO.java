package lottery;

import lombok.Data;

@Data
public class LotteryPOJO {

    // 中奖号码
    public String res;

    // 旋转角度
    public int angle;

    // 异常信息
    public String msg;

    // 兑换码
    public String sn;
}
