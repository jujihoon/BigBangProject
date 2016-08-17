package big.util;
import java.io.Reader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class ServiceUtil {
	 private static SqlSessionFactory sqlSessionFactory;
	    static {
	    	
	    	try
	    	{
	    		Reader reader=Resources.getResourceAsReader("big/dao/Config.xml");	    	
	    		sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	    	}catch(Exception ex)
	    	{
	    		System.out.println(ex.getMessage());
	    	}
	    }
	    
	    public static SqlSessionFactory getSqlSessionFactory()
	    {
	    	return sqlSessionFactory;
	    }

}
