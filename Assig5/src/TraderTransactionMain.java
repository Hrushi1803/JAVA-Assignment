import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderTransactionMain { 
	public static void main(String[] args) {
	Trader ram  = new Trader("Ram","Pune");
	Trader manas  = new Trader("Manas","Indore");
	Trader aju  = new Trader("Aju","Pune");
	Trader pooja  = new Trader("Pooja","Pune");
	Trader anu  = new Trader("Anu","Delhi");
	Trader ria  = new Trader("Ria","Delhi");
	 	//Transaction Record 
	List<Transaction> transactions = Arrays.asList(
			new Transaction(pooja,2011,300),
			new Transaction(ram,2012,1000),
			new Transaction(ram,2011,400),
			new Transaction(manas,2012,710),
			new Transaction(manas,2012,930),
			new Transaction(aju,2012,850),
	        new Transaction(ria,2012,1200),
	        new Transaction(anu,2012,2000));
	
	//8.Find  all  transactions  in  the  year  2011  and  sort  them  by  value  (small  to high).
	List<Transaction> result1 = transactions.stream()
			 .filter( (t)->t.getYear()==2011)// Filter out the year is not 2011
			 .sorted(Comparator.comparing(Transaction::getValue))// sorted by value
			.collect(Collectors.toList()); 
	result1.forEach(System.out::println);
	
	//9.What are all the unique cities where the traders work?
	List<String> result = transactions.stream()
			 .map(Transaction::getTrader)//Maps traders from transaction records
			 .map(Trader::getCity)//Map the city name from the trader
			 .distinct()//re-weight
			.collect(Collectors.toList());
	result.forEach(System.out::println);
	
	//10.Find all traders from Pune and sort them by name.
	List<Trader> result2 = transactions.stream()
			 .map(Transaction::getTrader)//maps traders
			 .filter((t)->("Pune").equals(t.getCity()))//Filter City as a trader in Pune
			 .distinct()//de-weighting
			 .sorted(Comparator.comparing(Trader::getName)) // Sort by name
			.collect(Collectors.toList());
	result2.forEach(System.out::println);
	
	//11.Return a string of all traders’ names sorted alphabetically.
	String allName = transactions.stream()
			 .map((t)->t.getTrader().getName())//Map the trader name
			 .sorted() // sort (default ascending)
			 .reduce(" ",(a,b)->a+" "+b); //If you don't add "", it returns Option<String> because the source is prevented from being empty.
	System.out.println(allName);
	
	//12.Are any traders based in Indore?
	boolean flag = transactions.stream()
			 .map(Transaction::getTrader)//maps traders
			 .anyMatch(t->t.getCity().equals("Indore"));//Match
	 System.out.println("Is there any traders from Indore? "+flag);
	 
	 //13.Print all transactions’ values from the traders living in Delhi.
	 Integer sum = transactions.stream()
				.filter(t->t.getTrader().getCity().equals("Delhi"))//Filtering traders living in Delhi
				 .map(Transaction::getValue)//maps the transaction amount
				 .reduce(0, (a,b)->a+b);//Last processing
		 System.out.println("All transactions for traders living in Delhi: "+sum);
		 
		 //14.What’s the highest value of all the transactions?
		 List<Integer> list = transactions.stream()
				 .sorted(Comparator.comparing(Transaction::getValue).reversed())//Transaction amount sorting (descending order)
				 .map(Transaction::getValue)//maps the transaction amount
				 .limit(1)//takes only the first one, that is the highest transaction amount
				.collect(Collectors.toList());
		 System.out.println("In all transactions, the highest transaction amount is "+list.get(0));
		 
	//15.Find the transaction with the smallest value.
		 Optional<Integer> min = transactions.stream()
				 .map(Transaction::getValue)//maps the transaction amount
				 .reduce(Integer::min);//Use reduce to process data
		 System.out.println("In all transactions, the minimum transaction amount is "+min.get());
		
	}
}