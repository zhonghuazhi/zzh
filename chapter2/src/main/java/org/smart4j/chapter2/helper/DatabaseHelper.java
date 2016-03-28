package org.smart4j.chapter2.helper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhonghua on 15/10/28.
 */
public final class DatabaseHelper {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final QueryRunner queryRunner = new QueryRunner();

    private static final ThreadLocal<Connection> threadLocal_connection =
            new ThreadLocal<Connection>();

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties props = PropsUtil.loadProps("config.properties");
        DRIVER = props.getProperty("jdbc.driver");
        URL = props.getProperty("jdbc.url");
        USERNAME = props.getProperty("jdbc.username");
        PASSWORD = props.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("can not load jdbc driver .", e);
        }
    }

    /**
     * @return
     */
    public static Connection getConnection() {

        Connection connection = threadLocal_connection.get();
        if (null == connection) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                logger.error("get connection failure .", e);
                throw new RuntimeException(e);
            } finally {
                threadLocal_connection.set(connection);
            }
        }
        return connection;
    }

    /**
     * @param connection
     */
    public static void closeConnection(Connection connection) {

        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("close connection failure .", e);
            }
        }
    }


    /**
     *
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(
            Class<T> entityClass, String sql, Object... params) {

        List<T> entityList;
        try {
            entityList = queryRunner.query(threadLocal_connection.get(), sql,
                    new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            logger.error("query entity list failure. ", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection(null);
        }
        return entityList;
    }
}
