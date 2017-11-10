package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.Book;

public class BookDAOImpl implements BookDAO {
	private Connection conn;
	// 这里采用PreparedStatement进行预处理，主要是为了方式SQL注入
	// 关于网络安全，可以看我GitHub上面的一个文章
	// https://github.com/deng1234/webSecurity
	private PreparedStatement pstmt;
	// 在代理实现类中进行对象实例化的时候获得连接数据库的资源句柄	
	public BookDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	// 根据id查找	
	public Book findById(int bookid) throws SQLException{
		Book book = new Book();
		String sql = "SELECT bookid, bookName, bookNumber, pubdate FROM books WHERE bookid = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, bookid);
			ResultSet rs = (ResultSet) this.pstmt.executeQuery();
			if(rs.next()) {
				book.setBookid(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookNumber(rs.getInt(3));
				book.setPubdate(rs.getDate(4));
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return book;
	}

	@Override
	// 列出所有书籍
	public List<Book> findAll() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Book book;
		String sql = "SELECT bookid, bookName, bookNumber, pubdate FROM books";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) this.pstmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookNumber(rs.getInt(3));
				book.setPubdate(rs.getDate(4));
				books.add(book);
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return books;
	}

	@Override
	// 修改书籍信息
	public boolean doUpdate(Book book) throws SQLException {
		boolean flag = false;
		String sql = "UPDATE books SET bookName = ?, bookNumber = ?, pubdate = ? WHERE bookid = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, book.getBookName());
			this.pstmt.setInt(2, book.getBookNumber());
			this.pstmt.setDate(3, new java.sql.Date(book.getPubdate().getTime()));
			this.pstmt.setInt(4, book.getBookid());
			if(this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	// 删除书籍信息
	public boolean doDelete(Book book) throws SQLException {
		boolean flag = false;
		String sql = "DELETE FROM books WHERE bookid = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, book.getBookid());
			if(this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	// 新增书籍
	public boolean doCreate(Book book) throws SQLException {
		boolean flag = false;
		String sql = "INSERT INTO books (bookName, bookNumber, pubdate) "
				+ "values(?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, book.getBookName());
			this.pstmt.setInt(2, book.getBookNumber());
			this.pstmt.setDate(3, new java.sql.Date(book.getPubdate().getTime()));
			if(this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return flag;
	}
	
}
