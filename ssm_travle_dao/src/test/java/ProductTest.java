import com.ssm.travle.dao.IProductDao;
import com.ssm.travle.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ProductTest {
    private InputStream in ;
    private SqlSession sqlSession;
    private IProductDao productDao;

    @After
    public void destory() throws Exception{
        in.close();
        sqlSession.close();
    }

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("MapperConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(in).openSession(true);
        productDao = sqlSession.getMapper(IProductDao.class);
    }


    @Test
    public void findAll() throws Exception {
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
