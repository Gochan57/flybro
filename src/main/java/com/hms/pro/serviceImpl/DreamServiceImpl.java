package com.hms.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.pro.dao.DreamDao;
import com.hms.pro.model.Dream;
import com.hms.pro.service.DreamService;

@Service
@Transactional
public class DreamServiceImpl implements DreamService {

	@Autowired
	private DreamDao dreamDao;

	@Override
	@Transactional
	public void addDream(Dream dream) {
		dreamDao.addDream(dream);
	}

	@Override
	@Transactional
	public void updateDream(Dream dream) {
		dreamDao.updateDream(dream);
	}

	@Override
	@Transactional
	public void removeDream(int id) {
		dreamDao.removeDream(id);
	}

	@Override
	@Transactional
	public Dream getDreamBuId(int id) {
		return dreamDao.getDreamBuId(id);
	}

	@Override
	@Transactional
	public List<Dream> listDreams() {
		return dreamDao.listDreams();
	}

	public DreamDao getDreamDao() {
		return dreamDao;
	}

	public void setDreamDao(DreamDao dreamDao) {
		this.dreamDao = dreamDao;
	}

}
