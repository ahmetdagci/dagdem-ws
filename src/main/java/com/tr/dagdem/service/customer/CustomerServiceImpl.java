package com.tr.dagdem.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.customer.CustomerDAO;
import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.service.BaseServisImpl;


@Service
@Qualifier("customerService")
public class CustomerServiceImpl extends BaseServisImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<MusteriTanimTable> musterileriGetir()
	{
		return customerDAO.musterileriGetir();
	}
	
	public MusteriTanimTable musteriSorgula(long musteriNo)
	{
		return getDAO().findById(MusteriTanimTable.class, musteriNo);
	}
	
	
	public void musteriKaydet(MusteriTanimTable musteri)
	{
		getDAO().saveOrUpdate(musteri);
	}
	
	@Override
	protected GenericDAO getDAO() 
	{
		return customerDAO;
	}
	
//	@Resource(name="customerDAO")
//	public void setCustomerDAO(CustomerDAO customerDAO) {
//		this.customerDAO = customerDAO;
//	}
}
