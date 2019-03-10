package com.qzlydao.flas.bizz.task;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-03 13:03
 */
@Data
public class FindMaxTask implements Callable<Integer> {

    private int[] data;

    public FindMaxTask(int[] data) {
        this.data = data;
    }

    @Override
    public Integer call() throws Exception {
        if (data.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        int len = data.length;
        int max = data[0];
        for (int i = 0; i < len - 1; i++) {
            if (max < data[i + 1]) {
                max = data[i + 1];
            }
        }
        return max;
    }
}
