package com.js.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.js.dto.Book;

	public class BookCRUD {
		final static String path = "com.mysql.cj.jdbc.Driver";
		final static String adress = "jdbc:mysql://localhost:3306/jdbc_newyear?user=root&password=Paru@65";
		static Connection c;

		public int insertBook(Book b) {
			try {
				Class.forName(path);
				c = DriverManager.getConnection(adress);
				PreparedStatement ps = c.prepareStatement("insert into book value(?,?,?,?,?)");
				ps.setInt(1, b.getBookid());
				ps.setString(2, b.getBookname());
				ps.setString(3, b.getBook_authorname());
				ps.setInt(4, b.getNoofpages());
				ps.setDouble(5, b.getPrice());
				return ps.executeUpdate();

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			
			}
			return 0;
		}

		public int DeleteBookBYId(int Id) {
			try {
				Class.forName(path);

				c = DriverManager.getConnection(adress);
				PreparedStatement ps = c.prepareStatement("delete from Book where bookid=?");
				ps.setInt(1, Id);
				return ps.executeUpdate();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();

			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return 0;
		}

		public int updateBookById(int id,Book b) {
			try {
				Class.forName(path);
				c=DriverManager.getConnection(adress);
				PreparedStatement ps=c.prepareStatement("update book set bookname=?,book_authorname=?,noofpages=?,price=? where bookid=?");
				ps.setString(1,b.getBookname());
				ps.setString(2, b.getBook_authorname());
				ps.setInt(3, b.getNoofpages());
				ps.setDouble(4, b.getPrice());
				ps.setInt(5, id);
				return ps.executeUpdate();
			}  catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();

			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();		
			}
			}
		
			return 0;
	}

		

	public Book GetBookById(int id) {
		Book b = null;
		try {
			Class.forName(path);
			c = DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("select * from book where bookid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBook_authorname(rs.getString(3));
				b.setNoofpages(rs.getInt(4));
				b.setPrice(rs.getInt(5));
				return b;
			}
			else {
				return b;
			}
		}  catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
	 }finally {
		 try {
		 
				c.close();
		
			}	 catch (SQLException e) {
				e.printStackTrace();
		}
			
	 }
		return b;
	}


	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> al=new ArrayList<Book>();
		try {
			Class.forName(path);
				 c=DriverManager.getConnection(adress);
				PreparedStatement ps=c.prepareStatement("Select * from Book");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Book b=new Book();
					b.setBookid(rs.getInt(1));
					b.setBookname(rs.getString(2));
					b.setBook_authorname(rs.getString(3));
					b.setNoofpages(rs.getInt(4));
					b.setPrice(rs.getDouble(5));
					al.add(b);
					
				}
				return al;
				} catch (SQLException e) {
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			 try {
			 
					c.close();
			
				}	 catch (SQLException e) {
					e.printStackTrace();
			} }
		return al;
	}


		public boolean batchExecution(ArrayList<Book> books) {
			try {
				Class.forName(path);
				c=DriverManager.getConnection(adress);
				PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?,?)");
				for(Book b: books) { 
					ps.setInt(1, b.getBookid());
					ps.setString(2, b.getBookname());
					ps.setString(3, b.getBook_authorname());
					ps.setInt(4, b.getNoofpages());
					ps.setDouble(5, b.getPrice());
					ps.addBatch();
				}
				ps.executeBatch();
				return true;
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
			
			
		}
	}
				
		
		
				