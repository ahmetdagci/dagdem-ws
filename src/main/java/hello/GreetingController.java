package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.model.Product;
import com.tr.dagdem.model.Sale;
import com.tr.dagdem.model.Customer;

@RestController
public class GreetingController {

    @RequestMapping("/products")
    public List<Product> products(@RequestParam(value="productType") String productType) 
    {
     
		List<Product> productList = new ArrayList<Product>();
		Product product1 = new Product("p1","Oralet",2.2,1);
		Product product2 = new Product("p2","Süt Tozu",4,1);
		productList.add(product1);
		productList.add(product2);
		return productList;
    }
    
    @RequestMapping("/customers")
    public List<Customer> getCustomers() 
    {
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer1 = new Customer("c1","Musa","Berkay");
		Customer customer2 = new Customer("c2","Erol","Başıbüyük");
		customerList.add(customer1);
		customerList.add(customer2);
		return customerList;
    }
    
    @RequestMapping(value = "/sale",method = RequestMethod.POST)
	public int sellProducts(@RequestBody Sale sale)
	{
		System.out.println(sale.getUserId() + sale.getCustomerId());
		return 0;
	}
    
   
}
