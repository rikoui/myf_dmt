package com.bjdreamtech.dmt.intercepter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;

import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTPageUtil;

/**
 * 通过拦截StatementHandler的prepare(Connection xx)方法，重写sql语句实现物理分页。
 * @author duanwu
 * 
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class DMTPageInterceptor implements Interceptor {
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    // 需要拦截的ID(正则匹配，根据实际情况调整)
    private static String pageSqlId = "[a-zA-Z0-9.]+ByPage$"; 

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	//获取被拦截的class实例
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //通过MetaObject包装被拦截的class实例，以便获取以及设置此实例中原不可访问属性
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
                DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        //获取StatementHandler中的delegate.mappedStatement属性，此属性为MappedStatement类型
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        // 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以query开头的MappedStatement的sql
        if (mappedStatement.getId().matches(pageSqlId)) {
        	//如果sql对应的id是以query开头的，则继续
        	//获取BoundSql属性
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            //获取参数对象
            Object parameterObject = boundSql.getParameterObject();
            //如果参数对象为空则跳过整个过程，不为空时继续执行
            if (parameterObject != null) {
            	//获取参数对象中的分页工具属性（pageUtil为自定义分页工具）
                DMTPageUtil pageUtil = (DMTPageUtil) metaStatementHandler
                        .getValue("delegate.boundSql.parameterObject.pageUtil");
                //获取原sql语句
                String sql = boundSql.getSql();
                // 重写sql，将分页插入到sql中
                String pageSql = buildPageSql(sql, pageUtil);
                //设置被拦截的StatementHandler对象包含的sql语句为重写后的sql
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
                metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
                //获取被拦截对象StatementHandler的方法prepare的参数Connection
                Connection connection = (Connection) invocation.getArgs()[0];
                // 重设分页参数里的总页数等
                setPageParameter(sql, connection,mappedStatement, boundSql, pageUtil);
            }
        }
        // 将执行权交给下一个拦截器
        return invocation.proceed();
    }

    /**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数PageUtil,这样调用者就可用通过 分页参数
     * PageUtil获得相关信息。
     * 
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
            BoundSql boundSql, DMTPageUtil pageUtil) {
        //查询总记录数的sql语句
        String countSql = "select count(0) as total from (" + sql + ") as t"; 
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
        	//执行查询语句
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            //设置sql中的?的值
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            //获取结果集
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
            	//获取结果集中的总记录数
                totalCount = rs.getInt(1);
            }
            //设置分页组件的总记录数
            pageUtil.setTotalCount(totalCount);
            //计算总页数
            int totalPage = totalCount / pageUtil.getPageSize() + ((totalCount % pageUtil.getPageSize() == 0) ? 0 : 1);
            //设置分页组件的总页数
            pageUtil.setTotalPage(totalPage);
            //设置上一页和下一页信息
            pageUtil.setPreAndNextPage();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				countStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

    }

    /**
     * 对SQL参数(?)设值
     * 
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    /**
     * 根据数据库类型，重写特定的分页sql
     * 
     * @param sql 原sql
     * @param page 分页组件
     * @return
     */
    private String buildPageSql(String sql, DMTPageUtil page) {
    	//page分页组件为空时返回原sql
        if (page != null) {
            StringBuilder pageSql = new StringBuilder();
            if ("mysql".equals(DMTConfigUtil.CONFIG_DATABASE)) {
            	//如果数据库为mysql，则生成mysql的分页sql
                pageSql = buildPageSqlForMysql(sql, page);
            } else if ("oracle".equals(DMTConfigUtil.CONFIG_DATABASE)) {
            	//如果数据库为Oracle，则生成oracle的分页sql
                pageSql = buildPageSqlForOracle(sql, page);
            } else {
            	//数据库为其它的情况下再扩展，此处先返回原sql不实现分页
                return sql;
            }
            //返回分页后的sql
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    /**
     * 生成mysql的分页语句
     * 
     * @param sql
     * @param page
     * @return String
     */
    public StringBuilder buildPageSqlForMysql(String sql, DMTPageUtil page) {
    	//构造一个字符串生成器，初始容量为300个字符
        StringBuilder pageSql = new StringBuilder(300);
        //计算分页从第几条开始
        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
        pageSql.append(sql);
        //追加分页语句
        pageSql.append(" limit " + beginrow + "," + page.getPageSize());
        return pageSql;
    }

    /**
     * 生成oracle的分页语句
     * 
     * @param sql
     * @param page
     * @return String
     */
    public StringBuilder buildPageSqlForOracle(String sql, DMTPageUtil page) {
    	//构造字符串生成器
        StringBuilder pageSql = new StringBuilder(100);
        //计算分页从第几条开始
        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
        //计算分页在第几条结束
        String endrow = String.valueOf(page.getCurrentPage() * page.getPageSize());
        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endrow);
        pageSql.append(") where row_id > ").append(beginrow);
        return pageSql;
    }

    @Override
    public Object plugin(Object target) {
        // 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }
    
    

}
