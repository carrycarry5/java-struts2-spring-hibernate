package yc.book;

import javax.annotation.Resource;

public class BookService {
	
	//得到bookdao和orderdao对象
	@Resource(name="BookDao")
	private BookDao dao ;
	@Resource(name="OrderDao")
	private OrderDao orderDao ;
	
	public void add(){
		dao.book();
		orderDao.buy();
		System.out.println("service.......................");
	}
}
