package FACTORY;

import DAO.BookDAO;
import DAO.BookDAOProxy;

public class DAOFactory {
	public static BookDAO getBookDAOInstance() throws Exception {
		return new BookDAOProxy();
	}
}
