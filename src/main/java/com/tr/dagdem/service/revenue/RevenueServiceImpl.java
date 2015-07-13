package com.tr.dagdem.service.revenue;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.revenue.RevenueDAO;
import com.tr.dagdem.model.revenue.TahsilatTable;
import com.tr.dagdem.service.BaseServisImpl;

@Service
@Qualifier("revenueService")
public class RevenueServiceImpl extends BaseServisImpl implements RevenueService {
	
	@Autowired
	private RevenueDAO revenueDAO;
	
	public void tahsilatKaydet(TahsilatTable tahsilatTable) 
	{
		revenueDAO.saveOrUpdate(tahsilatTable);
	}

	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriKodu)
	{
		return revenueDAO.musteridenYapilanTahsilatTutariSorgula(musteriKodu);	
	}
	
	public BigDecimal musteriBorcuSorgula(long musteriKodu)
	{
		return revenueDAO.musteriBorcuSorgula(musteriKodu);	
	}
	
	@Override
	protected GenericDAO getDAO() {
		return revenueDAO;
	}
	
//	@Resource(name="revenueDAO")
//	public void setRevenueDAO(RevenueDAO revenueDAO) {
//		this.revenueDAO = revenueDAO;
//	}
}
