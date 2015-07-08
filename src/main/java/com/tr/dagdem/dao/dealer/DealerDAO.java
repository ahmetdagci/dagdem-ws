package com.tr.dagdem.dao.dealer;

import java.util.List;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.dealer.SaticiTanimTable;

public interface DealerDAO extends GenericDAO{

	public List<SaticiTanimTable> saticilariGetir();
}
