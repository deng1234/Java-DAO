package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySQLConnection;
import VO.Book;

public class BookDAOProxy implements BookDAO{
	private MySQLConnection conn = null;
	private BookDAO dao;
	public BookDAOProxy() throws Exception {
		this.conn = new MySQLConnection();
		// 在这里对真正的DAO实现内进行实例化		
		this.dao = new BookDAOImpl(this.conn.getConnection());
	}
	
	@Override
	// 书籍查找
	public Book findById(int bookid) throws Exception {
		Book book = new Book();
		try {
			book = this.dao.findById(bookid);
		}catch(SQLException e) {
			throw e;
		}finally {
			// 关闭数据库
			this.conn.close();
		}
		return book;
	}

	@Override
	// 列出所有书籍
	public List<Book> findAll() throws Exception {
		List<Book> books = new ArrayList<Book>();
		try {
			books = this.dao.findAll();
		}catch(Exception e) {
			throw e;
		}finally {
			this.conn.close();
		}
		return books;
	}

	@Override
	public boolean doUpdate(Book book) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findById(book.getBookid()) != null) {
				flag = this.dao.doUpdate(book);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.conn.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(Book book) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doDelete(book);
		}catch(Exception e) {
			throw e;
		}finally {
			this.conn.close();
		}
		return flag;
	}

	@Override
	public boolean doCreate(Book book) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(book);
		}catch(Exception e) {
			throw e;
		}finally {
			this.conn.close();
		}
		return flag;
	}
	
}
