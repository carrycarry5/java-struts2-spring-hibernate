package yc.book;

import javax.annotation.Resource;

public class BookService {
	
	//�õ�bookdao��orderdao����
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
