package com.study.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRibbonConfigRule extends AbstractLoadBalancerRule {

    //总共被调用的次数，目前配置每个调五次
    private int count = 0;
    //当前提供服务的机器下标
    private int current = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        //判断负载均衡是否为空，为空，直接返回空
        if (lb == null) {
            return null;
        }
        Server server = null;
        //如果server为空，线程虚假唤醒，使用while，当线程唤醒后还会回来再执行一次
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //获取当前UP状态的服务列表
            List<Server> upList = lb.getReachableServers();
            //获取所有的服务列表
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            //服务列表为空，直接返回
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if (count < 5) {
                server = upList.get(current);
                count++;
            } else {
                count = 0;
                current++;
                if (current >= upList.size()) {
                    current = 0;
                }
            }
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }
            //不为空，则判断server是否存辉，存活则返回
            if (server.isAlive()) {
                return (server);
            }
            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }
}
