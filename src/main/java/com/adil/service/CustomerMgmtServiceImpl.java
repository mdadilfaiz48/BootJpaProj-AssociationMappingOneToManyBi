package com.adil.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.entity.Customer;
import com.adil.entity.PhoneNumber;
import com.adil.repository.ICutomerRepository;
import com.adil.repository.IPhonesRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICutomerRepository custRepo;
	@Autowired
	private IPhonesRepository phoneRepo;

	@Override
	public String saveDataUsingParent() {

		// create parent object
		Customer cust = new Customer("raja", "hyd");
		// create child object
		PhoneNumber pn1 = new PhoneNumber(8888888L, "airtel", "residence");
		PhoneNumber pn2 = new PhoneNumber(9999999L, "jio", "office");
		// set parent to child
		pn1.setCust(cust);
		pn2.setCust(cust);
		// child to parent
		Set<PhoneNumber> childs = Set.of(pn1, pn2);
		cust.setPhonesInfo(childs);
		// save parent to child
		int idVal = custRepo.save(cust).getCno();

		return "parent to child obj are saved with id val " + idVal;
	}

	@Override
	public String saveDataUsingChild() {

		// create parent object
		Customer cust = new Customer("mahesh", "delhi");
		// create child object
		PhoneNumber pn1 = new PhoneNumber(7777777L, "airtel", "residence");
		PhoneNumber pn2 = new PhoneNumber(6666666L, "jio", "office");
		// set parent to child
		pn1.setCust(cust);
		pn2.setCust(cust);
		// child to parent
		Set<PhoneNumber> childs = Set.of(pn1, pn2);
		cust.setPhonesInfo(childs);
		// save object using child
		phoneRepo.saveAll(childs);

		return "child to parents object are saved";
	}

	@Override
	public void loadDataUsingParent() {

		Iterable<Customer> it = custRepo.findAll();
		it.forEach(cust -> {
			System.out.println("parent::" + cust);
			// associated child object
			/*
			 * Set<PhoneNumber> childs = cust.getPhonesInfo(); childs.forEach(ph->{
			 * System.out.println("child ::"+ph); });
			 */
		});

	}

	@Override
	public void loadDataUsingChild() {

		Iterable<PhoneNumber> it = phoneRepo.findAll();
		it.forEach(ph -> {
			System.out.println("child :" + ph);
			// get the associated parent
			/*
			 * Customer cust = ph.getCust(); System.out.println("perant :"+cust);
			 */
		});

	}

	@Override
	public void deleteDataUsingParent() {

		// Load parent object
		Optional<Customer> opt = custRepo.findById(1000);
		if (opt.isPresent()) {
			// get customer object
			Customer cust = opt.get();
			custRepo.delete(cust);
			System.out.println("Customer and his phone number is deleted");
		} else {
			System.out.println("Customer is not found");
		}

	}

	@Override
	public void deleteAllChildOfParent() {

		// Load parent object
		Optional<Customer> opt = custRepo.findById(1002);
		if (opt.isPresent()) {
			// get customer object
			Customer cust = opt.get();
			// get child of a parent
			Set<PhoneNumber> childs = cust.getPhonesInfo();
			// nullify parent from the child
			childs.forEach(ph->{
				ph.setCust(null);
			});
			// deletes all child
			phoneRepo.deleteAllInBatch(childs);
			System.out.println("All the childs of a parent are deleted");
			
		}else {
			System.out.println("Parent not found");
		}
	}

	@Override
	public void addNewChildToExistingChildOfAParent() {
		
		// Load parent object
				Optional<Customer> opt = custRepo.findById(1002);
				if (opt.isPresent()) {
					// get customer object
					Customer cust = opt.get();
					// get existing child of parent
					Set<PhoneNumber> childs = cust.getPhonesInfo();
					// create new phone number
					PhoneNumber ph = new PhoneNumber(7777777L,"vi","personal");
					// set new child to the parent
					ph.setCust(cust);
					// add new child to existing child and update the child
					childs.add(ph);
					custRepo.save(cust);
					System.out.println("new childs is added to existing child of parent");
					
				}else {
					System.out.println("Parent not found");
				}
		
	}

	@Override
	public void deleteDataUsingChild() {
		
		// Load parent object
		Optional<Customer> opt = custRepo.findById(1001);
		if (opt.isPresent()) {
			// get customer object
			Customer cust = opt.get();
			// get all child of a parent
			Set<PhoneNumber> childs = cust.getPhonesInfo();
			// delete all childs
			childs.forEach(ph->{
				phoneRepo.delete(ph);
			});
			System.out.println("All childs its associated parent is deleted");
			
		}else {
			System.out.println("Parent not found");
		}
	}

	@Override
	public List<Object[]> showParentToChildDataUsingJoins() {
		
		// use repo 
		
		return custRepo.fetchParentsToChildsDataUsingJoins();
	}

}
