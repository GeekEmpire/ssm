package com.xmz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/*
连接的工具类，用于从数据源中获取一个连接，并实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection(){
        Connection conn = t1.get();
        try{
            if (conn == null){
                conn = dataSource.getConnection();
                t1.set(conn);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        t1.remove();
    }
}
