package com.tr.dagdem.service.dealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.dealer.DealerDAO;
import com.tr.dagdem.model.dealer.SaticiTanimTable;
import com.tr.dagdem.service.BaseServisImpl;

@Service
@Qualifier("dealerService")
public class DealerServiceImpl extends BaseServisImpl implements DealerService{

	@Autowired
	private DealerDAO dealerDAO;
	
	public List<SaticiTanimTable> saticilariGetir() 
	{
		return dealerDAO.saticilariGetir();
	}

	@Override
	protected GenericDAO getDAO() 
	{
		return dealerDAO;
	}

}
