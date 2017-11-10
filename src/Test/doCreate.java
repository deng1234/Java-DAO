package Test;

import FACTORY.DAOFactory;
import VO.Book;

public class doCreate {
	public static void main(String args[]) throws Exception {
		Book book = new Book();
		try {
			book.setBookName("Java特种兵");
			book.setBookNumber(1);
			book.setPubdate(new java.util.Date());
			boolean flag = DAOFactory.getBookDAOInstance().doCreate(book);
			System.out.println(flag);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
