package Test;

import FACTORY.DAOFactory;
import VO.Book;

public class doUpdate {
	public static void main(String args[]) throws Exception {
		Book book = new Book();
		try {
			book.setBookid(1);
			book.setBookName("Java特种兵");
			book.setBookNumber(3);
			book.setPubdate(new java.util.Date());
			boolean flag = DAOFactory.getBookDAOInstance().doUpdate(book);
			System.out.println(flag);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
