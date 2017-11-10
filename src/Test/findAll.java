package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import FACTORY.DAOFactory;
import VO.Book;

public class findAll {
	public static void main(String args[]) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Book book = new Book();
		try {
			books = DAOFactory.getBookDAOInstance().findAll();
			Iterator<Book> iter = books.iterator();
			while(iter.hasNext()) {
				book = iter.next();
				System.out.println(book.getBookName()+"--"+book.getBookNumber()+"--"+book.getPubdate());
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
