package lottery;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class Lottery implements LotteryService{

    @Override
    public LotteryPOJO roll() {
        LotteryPOJO result = new LotteryPOJO();

        // 生成一个1到10的随机整数，基于权重
        String randomNumberByWeight = String.valueOf(getRandomNumberByWeight());
        result.setRes(randomNumberByWeight);

        // 生成角度
        int angle = 30;
        result.setAngle(angle);

        // 兑奖码
        result.setSn("123456");



        return result;
    }

    // 带权重的随机数生成
    public int getRandomNumberByWeight() {
        // 创建一个Random对象
        Random random = new Random();

        // 定义数字和对应的比率
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights = {10, 20, 30, 10, 10, 5, 5, 3, 4, 3}; // 总和应为100

        // 计算权重总和
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }

        int randomValue = random.nextInt(totalWeight);
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += weights[i];
            if (randomValue < sum) {
                return numbers[i];
            }
        }

        // 理论上不应该到达这里
        throw new RuntimeException("权重计算错误");
    }
}
