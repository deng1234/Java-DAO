package Test;

import FACTORY.DAOFactory;
import VO.Book;

public class doDelete {
	public static void main(String args[]) throws Exception {
		Book book = new Book();
		try {
			book.setBookid(1);
			boolean flag = DAOFactory.getBookDAOInstance().doDelete(book);
			System.out.println(flag);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
