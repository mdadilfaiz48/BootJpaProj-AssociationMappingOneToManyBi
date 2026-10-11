package com.adil.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adil.service.ICustomerMgmtService;

@Component
public class AssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * try { String msg = custService.saveDataUsingParent();
		 * System.out.println(msg); }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { String msg = custService.saveDataUsingChild(); System.out.println(msg);
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { custService.loadDataUsingParent(); }catch(Exception e) {
		 * e.printStackTrace(); }
		 */

		/*
		 * try { custService.loadDataUsingChild();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { custService.deleteDataUsingParent();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { custService.deleteAllChildOfParent();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { custService.addNewChildToExistingChildOfAParent();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try { custService.addNewChildToExistingChildOfAParent();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		try {

			custService.showParentToChildDataUsingJoins().forEach(row -> {

				System.out.println(Arrays.toString(row));
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
