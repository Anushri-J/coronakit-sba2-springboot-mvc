package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.CkException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	@Transactional
	public KitDetail addKitItem(KitDetail kitItem) throws CkException {
		if(kitItem!=null) {
			if(repository.existsById(kitItem.getId())) {
				throw new CkException("Item code already used");
			}
			repository.save(kitItem);
		}
		
		return kitItem;
	}
	
	@Override
	@Transactional
	public KitDetail save(KitDetail kitItem) throws CkException {
		if(kitItem!=null) {
			return repository.save(kitItem);
		}
		return kitItem;
	}

	@Override
	@Transactional
	public KitDetail getKitItemById(int itemId) {
		return repository.findById(itemId).orElse(null);
	}

	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		return repository.findAll();
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit() {
		return repository.findAll();
	}

}
