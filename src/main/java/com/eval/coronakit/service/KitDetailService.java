package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.CkException;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem) throws CkException;
	public KitDetail getKitItemById(int itemId);
	public List<KitDetail> getAllKitItemsOfAKit();
	KitDetail save(KitDetail kitItem) throws CkException;
}
