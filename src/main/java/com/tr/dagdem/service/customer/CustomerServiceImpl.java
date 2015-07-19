package com.tr.dagdem.service.customer;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.customer.CustomerDAO;
import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.service.BaseServisImpl;
import com.tr.dagdem.wsmodel.Customer;


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
	
	@Transactional
	public List<Customer> getCustomers()
	{
		List<Customer> customerList = Lists.newArrayList();
		List<MusteriTanimTable> musteriler = customerDAO.musterileriGetir();
		
		for(MusteriTanimTable musteri:musteriler)
		{
			Customer customer = new Customer();
			customer.setCustomerId(musteri.getId().toString());
			customer.setCustomerNo(musteri.getMusteriNo());
			customer.setName(musteri.getMusteriAdi());
			customer.setLastName(musteri.getMusteriSoyadi());
			customer.setGsmNo(musteri.getGsm()!=null?musteri.getGsm().toString():"");
			customerList.add(customer);
		}
		return customerList;
	}
	
	@Transactional
	public void createCustomer(Customer customer)
	{
		MusteriTanimTable musteri = new MusteriTanimTable();
		musteri.setMusteriAdi(customer.getName());
		musteri.setMusteriSoyadi(customer.getLastName());
		musteri.setAktif(true);
		musteri.setTarih(new Date());
		musteri.setGsm(StringUtils.isNotBlank(customer.getGsmNo())?new Long(customer.getGsmNo()):null);
		getDAO().saveOrUpdate(musteri);
	}
	
	@Transactional
	public void updateCustomer(Customer customer)
	{
		MusteriTanimTable musteri = getDAO().findById(MusteriTanimTable.class, customer.getCustomerNo());
		musteri.setMusteriAdi(customer.getName());
		musteri.setMusteriSoyadi(customer.getLastName());
		musteri.setAktif(true);
		musteri.setGuncellemeTarihi(new Date());
		musteri.setGsm(StringUtils.isNotBlank(customer.getGsmNo())?new Long(customer.getGsmNo()):null);
		getDAO().saveOrUpdate(musteri);
	}
	
	@Override
	protected GenericDAO getDAO() 
	{
		return customerDAO;
	}
	
}
