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

import web.mongo.db.ConnectionManager;
import web.mongo.db.modal.BookReview;

/**
 * Servlet implementation class ViewAllReviews
 */
@WebServlet("/ViewAllReviews")
public class ViewAllReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid= request.getParameter("bid");
		System.out.println(bid);
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = db.getCollection("goodReadsReview");
		
		LinkedList<BookReview> dataList = new LinkedList<>();
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();
			BookReview bReview = new BookReview(d.getString("userName"), d.getString("bookReview"));
			dataList.add(bReview);
		}

		request.setAttribute("list", dataList);

		request.getRequestDispatcher("viewall.jsp").forward(request, response);
	}

}
