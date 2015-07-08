package com.tr.dagdem.dao.customer;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.customer.MusteriTanimTable;

@Repository
@Qualifier("customerDAO")
public class CustomerDAOImpl extends GenericDAOImpl implements CustomerDAO {

	public MusteriTanimTable musteriSorgula(long musteriNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriTanimTable> musterileriGetir()
	{
		return getSession().createCriteria(MusteriTanimTable.class).addOrder(Order.asc("id")).list();
	}
}
