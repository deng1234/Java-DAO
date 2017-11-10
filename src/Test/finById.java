package Test;

import FACTORY.DAOFactory;
import VO.Book;

public class finById {
	public static void main(String args[]) throws Exception {
		Book book = new Book();
		try {
			book = DAOFactory.getBookDAOInstance().findById(1);
			System.out.println(book.getBookName()+"--"+book.getBookNumber()+"--"+book.getPubdate());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
