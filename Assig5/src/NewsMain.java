import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class NewsMain {

	public static void main(String[] args) {
		ArrayList<News> al = new ArrayList<>();
		al.add(new News(22,"Smith","Rohit","sopporters of INDIA"));
		al.add(new News(23,"MAhi","Raina","World cup is here"));
		al.add(new News(23,"MAhi","Nikky","I'm in XI"));
		al.add(new News(22,"Dj","Rohit","CSK will win"));
		al.add(new News(22,"Smith","Ravi","without budget"));
		al.add(new News(22,"Ravi","Smith","without budget"));
		
		/*for(News name:al)    
		    System.out.println(name);*/
		
		//4. Find out the newsId which has received maximum comments.
		int  p=al.stream()
				.min((p1,p2)-> {
					return (int) p1.getnewsId()+p2.getnewsId();
					}).get().getnewsId();
			 System.out.println(p);
			 
		//5.Find out how many times the word 'budget' arrived in user comments all news.
			 al.stream()
				.filter(t->t.comment.contains("budget"))
				.forEach(t->System.out.println(t)); 
			 
		//6.Find out which user has posted maximum comments.
			 System.out.println("\nwhich user has posted maximum comments");
			 	String  n=al.stream()
				.max((p1,p2)-> {
					return (int) p1.getcommentByUser().compareTo(p2.getcommentByUser());
					}).get().getcommentByUser();
			 	System.out.println(n);
			 	
		//7.Display commentByUser wise number of comments.
			 	
			 	System.out.println("\ncommentByUser wise number of comments");
				al.stream()
				.sorted((p1,p2)->p1.getcommentByUser().compareTo(p2.getcommentByUser()))
				.collect(Collectors.toList())
				.forEach(t->System.out.println(t.commentByUser+"="+t.comment));
				
		

	}

}
