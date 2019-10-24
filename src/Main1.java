import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import web.mongo.db.ConnectionManager;

public class Main1 {

	public static void main(String[] args) {
		String options=" ";
		String bookName = null, bookAuthor = null, bookType = null;
		MongoClient mongoClient = ConnectionManager.getMongo();
		MongoDatabase database = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = database.getCollection("goodReads");
		// TODO Auto-generated method stub
		do{
			Scanner sc= new Scanner(System.in);
			System.out.println("1. Add a book");
			System.out.println("2. View all books");
			System.out.println("3. Update a book");
			System.out.println("4. Delete a book");
			System.out.println("5. Exit");
			options= sc.nextLine();
			int id=0;
			switch(options){
			case "1":
					System.out.println("Enter a book Name: ");
					bookName= sc.nextLine();
					System.out.println("Enter a book Author: ");
					bookAuthor= sc.nextLine();
					System.out.println("Enter a book Type: ");
					bookType= sc.nextLine();
					
					MongoCursor<Document> cursor2 = collection.find().iterator();
					
					if(!cursor2.hasNext()){
						Document document1 = new Document("bookId",id+1).append("bookName", bookName)
								.append("bookAuthor", bookAuthor).append("bookType", bookType);
						collection.insertOne(document1);
					}else{
						while(cursor2.hasNext()){
							 Document d = (Document) cursor2.next();

							id= d.getInteger("bookId");
						}
							Document document1 = new Document("bookId",id+1).append("bookName", bookName)
									.append("bookAuthor", bookAuthor).append("bookType", bookType);
							collection.insertOne(document1);
					}
					
						
					
				break;
			case "2":
				MongoCursor<Document> cursor1 = collection.find().iterator();
				while (cursor1.hasNext()) {
					 Document d = (Document) cursor1.next();
					 String bookName1= d.getString("bookName");
					 String bookAuthor1= d.getString("bookAuthor");
					 String bookType1=d.getString("bookType");
					 Integer bookId= d.getInteger("bookId");
					 System.out.printf("BookId: %s | BookName: %s | BookAuthor: %s | BookType: %s\n",bookId,bookName1,bookAuthor1,bookType1);
					 }
				break;
			case "3":
				System.out.println("Enter the name of the book you want to update");
				String updatedBook= sc.nextLine();
				System.out.println("Wanna change the name? Yes to enter or No to leave");
				String bool= sc.nextLine().toLowerCase();
				if(bool.equals("yes")){
					System.out.println("Enter the new name of the book");
					String newBook= sc.nextLine();
					collection.updateOne(Filters.eq("bookName", updatedBook), Updates.set("bookName",newBook));
					
				}
				System.out.println("Wanna change the author name? Yes to enter or No to leave");
				String bool1= sc.nextLine().toLowerCase();
				if(bool1.equals("yes")){
					System.out.println("Enter the Author of the book");
					String newAuthor= sc.nextLine();
					collection.updateOne(Filters.eq("bookName", updatedBook), Updates.set("bookAuthor",newAuthor));
					
				}
				System.out.println("Wanna change the type of book? Yes to enter or No to leave");
				String bool2= sc.nextLine().toLowerCase();
				if(bool2.equals("yes")){
					System.out.println("Enter the type of the book");
					String newType= sc.nextLine();
					collection.updateOne(Filters.eq("bookName", updatedBook), Updates.set("bookType",newType));
					
				}
				break;
			case "4":
				System.out.println("Enter the name of the book you want to delete");
				String deletedBook= sc.nextLine();
				collection.deleteOne(Filters.eq("bookName", deletedBook));
				break;
			case "5": 
				System.out.println("Thank you for entering the book");
				System.exit(0);
				break;
			}
		}while(options!="5");
		
		ConnectionManager.close();

	}

}