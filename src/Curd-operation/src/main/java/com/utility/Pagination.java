package com.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination 
{
 public Pageable getPagination(String pagenNo, String size)
 
 {
	 return PageRequest.of(Integer.parseInt(pagenNo)- 1,Integer.parseInt(size));
 }

public Pagination() {
	super();
	
}
 
}
