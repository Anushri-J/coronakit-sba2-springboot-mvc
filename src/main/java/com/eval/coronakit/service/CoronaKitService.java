package com.eval.coronakit.service;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.exception.CkException;

public interface CoronaKitService {
	public CoronaKit saveKit(CoronaKit kit) throws CkException;
	public CoronaKit getKitById(int kitId);
}
