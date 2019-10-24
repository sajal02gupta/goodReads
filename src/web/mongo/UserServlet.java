package web.mongo;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import web.mongo.db.ConnectionManager;
import web.mongo.db.modal.Book;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = db.getCollection("goodReads");

		MongoCursor<Document> cursor = collection.find().iterator();
		LinkedList<Book> dataList = new LinkedList<Book>();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();
			Book book = new Book(d.getInteger("bookId"), d.getString("bookName"), d.getString("bookAuthor"),
					d.getString("bookType"));
			dataList.add(book);
			request.setAttribute("list", dataList);
		}
		request.getRequestDispatcher("second.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid= request.getParameter("bid");
		System.out.println(bid);
		request.setAttribute("bid", bid);
		request.getRequestDispatcher("review.jsp").forward(request, response);
		
	}

}
