package com.galaxy.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author lane
 * @date 2021年06月17日 下午6:22
 */
@Activate(group={CommonConstants.CONSUMER,CommonConstants.PROVIDER})
public class TimeFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();

        try {
            return invoker.invoke(invocation);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("执行时间为："+(end-start)+"毫秒");
        }
        return null;
    }
}
