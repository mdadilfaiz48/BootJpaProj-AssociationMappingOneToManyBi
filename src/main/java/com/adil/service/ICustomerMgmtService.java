package com.adil.service;

import java.util.List;

public interface ICustomerMgmtService {
  
	public String saveDataUsingParent();
	
	public String saveDataUsingChild();
	
	public void loadDataUsingParent();
	
	public void loadDataUsingChild();
	
	public void deleteDataUsingParent();
	
	public void deleteAllChildOfParent();
	
	public void addNewChildToExistingChildOfAParent();
	
	public void deleteDataUsingChild();
	
	public List<Object[]> showParentToChildDataUsingJoins();
}
