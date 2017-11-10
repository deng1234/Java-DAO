package DAO;

import java.sql.SQLException;
import java.util.List;

import VO.Book;


public interface BookDAO {
	//	查找某一本书籍
	public Book findById(int bookid) throws Exception;
	// 显示所有书籍
	public List<Book> findAll() throws Exception;
	// 修改书籍信息
	public boolean doUpdate(Book book) throws Exception;
	// 删除书籍信息
	public boolean doDelete(Book book) throws Exception;
	// 新增书籍信息
	public boolean doCreate(Book book) throws Exception;
}
