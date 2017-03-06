package com.hms.pro.service;

import java.util.List;

import com.hms.pro.model.Dream;

public interface DreamService {

	public void addDream(Dream dream);

	public void updateDream(Dream dream);

	public void removeDream(int id);

	public Dream getDreamBuId(int id);

	public List<Dream> listDreams();

}
