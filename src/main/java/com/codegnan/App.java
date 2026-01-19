package com.codegnan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.bean.Governer;
import com.codegnan.bean.State;

public class App {
	public static void main(String[] args) {

		StandardServiceRegistry registry = null;
		SessionFactory sessionFactory = null;
		try {
			registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();

			try (Session session = sessionFactory.openSession()) {
//				Transaction tx = session.beginTransaction();
//				Address address = new Address("Hyderabad", "Telangana", "500001");
//				Governer governer = new Governer("Jishnu Dev Varma", 400000);
//				address.setGoverner(governer);
//				governer.setAddress(address);
//				session.save(governer);
//				tx.commit();
//				System.out.println("Record inserted succesfully");
//				System.out.println(governer);
				
				// reteriving single record
//				System.out.println("Retreiving Governer and Address");
//				Governer gov = session.get(Governer.class, 1);
//				if(gov!=null) {
//					System.out.println("Governer Id: "+gov.getGovId());
//					System.out.println("Governer Name: "+gov.getGovName());
//					System.out.println("Governer Salary: "+gov.getGovSalary());
//					Address addr = gov.getAddress();
//					if(addr!=null) {
//						System.out.println("Address Details");
//						System.out.println("City: "+addr.getCity());
//						System.out.println("State: "+addr.getState());
//						System.out.println("Pin Code: "+addr.getPincode());
//					} else {
//						System.out.println("No Address Found for this Governer");
//					}
//				} else {
//					System.out.println("Governer not found");
//				}
				
//				State state = new State("Governers");
//				Governer g1 = new Governer("Ravi kumar", 400000);
//				Governer g2 = new Governer("Ravi", 500000);
//				Governer g3 = new Governer("Varma", 900000);
//				state.addGoverner(g1);
//				state.addGoverner(g2);
//				state.addGoverner(g3);
//				session.save(state);
//				tx.commit();
//				System.out.println("one to many Records inserted Successfully");
				
				System.out.println("Reteriving state and Governer");
				State state=session.get(State.class, 1);
				if(state!=null) {
				System.out.println("State id: "+state.getStateId());
				System.out.println("State Name: "+state.getStateName());
				List<Governer> gov= state.getGoverners();
				for(Governer governer :gov) {
					System.out.println(governer);
				}
				} else {
					System.out.println("State not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
	}
}
