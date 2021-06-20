package com.galaxy.route;

import com.lagou.router.ReadyRestartInstances;

public class ServerRestartMain {
    public static void main(String[] args) throws  Exception {
        //如果这台机器在更新，就不要让消费者调用这台服务器，既是把该节点加入到zk中的重启列表，路由就不会路由到该机器
        //ReadyRestartInstances.create().addRestartingInstance("service-provider","192.168.20.1");
        //删除不让路由机器列表中的该机器节点信息
        ReadyRestartInstances.create().removeRestartingInstance("service-provider","192.168.20.1");
    }
}
