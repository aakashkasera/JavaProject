package com.app;

import com.app.model.Product;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.cart.service.CartService;
import com.app.cart.service.impl.CartServiceImpl;
import com.app.customer.service.CustomerService;
import com.app.customer.service.impl.CustomerServiceImpl;
import com.app.exception.BusinessException;
import com.app.login.service.CustomerLoginService;
import com.app.login.service.EmployeeLoginService;
import com.app.login.service.impl.CustomerLoginServiceImpl;
import com.app.login.service.impl.EmployeeLoginServiceImpl;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.product.service.ProductService;
import com.app.product.service.impl.ProductServiceImpl;

public class Main {
	private static Logger log=Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to Shopping app");
		log.info("==========================================");
		
		int ch=0;
		do {
			
			log.info("\nMain menu");
			log.info("1) Login a Customer");
			log.info("2) Login a Employee");
			log.info("3) Register as Customer");
			log.info("4) EXIT ");
			log.info("Please enter your choice(1-4)");
			
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch(ch) {
			
			case 1:
				log.info("Enter email id:");
				String emailId=scanner.nextLine();
				CustomerLoginService customerLoginService=new CustomerLoginServiceImpl();
				Boolean b=false;
				try {
					b = customerLoginService.isValidEmailId(emailId);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				if(b) {
					
					log.info("Enter Password :");
				String password=scanner.nextLine();
				try {
					b = customerLoginService.isValidPassword(password);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("login succssfully");
				
				// After login
				Customer customer=null;
				try {
					customer=customerLoginService.getCustomerByEmailId(emailId);
					if(customer!=null) log.info("Welcome "+customer.getFirstName()+" "+customer.getLastName()+",What you want to do?");
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int option=0;
				do {
					log.info("1) Search Product.");
					log.info("2) View ordes.");
					log.info("3) Logout.");
					log.info("Enter your choice :");
					
					try {
					option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						
					}
					switch(option) {
					
					case 1:
						int ps=0;
						
						ProductService productService=new ProductServiceImpl();
						
						do {
						log.info("Welcome to Product search (you can serch a product from various criteria from below menu)");
						log.info("1) By Name");
						log.info("2) By Manufacturer Name");
						log.info("3) By Category");
						log.info("4) Previous Menu");
						log.info("5) View Cart");
						log.info("6) Logout");
						
						try {
							ps= Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								
							}
						switch(ps)
						{
						
						case 1:
							
							log.info("Enter Product Name :");
							
							try {
								String name=scanner.nextLine();
								List<Product> productList=productService.getProductByName(name);
								if(productList!=null && productList.size()>0) {
									
									log.info(productList.size()+" - "+name);
									for(Product product:productList)
									{
										log.info(product);
									}
									
									int a=0;
									
									do {
										log.info("1) Add any product to cart.");
										log.info("2) Previous Menu");
										
									
									
									try {
										a= Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											
										}
									switch(a) {
									
									case 1:
										log.info("Enter Product Id to add it to cart");
										
										CartService cartService=new CartServiceImpl();
										
										
											int productId= Integer.parseInt(scanner.nextLine());
											Cart cart=new Cart(productId,customer.getId());
											
										
										try {
											
											if(cartService.addProductToCart(cart)==1) {
												log.info("Product " +cart.getProductId()+" added to cart successfully \n");
											}
											
										}catch(BusinessException e) {
											e.printStackTrace();
										}
										break;
										
									case 2:
										break;
										
									default:
										log.info("Invalid choice.... choose only number 1-2");
									
									}
									
								}while(a!=2);
									
								}else {
									log.info("No Such Product Name ");
								}
							}catch (BusinessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
							
						case 2:
							
							log.info("Enter Manufacturer Name :");
							
							try {
								String manufacturerName=scanner.nextLine();
								List<Product> productList=productService.getProductByManufacturerName(manufacturerName);
								if(productList!=null && productList.size()>0) {
									
									log.info(productList.size()+" - "+manufacturerName);
									for(Product product:productList)
									{
										log.info(product);
									}
									
									int a=0;
									
									do {
										log.info("1) Add any product to cart.");
										log.info("2) Previous Menu");
							
									try {
										a= Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											
										}
									switch(a) {
									
									case 1:
										log.info("Enter Product Id to add it to cart");
										
										CartService cartService=new CartServiceImpl();
										
											int productId= Integer.parseInt(scanner.nextLine());
											Cart cart=new Cart(productId,customer.getId());
											
										try {
											
											if(cartService.addProductToCart(cart)==1) {
												log.info("Product " +cart.getProductId()+" added to cart successfully\n ");
											}
											
										}catch(BusinessException e) {
											e.printStackTrace();
										}
										break;
										
									case 2:
										break;
										
									default:
										log.info("Invalid choice.... choose only number 1-2");
									
									}
									
								}while(a!=2);
									
								}else {
									
									log.info("No such Manufacturer Name");
								}
							}catch (BusinessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							break;
							
						case 3:
							
							log.info("Enter Category :");
							
							try {
								String category=scanner.nextLine();
								List<Product> productList=productService.getProductByCategory(category);
								
								if(productList!=null && productList.size()>0) {
									
									log.info(productList.size()+" - "+category);
									for(Product product:productList)
									{
										log.info(product);
									}
								
									int a=0;
									
									do {
										log.info("1) Add any product to cart.");
										log.info("2) Previous Menu");
										
									
									
									try {
										a= Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											
										}
									switch(a) {
									
									case 1:
										log.info("Enter Product Id to add it to cart");
										
										CartService cartService=new CartServiceImpl();
										
											int productId= Integer.parseInt(scanner.nextLine());
											Cart cart=new Cart(productId,customer.getId());
											
										try {
											
											if(cartService.addProductToCart(cart)==1) {
												log.info("Product " +cart.getProductId()+" added to cart successfully\n ");
											}
											
										}catch(BusinessException e) {
											e.printStackTrace();
										}
										break;
										
									case 2:
										break;
										
									default:
										log.info("Invalid choice.... choose only number 1-2");
									
									}
									
								}while(a!=2);
									
								}else {
									log.info("No such category found");
								}
								
							}catch (BusinessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							break;
							
						case 4:
							log.info("Back to previous menu");
							break;
							
						case 5:
							CartService cartService=new CartServiceImpl();
							log.info("\n");
							try {
								List<Cart> cartList=cartService.viewCart(customer.getId());
								if(cartList!=null && cartList.size()>0) {
									log.info("List of product in cart :\n");
									for(Cart cart:cartList){
										log.info(cart);
									}
								}
							}catch(BusinessException e) {
								e.printStackTrace();
							}
							log.info("view cart under construction");
							
						case 6:
							option=3;
							log.info("Thanks");
							break;
							
						default:
							log.info("Invalid choice...... choose a number between 1-6");
							break;
						}
						
						}while(ps!=4 && ps!=6);
						break;
						
					case 2:
						log.info("View orders under construction");
						
					case 3:
						log.info("Thanks");
						break;
						
					default:
						log.info("Invalid Input ..... Choose a number between 1-3");
					
					}
					
				}while(option!=3);
				
				
				
				}
					
				log.info("Under construction");
				break;
				
				
			case 2:

				log.info("Enter email id:");
				emailId=scanner.nextLine();
				EmployeeLoginService employeeLoginService=new EmployeeLoginServiceImpl();
				b=false;
				try {
					b = employeeLoginService.isValidEmailId(emailId);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				if(b) {
					
					log.info("Enter Password :");
				String password=scanner.nextLine();
				try {
					b = employeeLoginService.isValidPassword(password);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(b) {
				log.info("login succssfully");
				
				Employee employee=null;
				try {
					employee=employeeLoginService.getEmployeeByEmailId(emailId);
					if(employee!=null) log.info("Welcome "+employee.getFirstName()+" "+employee.getLastName());
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				}
				
				break;
				
			case 3:
				CustomerService customerService=new CustomerServiceImpl();
				log.info("Register as New User\n");
				log.info("Enter EmailId :");
				emailId=scanner.nextLine();
				log.info("Enter First Name :");
				String firstName=scanner.nextLine();
				log.info("Enter Last Name");
				String lastName=scanner.nextLine();
				log.info("Enter Password :");
				String password=scanner.nextLine();
				Customer customer =new Customer(emailId,firstName,lastName,password);
				
				try {
					
					if(customerService.createCustomer(customer)==1) {
						log.info("Customer Created Successfully with below details :\n");
						log.info(customer);
					}
					
				}catch(BusinessException e) {
					e.printStackTrace();
				}
				
				break;
			case 4:
				
				break;
			default:
				log.info("Invalid ..... choose only number between 1-4");;
				break;
			}
			
		}while(ch!=4);
		
		
		
	}

}
