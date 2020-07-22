package org.dxc.shopping.service;

import org.dxc.shopping.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.dxc.shopping.exception.ProductException;


public class CartOperationServiceImp implements CartOperationService {

	private float tax_percentage;
	private float invoiceAmount;
	private List<Product> items = new ArrayList<Product> ();
	
	public CartOperationServiceImp(float tax_percentage2) {
		// TODO Auto-generated constructor stub
		this.tax_percentage=tax_percentage2;
	}
	
	@Override
	public int getCartSize() {
		return items.size();
	}
	@Override
	public float getInvoiceAmount() {
		// TODO Auto-generated method stub
		return invoiceAmount;
	}

	@Override
	public float addToCart(Product p) {
		// TODO Auto-generated method stub
		items.add(p);
		this.invoiceAmount+=p.getPrice()*p.getQuantity()+(tax_percentage/100)*p.getPrice()*p.getQuantity();
		return 0;
	}

	@Override
	public void removeFromCart(Product p) throws ProductException {
		// TODO Auto-generated method stub
		Iterator<Product> iterator = items.iterator();
		
		try {
		     if(items.isEmpty()) {
		     throw new ProductException(p.getName());				
				
	       	}
		
	}
	
		catch(ProductException e)	
		{	
			e.printStackTrace();
			System.out.println("ProductException;"+e);
			System.out.println("------------------------------------------");
				
		}
		while(iterator.hasNext())
		{
		Product p1=iterator.next();
		if(p1.getName().equals(p.getName()))
		{				
		this.invoiceAmount-=p1.getPrice()*p1.getQuantity()+(tax_percentage/100)*p1.getPrice()*p1.getQuantity();
		iterator.remove();
		}
    	}
			
		}
	@Override
	 public String toString() {
		
	 return items.toString();
	}
}
