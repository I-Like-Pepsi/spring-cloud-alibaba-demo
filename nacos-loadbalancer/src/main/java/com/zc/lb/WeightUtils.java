package com.zc.lb;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author zengchao
 * @date 2022-12-14 17:49:54
 */
public class WeightUtils {

    public static int get(double[] weightArrays){
        //初始化数组
        double[] values = new double[weightArrays.length];
        values[0] = weightArrays[0];
        for (int i = 1; i < values.length; i++) {
            values[i] = values[i-1] + weightArrays[i];
        }
        //获取随机值
        double value = ThreadLocalRandom.current().nextDouble() * values[values.length - 1];
        System.out.println(value);
        for (int i = 0; i < values.length; i++) {
            if (value < values[i]){
                return i;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        double[] doubles = {1.0, 2.0, 3.0};
        int[] count = new int[doubles.length];
        for (int i = 0; i < 6000; i++) {
            int r = get(doubles);
            count[r] = count[r] + 1;
        }
        System.out.println(Arrays.toString(count));
    }

}
