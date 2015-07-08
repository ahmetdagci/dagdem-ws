package com.tr.dagdem.dao.dealer;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.dealer.SaticiTanimTable;

@Repository
@Qualifier("dealerDAO")
public class DealerDAOImpl extends GenericDAOImpl implements DealerDAO{
	
	@SuppressWarnings("unchecked")
	public List<SaticiTanimTable> saticilariGetir()
	{
		return (List<SaticiTanimTable>)getSession().createCriteria(SaticiTanimTable.class)
					.add(Restrictions.eq("aktif", true))
					.list();
	}
}
