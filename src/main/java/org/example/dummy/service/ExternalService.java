package org.example.dummy.service;

/*
 *  The Impl class implement the query calls to External API.  
 */
public interface ExternalService {
	/**
	 * Get  contents from External API.
	 * 
	 * @param queryParam
	 * @return
	 */
	public Object getContent(String queryParam);
	
}
